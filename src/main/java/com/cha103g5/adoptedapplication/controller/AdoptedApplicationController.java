package com.cha103g5.adoptedapplication.controller;

import com.cha103g5.adoptedapplication.dto.AdoptedApplicationQueryParams;
import com.cha103g5.adoptedapplication.dto.AdoptedApplicationRequest;
import com.cha103g5.adoptedapplication.model.AdoptedApplication;
import com.cha103g5.adoptedapplication.service.AdoptedApplicationService;
import com.cha103g5.adoptedapplication.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Date;

@Validated
@RestController
public class AdoptedApplicationController {

    @Autowired
    private AdoptedApplicationService adoptedApplicationService;

    @GetMapping("/adoptedapplications")
    public ResponseEntity<Page<AdoptedApplication>> getAll(
            // 查詢條件 Filtering
            @RequestParam(required = false) Integer petId,
            @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date lotteryDate,

            //排序 Sorting
            @RequestParam(defaultValue = "applicationNo") String orderBy,
            @RequestParam(defaultValue = "asc") String sort,

            // 分頁 Pagination
            @RequestParam(defaultValue = "10") @Max(100) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset
    ) {

        AdoptedApplicationQueryParams adoptedApplicationQueryParams = new AdoptedApplicationQueryParams();
        adoptedApplicationQueryParams.setPetId(petId);
        adoptedApplicationQueryParams.setLotteryDate(lotteryDate);
        adoptedApplicationQueryParams.setOrderBy(orderBy);
        adoptedApplicationQueryParams.setSort(sort);
        adoptedApplicationQueryParams.setLimit(limit);
        adoptedApplicationQueryParams.setOffset(offset);

//        java.sql.Date sqlLotteryDate = null;
//        if (lotteryDate != null) {
//            // 手動將 java.util.Date 轉換為 java.sql.Date
//            sqlLotteryDate = new java.sql.Date(lotteryDate.getTime());
//            adoptedApplicationQueryParams.setLotteryDate(sqlLotteryDate);
//        }

        // 取得 領養 List
        List<AdoptedApplication> adoptedApplicationList = adoptedApplicationService.getAll(adoptedApplicationQueryParams);

        // 取得 領養 總數
        Integer total = adoptedApplicationService.countAdoptedApplication(adoptedApplicationQueryParams);

        // 分頁
        Page<AdoptedApplication> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(adoptedApplicationList);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }


//    @GetMapping("/adoptedapplications")
//    public ResponseEntity<List<AdoptedApplication>> getByPetIdAndLotteryDate(
//            @RequestParam Integer petId,
//            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date lotteryDate) {
//
//        // 手動將 java.util.Date 轉換為 java.sql.Date
//        java.sql.Date sqlLotteryDate = new java.sql.Date(lotteryDate.getTime());
//
//        List<AdoptedApplication> adoptedApplicationList = adoptedApplicationService.getByPetIdAndLotteryDate(petId, sqlLotteryDate);
//
//        if (adoptedApplicationList != null && !adoptedApplicationList.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.OK).body(adoptedApplicationList);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }

    @GetMapping("/adoptedapplications/{applicationNo}")
    public ResponseEntity<AdoptedApplication> getById(@PathVariable Integer applicationNo) {
        AdoptedApplication adoptedApplication = adoptedApplicationService.getById(applicationNo);

        if (adoptedApplication != null) {
            return ResponseEntity.status(HttpStatus.OK).body(adoptedApplication);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/adoptedapplications")
    public ResponseEntity<AdoptedApplication> createAdoptedApplication(@RequestBody AdoptedApplicationRequest adoptedApplicationRequest) {
        Integer applicationNo = adoptedApplicationService.createAdoptedApplication(adoptedApplicationRequest);

        AdoptedApplication adoptedApplication = adoptedApplicationService.getById(applicationNo);

        return ResponseEntity.status(HttpStatus.CREATED).body(adoptedApplication);
    }

    @PutMapping("/adoptedapplications/{applicationNo}")
    public ResponseEntity<AdoptedApplication> updateAdoptedApplication(@PathVariable Integer applicationNo,
                                                                       @RequestBody AdoptedApplicationRequest adoptedApplicationRequest) {
        // 檢查 申請表 是否存在
        AdoptedApplication adoptedApplication = adoptedApplicationService.getById(applicationNo);

        if (adoptedApplication == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // 修改 申請表 數據
        adoptedApplicationService.updateAdoptedApplication(applicationNo, adoptedApplicationRequest);

        AdoptedApplication updatedAdoptedApplication = adoptedApplicationService.getById(applicationNo);

        return ResponseEntity.status(HttpStatus.OK).body(updatedAdoptedApplication);
    }

    @DeleteMapping("/adoptedapplications/{applicationNo}")
    public ResponseEntity<?> deleteAdoptedApplication(@PathVariable Integer applicationNo) {

        adoptedApplicationService.deleteAdoptedApplication(applicationNo);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
