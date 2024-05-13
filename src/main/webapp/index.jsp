<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	response.sendRedirect("board.do?command=loginForm");
	/*
		클라이언트와 서버가 re	quest와 response 를 이용해서 연결하고 통신하는 곳이 Servlet입니다
		- 이전 단원에서는 매 페이지마다 해당 서블릿을 만들고, 각 페이지를 보기위해서 담당 서블릿을 호출하는 형식
		- 그로 인해서 서블릿으 URL Mapping 들이 노출되지만 이외것들은 모두 감춰지는 효과를 볼 수 있습니다.
		- 이번 단원에서는 서블릿을 하나로 단축하고,  command 라는 파라미터를 써서 각 페이지호출을 구분할 예정이니다
		- 현재의 구조에서는 단일서블릿내에서 기능별로 구성된 클래스들을 이용한 기능 구현을 하게 됩니다.
		- 이 구조가 기능마다 서블릿이 있는것보다 구조가 간편하고 서브의 부담을 줄이게 됩니다.
	*/
%>
</body>
</html>