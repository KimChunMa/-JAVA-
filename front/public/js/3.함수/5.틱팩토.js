let 버튼목록현황 = [ null,  null,  null,  
				 null,  null,  null,  
				 null,  null,  null ];

/* 클릭 이벤트*/
function 클릭이벤트(버튼번호) {
	//사람
	if( ! 알두기(버튼번호, 'O')){ return;} 
	//사람이 성공시 O가 써지고, 실패시(이미 기호가 있으면) 중단
	
	if(결과()){return;}//결과가 나온다면 중단
	
	//컴퓨터
	while(true){ //무한반복
		let 컴퓨터번호 = parseInt(Math.random()*9)+1 //0~8.99 +1
		if(알두기( 컴퓨터번호, 'X' )){결과(); return;} //컴퓨터 성공시 무한반복 중단 
		}
}


function 알두기( 버튼번호 , 알모양){
	let 버튼목록 = document.querySelectorAll('.버튼');
	//모든 class 들을 배열 형태로 가져옴
		
		if(버튼목록현황[버튼번호-1] != null){return false;} //이미 있다면 중단
		
		버튼목록[버튼번호-1].innerHTML = 알모양 ; 버튼목록현황[버튼번호-1]=알모양;
		//알모양 출력 
		
		return true;
	}

//승패 , 무승부 
function 결과(){
	
	// 가로
	for(let i = 0 ; i <= 6 ; i+=3){
		if( 버튼목록현황[i] != null && 
		버튼목록현황[i] ==버튼목록현황[i+1] && 버튼목록현황[i+1] ==버튼목록현황[i+2] 
		){
		결과출력(버튼목록현황[i])
		alert('승리' + 버튼목록현황[i]);  
		return true; }
	}
	
	//세로
	for(let i = 0 ; i <= 2 ; i++){
		if( 버튼목록현황[i] != null && 
		버튼목록현황[i] ==버튼목록현황[i+3] && 버튼목록현황[i+3] ==버튼목록현황[i+6] 
		){
			결과출력(버튼목록현황[i])
			alert('승리' + 버튼목록현황[i] ); 
			return true; }	
	}
	
	//대각선
	if(버튼목록현황[0] != null && 버튼목록현황[0] == 버튼목록현황[4] && 버튼목록현황[4] == 버튼목록현황[8] )
		{alert('승리' + 버튼목록현황[0]); 결과출력(버튼목록현황[0]); return true;}
	if(버튼목록현황[2] != null && 버튼목록현황[2] == 버튼목록현황[4] && 버튼목록현황[4] == 버튼목록현황[6] )
		{alert('승리' + 버튼목록현황[2]); 결과출력(버튼목록현황[2]);return true;}
	
	//무승부
	let 빈자리수 = 0;
	for( 버튼 of 버튼목록현황){
		if( 버튼 == null ){빈자리수 ++}
	}
	
	if(빈자리수 ==0){결과출력('-'); return ture}
	
	return false;
}

//게임 승리자 출력
function 결과출력(알모양){
	let 게임판 = document.querySelector('.게임판')
	
	게임판.innerHTML = 알모양 + '승리'
	
	if(알모양 =='-'){
		게임판.innerHTML="무승부";
	}else{
		게임판.innerHTML = 알모양 + ' 승리';
	}
} 


