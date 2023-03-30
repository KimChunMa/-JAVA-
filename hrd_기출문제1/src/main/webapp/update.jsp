<%@page import="controller.MemberDto"%>
<%@page import="controller.Dao"%>
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
	
	<% 
		int custno = Integer.parseInt( request.getParameter("custno") ) ;
		Dao dao = new Dao();
		MemberDto dto = dao.getmember(custno);
	%>
	<center> 
	<form name="updateform" action="/hrd_exam1/join" method="get"> 
	<table border="1">
		<tr>
			<th> 회원번호(자동발생)</th> <td> <input type="text" name="custno" value=<%=dto.getCustno()%> > </td>
		</tr>
		
		<tr>
			<th> 회원성명 </th> <td> <input type="text"  name="custname" value=<%=dto.getCustname()%>> </td>
		</tr>
		
		<tr>
			<th> 회원전화 </th> <td> <input type="text"  name="phone" value=<%=dto.getPhone()%>> </td>
		</tr>
		
		<tr>
			<th> 회원주소 </th> <td> <input type="text"  name="address" value=<%=dto.getAddress()%>> </td>
		</tr>
		
		<tr>
			<th> 가입일자 </th> <td> <input type="text"  name="joindate" value=<%=dto.getJoindate()%>> </td>
		</tr>
		
		<tr>
			<th> 고객등급 [A:VIP, B:일반, C:직원] </th> <td> <input type="text"  name="grade" value=<%=dto.getGrade()%>> </td>
		</tr>
		
		<tr>
			<th> 도시코드</th> <td> <input type="text"  name="city" value=<%=dto.getCity()%>> </td>
		</tr>
		
		<tr>
			<td colspan="2">
				<center> 
					<button type="button" onclick="onupdate()">수정 </button>  
					<a href="view.jsp"> <button type="button">조회 </button> </a>
				</center> 
			</td>
		</tr>
	
	</table>
	</form>
	</center>
	
	<%@ include file ="footer.jsp" %>
	
	<script src="/hrd_exam1/js/update.js"></script>
</body>
</html>