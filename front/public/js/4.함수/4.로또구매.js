let 버튼목록 ='';

function 버튼출력(){
	for(let i = 1;i<=45 ;i++ ){
		
		//'<button onclick="버튼클릭('+i+')">'+'로또구매'+ i+'</button>'
		
		//백틱  전체 `` 감싼뒤 변수만 ${}
		버튼목록 += `<button onclick="버튼클릭(${i})">로또구매 ${i}</button>`
			if(i%5==0){ //5줄마다 줄바꿈
				버튼목록 += '<br/>';
			}
		//글바꿈	
		document.querySelector('.Number').innerHTML = 버튼목록
	}	
	//버튼 보이게
	document.querySelector('.cut').style.display="inline"
}


function 버튼취소(){
	//버튼초기화
	버튼목록 ='';
	// 목록 초기화
	document.querySelector('.Number').innerHTML = 버튼목록;
	document.querySelector('.cut').style.display="none"
	
	//모두삭제
	선택번호목록.splice(0);
	추첨버튼출력();
}

let 선택번호목록=[];

function 버튼클릭(i){
	console.log(i+"번호를 선택 하셨네요")

	if(선택번호목록.indexOf(i)>=0){//중복이라면 삭제
		alert('이미 존재한 번호 입니다. 취소합니다')
		선택번호목록.splice(선택번호목록.indexOf(i),1)
		console.log(선택번호목록)
		document.querySelector('.선택번호상자').innerHTML = 선택번호목록;
		return;
	}
	
	else if(선택번호목록.length==6){//꽉찼다면
		alert('더이상 선택할 수 없습니다.')
		return;
		} 
	
	선택번호목록.push(i);
	추첨버튼출력()
}


function 추첨버튼출력(){
	//숫자입력
		if(선택번호목록.length ==6){
			document.querySelector('.추첨버튼').style.display='inline';
		}else{
			document.querySelector('.추첨버튼').style.display='none';
		}
		
	document.querySelector('.선택번호상자').innerHTML = 선택번호목록;
}





//5. 추첨하기 버튼
function 구매추첨(){
	//추첨목록
	let 추첨번호목록 = []
	
	//추첨번호뽑기
	for(let i =1 ; i <=6 ; i++){ 
		let 정수난수 = parseInt(Math.random()*45+1)
		
		//중복
		if(추첨번호목록.indexOf(정수난수) >= 0){
			i--;
		}else{
			추첨번호목록.push(정수난수)
		}
	}//반복문 끝
	
	//쓰기
	document.querySelector('.추첨번호상자').innerHTML = 추첨번호목록;
	//추첨결과 출력 [맞은 개수와 등수 출력]
	
	//1
	let 맞은개수 = 0 ;
	for(let i = 0 ; i<추첨번호목록.length;i++){
		for(let j = 0 ; j < 선택번호목록.length ; j++){
			if(추첨번호목록[i] == 선택번호목록[j]){
				console.log(추첨번호목록[i] + " : " + 선택번호목록[j])
				맞은개수++;
				console.log(맞은개수)
			}
		}
	}
	
	//2
	맞은개수 = 0 ;
	for(let i = 0 ; i < 추첨번호목록.length ; i++){
		if(선택번호목록.indexOf(추첨번호목록[i])>=0){맞은개수++;
		console.log("2 맞는 개수는"+맞은개수)}
	}
	
	//3
	맞은개수 = 0;
	// 3.  for( 반복변수 of 배열 ) : 배열내 요소 하나씩 마지막 요소까지 반복변수에 대입
	for( let value of 추첨번호목록 ){
		console.log( value )
		if( 선택번호목록.includes( value ) == true ){ 맞은개수++ }
	}
	
	alert( 맞은개수 )
	
	/*
		배열명.indexOf( 찾을데이터 )	: 찾을데이터의 인덱스 반환 0~ / 없으면 -1
		배열명.includes( 찾을데이터 )	: 찾을데이터의 존재 여부 true / 없으면 false
	*/
}
