<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	name[이름] 	: 	<input type="text" 		class="data1">  	<br/>
	tel[전화번호] 	: 	<input type="text" 	class="data2"> 		<br/>
	tall[키]		:	<input type="text" 		class="data3">		<br/>
	age[나이]		:	<input type="number"	class="data4">		<br/>
	submit[등록일]		:	<input type="date" 		class="data5">		<br/>
	
	sex[성별]	:	<input type="radio"	name="data7" value="남"> 남
						<input type="radio" name="data7" value="여"> 여	<br/>
						
	agree[개인정보동의]	:	<input type="checkbox" class="data8"> 승인	<br/>
	
	region[지역] 	:	<select class="data9"> 
							<option>안산</option> <option>수원</option> <option>성남</option>
						</select>			
												<br/>
	introduce[소개]	: 	<textarea class="data10" rows="" cols=""></textarea> <br/>
	
	<button type="button" onclick="ex1()"> 전송 </button>
	 
	출력
	<div class="box"></div>
	
	<!-- 1. JQUERY( ajax 사용하기 위해 ) -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 2. 사용자정의 js  -->
	<script src="aindex.js" type="text/javascript"></script>
	
</body>
</html>