<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.pagebox button{padding:10px 15px; margin:10px;}
</style>

</head>
<body>
	<%@ include file ="/header.jsp" %>
	
	
	<%	// 1. HTTP GET <a href="URL경로?변수명=값"> 전달된 매개변수 가져오기
		String cno = request.getParameter("cno");
	%>
	
	<!-- cno숨겨서 js에게 전달 -->
	<input type="hidden" class="cno" value="<%=cno%>">
	
	
	<div class="container">
	
		<h3 class="cname"> 게시물 목록 </h3>
		<a href="write.jsp">게시물 쓰기</a>
		
		<table class="boardTable table table-hover">
		</table>
		
		<div class="pagebox" >
		</div>
		
		
		
		
		<!-- 검색창 -->
		<div>	<!-- select *from board where 필드명 = 데이터 -->
			<select class="key">	<!-- slect 시 사용되는 조건의 필드명 -->
				<option value="b.btitle"> 제목 </option>
				<option value="b.bcontent"> 내용 </option>
				<option value="m.mid"> 작성자 </option>
			</select>
			<input type="text" class="keyword">	<!-- select시 사용되는 조건 -->
			<button type="button" onclick="getsearch()">검색</button>
		</div>
		
	</div>
	

	
	<script src="/jspWeb/js/board/list.js"></script>
</body>
</html>