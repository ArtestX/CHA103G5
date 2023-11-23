package com.cha103g5.informationannouncement.service;

import com.cha103g5.informationannouncement.dao.InformationAnnouncementRepository;
import com.cha103g5.informationannouncement.model.InformationAnnouncementVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationAnnouncementServiceImpl implements InformationAnnouncementService {

    @Autowired
    private InformationAnnouncementRepository infoRepository;

    @Override
    public void addInformationAnnouncement(InformationAnnouncementVO info) {
        infoRepository.save(info);
    }

    @Override
    public InformationAnnouncementVO getInformationAnnouncementById(Integer infoNo) {
        return infoRepository.findById(infoNo).orElse(null);
    }

    @Override
    public List<InformationAnnouncementVO> getAllInformationAnnouncements() {
        return infoRepository.findAll();
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
