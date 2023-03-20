<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspWeb/css/view.css" rel="stylesheet">

</head>
<body>
	<%@ include file ="/header.jsp" %>
	
	<% 
		String bno = request.getParameter("bno");
	%>
	<%=bno%> <!-- JAVA코드를 HTML에 출력하는 자리 -->
	
	<div class="container">
		<h3> 게시물 개별 조회/보기 </h3>
		
		<div> 
			<div> 게시물 번호  </div> 
			<div class="bno"><%=bno %></div>
		</div>	
		
		<div> 
			<div> 작성일 / 조회수 / 좋아요 / 싫어요  </div> 
			<div class="infobox"> </div>
		</div>	
		
		<div> 
			<div> 작성자[프로필]  </div> 
			<div class="pimgbox"> </div>
		</div>
		
		<div> 
			<div> 제목  </div> 
			<div class="btitle">  </div>
		</div>	
		
		<div> 
			<div> 내용  </div> 
			<div class="bcontent">   </div>
		</div>		
		
		<div> 
			<div> 첨부파일  </div> 
			<div class="bfile">   </div>
		</div>	
		
		
		<br/>
		<div class="btnbox">
		</div>
		
		
		<div>
			<textarea rows="" cols="" class="rcontent" ></textarea>
			<button type="button" class="rwritebtn" onclick="rwrite()">댓글 작성</button>
		</div>
		
		<div class="replylistbox">
		
		</div>
	</div>
	
	<script src="/jspWeb/js/board/view.js"></script>
	
</body>
</html>