<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspWeb/css/list.css" rel="stylesheet">
	
	<!-- 폰트어썸 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
<style>
	.pagebox button{padding:10px 15px; margin:10px;}
</style>

</head>
<body>
	<%@ include file ="/header.jsp" %>
	
	
	<%	// 1. HTTP GET <a href="URL경로?변수명=값"> 전달된 매개변수 가져오기
		String cno = request.getParameter("cno");
	%>
	
	<!-- cno숨겨서 js에게 전달 -->
	<input type="hidden" class="cno" value="<%=cno%>">
	
	<div class="container">
	
		<div class="boardbox">	
		
			<div class="boardtop">
				<h3 class="cname"> 공지사항 </h3>
				<p> 다양한 사람들과 정보를 공뷰 해보세요 </p>
			</div>
			
			<div class="boardtopetc">
				<a href="write.jsp">
					<button class="bbtn"> <i class="fas fa-pencil-alt"></i> 글쓰기</button>
				</a>
				
				<div>
					<span class="seachcount"> 게시물수 : 6</span>
					<button onclick="setsearch()" class="bbtn">전체보기</button>
					<select class="bbtn listsize" onchange="setlistsize()">
						<option>3</option>
							<option>5</option>
							<option>10</option>
					</select>
				</div>
			</div>
			
			<div class="boardTable"></div>
			
		</div>
		
	</div>
	
	<div class="boardbottom">
	
		<div class="pagebox" >
		</div>

		<!-- 검색창 -->
		<div>	<!-- select *from board where 필드명 = 데이터 -->
			<select class="key bbtn">	<!-- slect 시 사용되는 조건의 필드명 -->
				<option value="b.btitle"> 제목 </option>
				<option value="b.bcontent"> 내용 </option>
				<option value="m.mid"> 작성자 </option>
			</select>
			<input type="text" class="keyword">	<!-- select시 사용되는 조건 -->
			<button type="button" onclick="getsearch()" class="bbtn">검색</button>
		</div>
		
	</div>
	

	
	<script src="/jspWeb/js/board/list.js"></script>
</body>
</html>