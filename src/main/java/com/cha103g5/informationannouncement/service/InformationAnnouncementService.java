package com.cha103g5.informationannouncement.service;

import com.cha103g5.informationannouncement.model.InformationAnnouncementVO;

import java.util.List;

public interface InformationAnnouncementService {
    void addInformationAnnouncement(InformationAnnouncementVO info);
    InformationAnnouncementVO getInformationAnnouncementById(Integer infoNo);
    List<InformationAnnouncementVO> getAllInformationAnnouncements();
    void updateInformationAnnouncement(InformationAnnouncementVO info);
    void deleteInformationAnnouncement(Integer infoNo);
}