package com.cha103g5.product_picture.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

    private Path fileStorageLocation;
    private final long maxFileSize = 10 * 1024 * 1024; // 例如，限制為10MB
    private final List<String> allowedFileExtensions = Arrays.asList(".jpg", ".png", ".gif");

    @Value("${file.storage.directory}")
    private String fileStorageDirectory;

    @PostConstruct
    public void init() {
        this.fileStorageLocation = Paths.get(fileStorageDirectory).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public FileStorageService() {
        // 構造函數不再需要初始化代碼
    }

    public String storeFile(MultipartFile file) {
        // 檢查文件大小
        if (file.getSize() > maxFileSize) {
            throw new RuntimeException("File size exceeds the permissible limit.");
        }

        // 檢查文件類型
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileExtension = getFileExtension(fileName);

        if (!allowedFileExtensions.contains(fileExtension.toLowerCase())) {
            throw new RuntimeException("File type is not supported.");
        }

        // 添加唯一標識符
        String uniqueFileName = UUID.randomUUID().toString() + fileExtension;

        try {
            // 將文件保存到目標位置
            Path targetLocation = this.fileStorageLocation.resolve(uniqueFileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return uniqueFileName;
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + uniqueFileName + ". Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new RuntimeException("File not found " + fileName, ex);
        }
    }

    public List<String> loadAllFiles() {
        try {
            return Files.walk(this.fileStorageLocation, 1)
                    .filter(path -> !path.equals(this.fileStorageLocation))
                    .map(this.fileStorageLocation::relativize)
                    .map(Path::toString)
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            throw new RuntimeException("Could not read the files!", ex);
        }
    }

    public void deleteFile(String fileName) {
        try {
            Path file = this.fileStorageLocation.resolve(fileName).normalize();
            Files.deleteIfExists(file);
        } catch (IOException ex) {
            throw new RuntimeException("Could not delete the file: " + fileName, ex);
        }
    }

    private String getFileExtension(String fileName) {
        try {
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (Exception e) {
            return "";
        }
    }
}
