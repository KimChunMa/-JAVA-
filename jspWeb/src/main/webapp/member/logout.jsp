<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "/header.jsp" %>
	<% // 모든세션지우기
		//request.getSession().invalidate();
	
		// 특정 세션 지우기
		request.getSession().setAttribute("login",null);
	%>
</body>
</html>