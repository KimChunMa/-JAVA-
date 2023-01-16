let 버튼목록현황 = [ null,  null,  null,  
				 null,  null,  null,  
				 null,  null,  null];

/* 함수정의 만들기*/
function 클릭이벤트(버튼번호) {
	//사람
	if( ! 알두기(버튼번호, 'O')){ return;} //사람이 성공시 O가 써지고, 실패시 취소
	if(결과()){return;}
	
	//컴퓨터
	while(true){ //반복
		let 컴퓨터번호 = parseInt(Math.random()*9)+1 //0~8.99 +1
		if(알두기( 컴퓨터번호, 'X' )){결과(); return;} //컴퓨터 성공시 끝 
		}
}


function 알두기( 버튼번호 , 알모양){
	let 버튼목록 = document.querySelectorAll('.버튼');
		
		if(버튼목록현황[버튼번호-1] != null){return false;}
		
		버튼목록[버튼번호-1].innerHTML = 알모양 ; 버튼목록현황[버튼번호-1]=알모양;
		return true;
	}

//승패 , 무승부 
function 결과(){
	
	// 가로
	for(let i = 0 ; i <= 6 ; i+=3){
		if( 버튼목록현황[i] != null && 
		버튼목록현황[i] ==버튼목록현황[i+1] && 버튼목록현황[i+1] ==버튼목록현황[i+2] 
		){alert('승리' + 버튼목록현황[i])}
	}
	
	for(let i = 0 ; i <= 2 ; i++){
		if( 버튼목록현황[i] != null && 
		버튼목록현황[i] ==버튼목록현황[i+3] && 버튼목록현황[i+3] ==버튼목록현황[i+6] 
		){alert('승리' + 버튼목록현황[i] )}
	}
	
	if(버튼목록현황[0] != null && 버튼목록현황[0] == 버튼목록현황[4] && 버튼목록현황[4] == 버튼목록현황[8] )
		{alert('승리')}
	if(버튼목록현황[2] != null && 버튼목록현황[2] == 버튼목록현황[4] && 버튼목록현황[4] == 버튼목록현황[8] )
		{alert('승리' + 버튼목록현황[i] )}
	
}