<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!-- 부트스트랩 css -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<!-- 사용자 css -->
<link href="/jspWeb/css/index.css" rel="stylesheet">
</head>
<body>
 	
<%-- 	<% String login = (String)request.getSession().getAttribute("login"); %>
	<%=login %>님 안녕하세요 
		<a href="/jspWeb/index.jsp">홈</a>
	<%
		if(login == null){
	%>	
		<a href="/jspWeb/member/signup.jsp">회원가입</a>
		<a href="/jspWeb/member/login.jsp">로그인</a>
	<% 
		}else if(login.equals("admin")){
	%>		
		<a href="/jspWeb/admin/info.jsp">관리자 페이지</a>
		<a href="/jspWeb/member/logout.jsp">로그아웃</a>	
	<% 
		} else{
	%>			
		<a href="/jspWeb/admin/info.jsp">관리자 페이지</a>
		<a href="/jspWeb/member/logout.jsp">로그아웃</a>	
	
	<%	} %>  --%>
	
	<div class="container">
		<div class="header">
			<!-- 로고 -->
			<div class="mainlogo">
				<a href="/jspWeb/index.jsp">
					<img src="/jspWeb/img/logo.ico">
				</a>
			</div>
			<!-- 본메뉴 -->
			<ul class="mainmenu">
				<li> <a href="/jspWeb/board/list.jsp?cno=1"> 공지사항 </a> </li>
				<li> <a href="/jspWeb/board/list.jsp?cno=2"> 커뮤니티 </a> </li>
				<li> <a href="/jspWeb/board/list.jsp?cno=3"> QnA </a></li>
				<li> <a href="/jspWeb/board/list.jsp?cno=4"> 노하우 </a></li>
				<li> <a href="#"> 기본메뉴1 </a> </li>
			</ul>
			<!-- 서브메뉴 -->
			<div class="submenu">
			</div> <!-- 서브메뉴 끝 -->
			
		</div> <!-- header e -->
	</div> <!-- container e -->
	
	
	
	<!-- 부트스트랩 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/jspWeb/js/header.js"></script> 
</body>
</html> 