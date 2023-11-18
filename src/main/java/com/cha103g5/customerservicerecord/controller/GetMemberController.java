package com.cha103g5.customerservicerecord.controller;

import com.cha103g5.member.model.MemberVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class GetMemberController {

    @GetMapping("/getMember")
    @ResponseBody
    public ResponseEntity<Map<String, String>> getMember(HttpSession session) {
        System.out.println("成功getMember");
        try {
            // 獲取整個 user 物件
            MemberVO memberVO = (MemberVO) session.getAttribute("user");

            if (memberVO != null) {
                String memberName = memberVO.getMembername();
                String memberEmail = memberVO.getMemberemail();
                String memberNo = String.valueOf(memberVO.getMemberno());

                System.out.println(memberName);
                System.out.println(memberEmail);
                if (memberName != null) {
                    // 直接返回包含memberNo memberemail 和 memberName 的 JSON 物件
                    Map<String, String> memberData = new HashMap<>();
                    memberData.put("memberNo",memberNo);
                    memberData.put("memberEmail", memberEmail);
                    memberData.put("memberName", memberName);
                    return ResponseEntity.ok(memberData);
                } else {
                    // 如果memberEmail為null，返回HTTP 401
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
                }
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        } catch (Exception e) {
            // 處理異常，例如日誌記錄
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
