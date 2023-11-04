package com.cha103g5.customerservicerecord.controller;

import com.cha103g5.member.model.MemberService;
import com.cha103g5.member.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/customer/chat.do")
public class MemberNameServlet extends HttpServlet {

    private MemberService memberService;

    @Override
    public void init() throws ServletException {
        super.init();
        // 在初始化方法中创建 MemberService 实例
        memberService = new MemberService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String memberemail = (String) session.getAttribute("user");

        if (memberemail != null) {
            // 使用 MemberService 直接獲取會員名字
            MemberVO member = memberService.getMemberByMemberemail(memberemail);

            if (member != null) {
                System.out.println("成功取的memberName");
                String memberName = member.getMembername();
                request.setAttribute("userName", memberName);
                request.getRequestDispatcher("/customer/chat.jsp").forward(request, response);
            }
        }
    }
}