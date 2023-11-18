package com.cha103g5.membernotice.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberNoticeService {

    private final MemberNoticeRepository memberNoticeRepository;

    @Autowired
    public MemberNoticeService(MemberNoticeRepository memberNoticeRepository) {
        this.memberNoticeRepository = memberNoticeRepository;
    }

    public MemberNoticeVO getMemberNoticeById(Integer memberno) {
        return memberNoticeRepository.findById(memberno).orElse(null);
    }

    public List<MemberNoticeVO> getAllMemberNotices() {
        return memberNoticeRepository.findAll();
    }
    
    

    
}
