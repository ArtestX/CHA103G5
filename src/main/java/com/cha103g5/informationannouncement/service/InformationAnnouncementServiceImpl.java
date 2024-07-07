package com.cha103g5.informationannouncement.service;

import com.cha103g5.informationannouncement.dao.InformationAnnouncementRepository;
import com.cha103g5.informationannouncement.model.InformationAnnouncementVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationAnnouncementServiceImpl implements InformationAnnouncementService {

    @Autowired
    private InformationAnnouncementRepository infoRepository;

    @Override
    public Boolean addInformationAnnouncement(InformationAnnouncementVO info) {

        try {
            info.setInfoNo(info.getInfoNo());
            info.setAdminNo(info.getAdminNo());
            info.setInfoContent(info.getInfoContent());
            info.setInfoTitle(info.getInfoTitle());
            info.setInfoTime(info.getInfoTime());

            infoRepository.save(info);
        } catch (Exception e) {
            System.out.println("新增公告錯誤");
            return false;
        }
        return true;
    }

    @Override
    public InformationAnnouncementVO getInformationAnnouncementById(Integer infoNo) {

        return infoRepository.findById(infoNo).orElse(null);
    }

    @Override
    public List<InformationAnnouncementVO> getAllInformationAnnouncements() {
//        查找到的資料降冪排序
        Sort sort = Sort.by(Sort.Direction.DESC, "infoTime");
        return infoRepository.findAll(sort);
    }
    @Override
    public List<InformationAnnouncementVO> getAllInformationFiveAnnouncements() {
        // 建立分頁請求，取得最後5筆資料
        PageRequest pageRequest = PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "infoTime"));

        // 使用分頁查詢
        return infoRepository.findAll(pageRequest).getContent();
    }

    @Override
    public void updateInformationAnnouncement(InformationAnnouncementVO info) {
        infoRepository.save(info);
    }

    @Override
    public void deleteInformationAnnouncement(Integer infoNo) {
        infoRepository.deleteById(infoNo);
    }
}
