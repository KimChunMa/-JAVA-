<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div>
		<div> 사원명
			  <input type="text" class="name">
		</div>
		
		<div> 직급
			  <select class="grade"> 
					<option value="staff"> 사원 </option>
					<option value="Amanager"> 대리 </option>
					<option value="Gmanager"> 부장 </option>
					<option value="manager"> 과장 </option>
					<option value="ceo"> 대표 </option>
				</select> 
		</div>
		
		<div>  고용형태
				<select class="wroker"> 
					<option value="daily"> 일용직 </option>
					<option value="employee"> 정규직 </option>
					<option value="executives"> 임원 </option>
				</select> 
		</div>
		
		<div> 부서
				<select class="department"> 
					<option value="personnel"> 인사팀 </option>
					<option value="Sales"> 영업팀 </option>
					<option value="Develop"> 개발팀 </option>
				</select> 
			  
		</div>
		
		<div> 입사일
			  <input type="text" class="join">
		</div>
		
		<div> 사원 사진
			  <input type="file" class="picture">
		</div>
		
		<div> 퇴사일
			  <input type="text" class="retire">
		</div>
		
		<div> 퇴사 사유
			  <input type="text" class="reason">
		</div>
	</div>
	
	<script src="/jspWeb/practice/과제1/Company.js"></script>
</body>
</html>