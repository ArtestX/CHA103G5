package com.cha103g5.adoptedapplication.dao;

import com.cha103g5.adoptedapplication.dto.AdoptedApplicationQueryParams;
import com.cha103g5.adoptedapplication.dto.AdoptedApplicationRequest;
import com.cha103g5.adoptedapplication.model.AdoptedApplication;

import java.util.List;
import java.sql.Date;

public interface AdoptedApplicationDao {

    Integer countAdoptedApplication(AdoptedApplicationQueryParams adoptedApplicationQueryParams);

    List<AdoptedApplication> getAll(AdoptedApplicationQueryParams adoptedApplicationQueryParams);

    AdoptedApplication getById(Integer applicationNo);

    Integer createAdoptedApplication(AdoptedApplicationRequest adoptedApplicationRequest);

    void updateAdoptedApplication(Integer applicationNo,
                                  AdoptedApplicationRequest adoptedApplicationRequest);

    void deleteAdoptedApplication(Integer applicationNo);
}
