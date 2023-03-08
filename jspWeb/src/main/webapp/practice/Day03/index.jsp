<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> 1. http 메소드 </h3>
	<button onclick="doGET()" type="button"> GET </button>
	<button onclick="doPOST()" type="button"> POST</button>
	<button onclick="doPUT()" type="button"> PUT </button>
	<button onclick="doDELETE()" type="button"> DELETE </button>
	
	<h3> 2. 방문록 </h3>
	내용 : <input type="text" class="content"> <br/>
	작성자 : <input type="text" class="writer"> <br/>
	<button type="button" onclick="onwrite()"> 방문록 등록</button>
	
	
	<h3> 3. 방문록 남기기</h3>
	
	<div class="log"></div>
	
	
	<!-- 과제 -->
	
	<h3> --------------------과제---------------------</h3>
	
	<h3> 제품등록  </h3>
	제품명 : <input type="text" class="pname"> <br/>
	제품가격 : <input type="number" class="pprice"> <br/>
	<button type="button" onclick="register()"> 제품 등록</button>
	
	
	<h3> 제품목록  </h3>
	
	<div class="plist"></div>
	
	
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="index.js"></script>
</body>
</html>