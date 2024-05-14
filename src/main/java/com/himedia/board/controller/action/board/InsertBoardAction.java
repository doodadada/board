package com.himedia.board.controller.action.board;

import java.io.IOException;

import com.himedia.board.controller.action.Action;
import com.himedia.board.dao.BoardDao;
import com.himedia.board.dto.BoardDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDao bdao = BoardDao.getInstance();
		
	
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass");
		String title = request.getParameter("title");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		
		BoardDto bdto = new BoardDto(userid,pass,title,email,content);
		
		bdao.insertBoard(bdto);
		
		response.sendRedirect("board.do?command=main");
		

	}

}
