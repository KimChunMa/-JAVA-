<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	[ctrl + f11]
	<h3> 예제1 : 입력받은 데이터 -> JS -> 서블릿 -> DAO </h3>
		
	data : <input type="text" class="inputdata" value="wow">
	<button type="button" onclick="alert('클릭')" > 예제 1 실행</button>
	<button type="button" onclick="c()" > 예제 1 실행</button>
	
	<script src="js/index.js"></script> <!-- 상대  -->
   <!--절대: src="jspWeb/js/index.js" src + main + webapp 생략 --> 
</body>
</html>