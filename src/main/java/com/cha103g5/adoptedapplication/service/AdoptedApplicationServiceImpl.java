package com.cha103g5.adoptedapplication.service;

import com.cha103g5.adoptedapplication.dao.AdoptedApplicationDao;
import com.cha103g5.adoptedapplication.dto.AdoptedApplicationQueryParams;
import com.cha103g5.adoptedapplication.dto.AdoptedApplicationRequest;
import com.cha103g5.adoptedapplication.model.AdoptedApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public class AdoptedApplicationServiceImpl implements AdoptedApplicationService {

    @Autowired
    private AdoptedApplicationDao adoptedApplicationDao;

    @Override
    public Integer countAdoptedApplication(AdoptedApplicationQueryParams adoptedApplicationQueryParams) {
        return adoptedApplicationDao.countAdoptedApplication(adoptedApplicationQueryParams);
    }

    @Override
    public List<AdoptedApplication> getAll(AdoptedApplicationQueryParams adoptedApplicationQueryParams) {
        return adoptedApplicationDao.getAll(adoptedApplicationQueryParams);
    }

//    @Override
//    public List<AdoptedApplication> getByPetIdAndLotteryDate(Integer petId, Date lotteryDate) {
//        return adoptedApplicationDao.getByPetIdAndLotteryDate(petId, lotteryDate);
//    }

    @Override
    public AdoptedApplication getById(Integer applicationNo) {
        return adoptedApplicationDao.getById(applicationNo);
    }

    @Override
    public Integer createAdoptedApplication(AdoptedApplicationRequest adoptedApplicationRequest) {
        return adoptedApplicationDao.createAdoptedApplication(adoptedApplicationRequest);
    }

    @Override
    public void updateAdoptedApplication(Integer applicationNo,
                                         AdoptedApplicationRequest adoptedApplicationRequest) {
        adoptedApplicationDao.updateAdoptedApplication(applicationNo, adoptedApplicationRequest);
    }

    @Override
    public void deleteAdoptedApplication(Integer applicationNo) {
        adoptedApplicationDao.deleteAdoptedApplication(applicationNo);
    }
}
