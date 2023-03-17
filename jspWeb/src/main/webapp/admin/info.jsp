<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style>
	.mListTable, .mListTable th , .mListTable td 
	{border:solid black 1px;
	padding:10px; 
	text-align: center;}
	
	.pagebtn button {padding:10px; margin: 5px;}
	</style>
</head> 
<body>
	<%@ include file = "/header.jsp" %>
	<h3> 모든 회원 명단 </h3>
	
	총회원수 <span class="mcount"></span> <br/>
	
	검색창:
	<select class="memberSelect2">
		<option value="m.mno">회원 번호</option>
		<option value="m.mid">아이디</option>
		<option value="m.memail">이메일</option>
	</select>
	<input type="text" name="searchtext" class="searchtext">
	<button onclick="search_member()" type="button">검색하기 </button>
	<br/>
	
	게시물보기:
	<select class="listsize" onchange="setlistsize()">
		<option >2</option>
		<option >3</option>
		<option >4</option>
	</select>
	
	<br/>
	<button type="button" onclick="search_reset()">검색 초기화</button>
	
	
	<table class="mListTable" >

	</table>
	
	<div class="pagebtn">
	</div>
	
	
	<script src="/jspWeb/js/admin/info.js" ></script>
	
</body>
</html>