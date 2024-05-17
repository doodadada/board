package com.himedia.board.controller.action.board;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import com.himedia.board.controller.action.Action;
import com.himedia.board.dao.BoardDao;
import com.himedia.board.dto.BoardDto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

public class UpdateBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao bdao = BoardDao.getInstance();
		BoardDto bdto = new BoardDto();
		
		
		bdto.setNum(Integer.parseInt(request.getParameter("num")));
		bdto.setUserid(request.getParameter("userid"));
		bdto.setPass(request.getParameter("pass"));
		bdto.setTitle(request.getParameter("title"));
		bdto.setEmail(request.getParameter("email"));
		bdto.setContent(request.getParameter("content"));
		
		//파일
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath("images");
		File uploadDir = new File(uploadFilePath);
		if (!uploadDir.exists())	uploadDir.mkdir();
		
		String fileName = "";
		String saveFileName="";
		for (Part p : request.getParts()) {
			System.out.println(p.getHeader("content-disposition"));
			fileName = "";
			for (String content : p.getHeader("content-disposition").split(";")) {
				if (content.trim().startsWith("filename")) {
					fileName = content.substring(content.indexOf("=") + 2, content.length() - 1);
					System.out.println("filename : "+fileName);
					if (!fileName.equals("")) {
						Calendar today = Calendar.getInstance();
						long dt = today.getTimeInMillis();
						String fn1 = fileName.substring(0, fileName.indexOf("."));
						String fn2 = fileName.substring(fileName.indexOf("."));
						String saveFilename = fn1 + dt + fn2;
						p.write(uploadFilePath + File.separator + saveFilename); // 파일 저장
						bdto.setImage(fileName);
						bdto.setSavefilename(saveFilename);
					}else {
						bdto.	setImage(request.getParameter("oldimage"));
						bdto.setSavefilename(request.getParameter("oldsavefilename"));
					}
				}
			}
		}
		
		bdao.updateBoard(bdto);
		// response.sendRedirect("board.do?command=main");
		response.sendRedirect("board.do?command=boardViewWithoutCnt&num="+bdto.getNum());
		

	}

}
