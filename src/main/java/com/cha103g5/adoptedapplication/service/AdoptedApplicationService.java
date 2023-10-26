package com.cha103g5.adoptedapplication.service;

import com.cha103g5.adoptedapplication.dto.AdoptedApplicationQueryParams;
import com.cha103g5.adoptedapplication.dto.AdoptedApplicationRequest;
import com.cha103g5.adoptedapplication.model.AdoptedApplication;

import java.sql.Date;
import java.util.List;

public interface AdoptedApplicationService {

    Integer countAdoptedApplication(AdoptedApplicationQueryParams adoptedApplicationQueryParams);

    List<AdoptedApplication> getAll(AdoptedApplicationQueryParams adoptedApplicationQueryParams);

//    List<AdoptedApplication> getByPetIdAndLotteryDate(Integer petId, Date lotteryDate);

    AdoptedApplication getById(Integer applicationNo);

    Integer createAdoptedApplication(AdoptedApplicationRequest adoptedApplicationRequest);

    void updateAdoptedApplication(Integer applicationNo,
                                  AdoptedApplicationRequest adoptedApplicationRequest);

    void deleteAdoptedApplication(Integer applicationNo);

}
