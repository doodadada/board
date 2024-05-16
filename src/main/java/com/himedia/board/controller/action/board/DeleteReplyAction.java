package com.himedia.board.controller.action.board;

import java.io.IOException;

import com.himedia.board.controller.action.Action;
import com.himedia.board.dao.BoardDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int replyNum = Integer.parseInt(request.getParameter("replynum"));
		int boardNum = Integer.parseInt(request.getParameter("boardnum"));
		
		BoardDao bdao = BoardDao.getInstance();
		bdao.deleteReply(replyNum);
		
		response.sendRedirect("board.do?command=boardViewWithoutCnt&num="+boardNum);
	}

}
