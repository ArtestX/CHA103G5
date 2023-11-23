package com.cha103g5.informationannouncement.dao;

import com.cha103g5.informationannouncement.model.InformationAnnouncementVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationAnnouncementRepository extends JpaRepository<InformationAnnouncementVO, Integer> {
}
