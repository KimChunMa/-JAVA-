<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspWeb/css/modal.css" rel="stylesheet"></link>
</head>
<body>
	<%@ include file = "/header.jsp" %>
	
	<div class="container">
	
		<h3> 회원 정보 </h3>
		
		<div>
			<div>
				<img class="mimg" alt="" src="">
			</div>
			
			<div>
				<div>아이디</div>
				<div class="mid"></div>
			</div>
			
			<div>
				<div>이메일</div>
				<div class="memail"></div>
			</div>
			
			<div>
				<div>보유포인트</div>
				<div class="mpoint"></div>
			</div>
			
			<button onclick="onpenModal()" type="button"> 회원수정 </button>
			<button onclick="onpenModal()" type="button" onclick="setDelete()"> 회원탈퇴 </button>
		</div>
	</div>
	
	<!-- 모달 HTML -->
	<div class="modal_wrap">
		<div class="modal_box">
			<h3 class="modal_title">제목</h3>
			<div class="modal_content">
			내용
			</div>
			<div class="modal_btns">
				<button onclick="onpenModal()" class="modal_check" 		type="button">등록</button>
				<button onclick="closeModal()"  class="modal_type=cencel"	type="button">취소</button>
			</div>
		</div>
	</div>
	
	<script src="/jspWeb/js/modal.js"></script>
	
	<script src="/jspWeb/js/member/info.js"></script>
	
</body>
</html>

<!--  
	동일한 HTML에서 열리는 js 파일은 메모리 공유
	단 먼저 호출된 js 순
	주의 ajax
		1. $.ajax({}) 비동기 통신 [요청보내고 응답을 기다리지않음]
		
 -->