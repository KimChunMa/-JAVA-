<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file ="/header.jsp" %>
	<h3> 글쓰기 </h3>
	
	<script>
	if(memberInfo.mno==0){
		
		alert('회원제 기능입니다. 로그인후 작성해주세요');
		location.href="/jspWeb/member/login.jsp"
	}
	</script>
	
	<% 
		//jsp 로그인 여부 제어
		Object obj = request.getSession().getAttribute("login");
	if(obj == null){
		response.sendRedirect("/jspWeb/member/login.jsp");
	}
	
	String bno = request.getParameter("bno");
	
	%>

	
	
	<div class="container">
		<form class="updateForm" >
			<input type="hidden" class="bno" value="<%=bno%>" name="bno">
			
			카테고리 : <select name="cno" class="cno">
						<option value="1"> 공지사항 </option>
						<option value="2"> 커뮤니티 </option>
						<option value="3"> QnA </option>
						<option value="4"> 노하우 </option>
					 </select> <br/>
			제목 : <input type="text" name="btitle" class="btitle"> <br/>
			내용 : <textarea rows="10" cols="40" name="bcontent" class="bcontent"></textarea> <br/>
			
			<div class="bfilebox"></div>
			<div class="bfilebox2"></div>
			
			<button type="button" onclick="bupdate()"> 수정 </button>
		</form>
	</div>

	
	
	<script src="/jspWeb/js/update.js"></script>


</body>
</html>