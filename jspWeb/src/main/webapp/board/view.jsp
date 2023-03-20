<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	 <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	 
	<link href="/jspWeb/css/view.css" rel="stylesheet">
	<link href="/jspWeb/css/list.css" rel="stylesheet">
	<!-- 폰트어썸 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>
	<%@ include file ="/header.jsp" %>
	
	<% 
		String bno = request.getParameter("bno");
	%>
	<input type="hidden" class="bno" value="<%=bno%>" > <!-- JAVA코드를 HTML에 출력하는 자리 -->
	
	<div class="container">
		<div class="boardbox">
			<div class="viewtop">
				<div>
					<img src="" class="hpimg">
				</div>
				
				<div class="rviewtop">
					<div class="mid">  </div>
						<div class="cbottom">
							<span class="bdate">  </span>
							<span> <i class="far fa-eye"></i> <span class="bview"></span> </span>
							<span> <i class="far fa-thumbs-up"></i> <span class="bup"></span> </span>
							<span > <i class="far fa-thumbs-down" onclick="bIncrease(2)"></i> <span class="bdown" >30</span> </span>
							<span > <i class="far fa-comment-dots" onclick="bIncrease(3)"></i> <span class="rcount">30 </span> </span>
						</div>
				</div>
			</div><!-- viewtop -->
			
			<div class="btitle"> 제목 </div>
			
			<div class="bcontent"> 내용 </div>
			
			<div class="bfilebox"> <i class="fas fa-download"></i>파일명: </div>
			
			<div class="btnbox"> 수정 </div>
			
			<div class="replycount"> 3개의 댓글</div>
			
			<div class="replywritebox"> 
				<textarea class="rcontent" rows="" cols=""></textarea>
				<button class="rwritebtn bbtn"> 댓글 출력</button>
			</div>
			
			
			
		</div>
	</div>
	
	
	
	
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