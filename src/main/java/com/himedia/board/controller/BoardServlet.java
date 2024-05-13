package com.himedia.board.controller;

import java.io.IOException;

import com.himedia.board.controller.action.Action;
import com.himedia.board.controller.action.member.JoinFormAction;
import com.himedia.board.controller.action.member.LoginAction;
import com.himedia.board.controller.action.member.LoginFormAction;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardServlet
 */
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String command =request.getParameter("command");
		if(command == null) System.out.println("1. command 전달 오류");
		else System.out.println("command : " + command);
		
		Action ac = null;
		ActionFactory af = ActionFactory.getInstance();
		ac = af.getAction(command);
		if(ac ==null) System.out.println("2.Action 전달 오류");
		else ac.execute(request, response);
//		if(command.equals("loginForm")) {
//			// member/loginForm.jsp 로 포워딩 하는 코드
//			ac = new LoginFormAction();
//		}else if(command.equals("login")) {
//			//데이터 베이스 이용하여 로그인처리 하는 코드
//			ac = new LoginAction();
//		}else if(command.equals("joinForm")) {
//			// member/joinForm.jsp 로 포워딩 하는 코드
//			ac = new JoinFormAction();
//		}else if(command.equals("join")) {
//			// 데이터베이스를 이용하여 회원가입 처리하는 코드
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
