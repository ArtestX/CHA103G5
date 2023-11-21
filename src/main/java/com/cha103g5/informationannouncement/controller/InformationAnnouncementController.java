package com.cha103g5.informationannouncement.controller;

import com.cha103g5.informationannouncement.model.InformationAnnouncementVO;
import com.cha103g5.informationannouncement.service.InformationAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class InformationAnnouncementController {

    @Autowired
    private InformationAnnouncementService informationAnnouncementService;

    // 新增公告
    @PostMapping("/CHA103G5/informationannouncement")
    public void addInformationAnnouncement(@RequestBody @Valid InformationAnnouncementVO info) {
        informationAnnouncementService.addInformationAnnouncement(info);
    }

    // 查詢公告
    @GetMapping("/CHA103G5/informationannouncement/{infoNo}")
    public InformationAnnouncementVO getInformationAnnouncementById(@PathVariable @Valid Integer infoNo) {
        return informationAnnouncementService.getInformationAnnouncementById(infoNo);
    }

    // 查詢全部公告
    @GetMapping("/CHA103G5/informationannouncement")
    public List<InformationAnnouncementVO> getAllInformationAnnouncements() {
        return informationAnnouncementService.getAllInformationAnnouncements();
    }

    // 更新公告
    @PutMapping("/CHA103G5/informationannouncement/{infoNo}")
    public ResponseEntity<String> updateInformationAnnouncement(@PathVariable @Valid Integer infoNo,
                                                                @RequestBody @Valid InformationAnnouncementVO info) {
        InformationAnnouncementVO existingInfo = informationAnnouncementService.getInformationAnnouncementById(infoNo);

        if (existingInfo == null) {
            // 公告不存在，返回错误訊息
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("公告不存在");
        }

        // 更新现有公告
        informationAnnouncementService.updateInformationAnnouncement(info);

        // 返回成功消息
        return ResponseEntity.status(HttpStatus.OK).body("公告更新成功");
    }

    // 删除公告
    @DeleteMapping
    public ResponseEntity<?> deleteInformationAnnouncement(@PathVariable Integer infoNo) {

        informationAnnouncementService.deleteInformationAnnouncement(infoNo);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
