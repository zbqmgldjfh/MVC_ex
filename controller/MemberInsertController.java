package com.dev.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;;

public class MemberInsertController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		
		if(id.isEmpty() || passwd.isEmpty() || name.isEmpty() || mail.isEmpty()) {
			request.setAttribute("error", "��� �׸��� �������� �Է����ֽñ� �ٶ��ϴ�.");
			HttpUtil.forward(request, response, "/memberInsert.jsp");
			return;
		}
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setMail(mail);
		
		MemberService service = MemberService.getInstance();
		service.memberInsert(member);
		
		request.setAttribute("id", id);
		HttpUtil.forward(request, response, "/result/memberInsertOutput.jsp");
	}
}
