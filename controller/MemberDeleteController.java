package com.dev.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;;

public class MemberDeleteController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String job = request.getParameter("job");
		String path = null;
		if(job.equals("search"))
			path = "/memberSearch.jsp";
		else if(job.equals("update"))
			path = "/memberUpdate.jsp";
		else if(job.equals("delete"))
			path = "/memberDelete.jsp";
		
		if(id.isEmpty()) {
			request.setAttribute("error", "ID�� �Է����ֽñ� �ٶ��ϴ�!");
			HttpUtil.forward(request, response, path);
			return;
		}
		
		MemberService service = MemberService.getInstance();
		service.memberDelete(id);
		HttpUtil.forward(request, response, "/result/memberDeleteOutput.jsp");
		
	}
}
