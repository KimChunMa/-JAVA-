<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file ="header.jsp" %>
	<center> 
	<form name="joinform" action="서블릿 주소" method="post"> 
	<table border="1">
		<tr>
			<th> 회원번호(자동발생)</th> <td> <input type="text" name="custno"> </td>
		</tr>
		
		<tr>
			<th> 회원성명 </th> <td> <input type="text"  name="custname"> </td>
		</tr>
		
		<tr>
			<th> 회원전화 </th> <td> <input type="text"  name="phone"> </td>
		</tr>
		
		<tr>
			<th> 회원주소 </th> <td> <input type="text"  name="address"> </td>
		</tr>
		
		<tr>
			<th> 가입일자 </th> <td> <input type="text"  name="joindate"> </td>
		</tr>
		
		<tr>
			<th> 고객등급 [A:VIP, B:일반, C:직원] </th> <td> <input type="text"  name="grade"> </td>
		</tr>
		
		<tr>
			<th> 도시코드</th> <td> <input type="text"  name="city"> </td>
		</tr>
		
		<tr>
			<td colspan="2">
				<center> 
					<button type="button" onclick="join()">등록 </button>  
					<a href="view.jsp"> <button type="button">조회 </button> </a>
				</center> 
			</td>
		</tr>
	
	</table>
	</form>
	</center>
	
	
	<%@ include file ="footer.jsp" %>
	
	<script src="js/index.js"></script>
</body>
</html>