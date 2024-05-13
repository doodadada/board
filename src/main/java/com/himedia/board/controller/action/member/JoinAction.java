package com.himedia.board.controller.action.member;

import java.io.IOException;

import com.himedia.board.controller.action.Action;
import com.himedia.board.dao.MemberDao;
import com.himedia.board.dto.MemberDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		MemberDto mdto = new MemberDto(userid,name,pwd,email,phone);
		
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.insertMember(mdto);
		
		String message = "";
		if(result == 1) message = "회원가입이 완료되었습니다. 로그인하세요";
		else message = "회원가입이 실패했습니다. 관리자에게 문의하세요";
		
		HttpSession session = request.getSession();
		session.setAttribute("message", message);
		
		// 모든 기능중에 레코드를 추가하는 기능에는 마지막으로 forward를 쓰지 않습니다
		// forward를 쓸 경우 "새로고침" 누를 시에 회원가입을 위해서 입력한 내용부터 다시 실행되서
		// "중복레코드가 하나더 추가하려고 시도합니다.
		// 이때 기본키 오류가 발생
		response.sendRedirect("board.do?command=loginForm");
		
	}

}
