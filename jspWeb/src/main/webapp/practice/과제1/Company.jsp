<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspWeb/practice/과제1/Company.css">
</head>
<body>
	<form class="signupForm">
		<div>
			<div> 사원명
				  <input type="text" class="name" name="name">
			</div>
			
			
			<div> 직급
				  <select class="grade" name="grade"> 
						<option value="사원" > 사원 </option>
						<option value="대리" > 대리 </option>
						<option value="부장" > 부장 </option>
						<option value="과장" > 과장 </option>
						<option value="대표" > 대표 </option>
					</select> 
			</div>
			
			<div>  고용형태
					<select class="worker" name="worker"> 
						<option value="일용직" > 일용직 </option>
						<option value="정규직" > 정규직 </option>
						<option value="임원" > 임원 </option>
					</select> 
			</div>
			
			<div> 부서
					<select class="department" name="department"> 
						<option value="인사팀" > 인사팀 </option>
						<option value="영업팀"> 영업팀 </option>
						<option value="개발팀" > 개발팀 </option>
					</select> 
				  
			</div>
			
			<div> 입사일
				  <input type="text" class="join" name="join">
			</div>
			
			<div> 사원 사진
				  <input type="file" class="picture" name="picture">
			</div>
			
			<div> 퇴사일
				  <input type="text" class="retire" name="retire">
			</div>
			
			<div> 퇴사 사유
				  <input type="text" class="reason" name="reason">
			</div>
		</div>
		
		<button type="button" onclick="regist()">등록</button>
	 </form>
	
	------------------------------------------------
	<br/>
		<h3> 출력란 </h3>
		<table class="print" border="1">
		</table>
	<div>
		
	</div>
	
	
	
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/jspWeb/practice/과제1/Company.js"></script>
</body>
</html>