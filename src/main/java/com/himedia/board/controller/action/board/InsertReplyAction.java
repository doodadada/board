package com.himedia.board.controller.action.board;

import java.io.IOException;

import com.himedia.board.controller.action.Action;
import com.himedia.board.dao.BoardDao;
import com.himedia.board.dto.ReplyDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyDto rdto = new ReplyDto();
		rdto.setUserid(request.getParameter("userid"));
		rdto.setBoardnum(Integer.parseInt(request.getParameter("boardnum")));
		rdto.setContent(request.getParameter("content"));
		
		BoardDao bdao = BoardDao.getInstance();
		bdao.insertReply(rdto);
		
		// insert update에서는 forward를 쓰지 않음(두번 실행됨)
		// request.getRequestDispatcher("board.do?comnand=boardview&num="+rdto.getBoardnum()).forward(request, response);;
		
		response.sendRedirect("board.do?command=boardViewWithoutCnt&num="+rdto.getBoardnum());
	}

}
