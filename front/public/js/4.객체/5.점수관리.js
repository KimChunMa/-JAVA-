let studentArray=[] //내부데이터

//학생 점수 등록 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
let addbtn = document.querySelector('.addbtn')

 //클릭시 입력된 데이터 가져오기
addbtn.addEventListener('click', () =>{ //버튼함수 시작
	
	let info ={
		name : document.querySelector('.name').value,
		kor : parseInt(document.querySelector('.kor').value),
		eng : parseInt(document.querySelector('.eng').value),
		math : parseInt(document.querySelector('.math').value)
	}
	
	let check = true;
	
	//유효성 검사 1 이름
	studentArray.forEach( (obj)=> {
		if(obj.name == info.name){
			alert('중복된 학생명 입니다.'); check=false;} })
	
	//유효성 검사 2 점수
	if((info.kor <0 || info.kor>100) || 
	   (info.eng <0 || info.eng>100) || 
	   (info.math <0 || info.math>100))
	{alert('입력할 수 없는 점수입니다.');check=false;}
	
	//유효성 검사 3 이름
	if(info.name.length<=2 || info.name.length>=6){
	alert('이름은 3~5글자 사이여야 됩니다.');check=false;}
	
	//유효성 검사 4 점수
	if(isNaN(info.kor) || isNaN(info.eng)||isNaN(info.math) ){
	alert('점수는 숫자로 입력하셔야 됩니다'); check=false;}
	
	//저장 (유효성 검사가 모두 true 나오면)
	if(check){studentArray.push(info); alert('등록되었습니다.')}

	printTable(); //등록된 데이터 출력
}) //버튼 함수 끝

//학생 점수 현황 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

	//그냥 출력
	printTable();
	function printTable() { 
		
		let html = `<tr>
						<td> 번호 </td> <td> 이름 </td> <td> 국어 </td>
						<td> 영어 </td> <td> 수학 </td> <td> 총점 </td>
						<td> 평균 </td> <td> 순위 </td> <td colspan="2"> 비고 </td>
					</tr>`;
		
		studentArray.forEach((o,i) => {
			
			//총점
			let total = o.kor+ o.eng+o.math;
			let rank = 1;
			
			studentArray.forEach( (o2) => { //비교 반복문
				let total2 = o2.kor + o2.eng + o2.math;
				
				if( total < total2){rank++;}
			
			})  //비교 반복문 끝
			
			
			html+= `<tr> 
						<td> ${i+1} </td> <td> ${o.name} </td>
						<td> ${o.kor} </td> <td> ${o.eng} </td>
						<td> ${o.math} </td> <td> ${total} </td>
						<td> ${parseInt((total)/3)}</td>
						<td> ${rank} </td> 
						<td> <button onclick="onUpdate(${i})">수정</button> </td>
						<td> <button onclick="Del(${i})">삭제</button> </td>
				   </tr>`;
		})
		document.querySelector('.listTable').innerHTML = html;
		} //출력 함수 종료


/*삭제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
function Del(i){
	studentArray.splice(i,1)
	printTable()
}

/*수정 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/

let upindex =-1; //수정할 인덱스

function onUpdate(i){
	upindex =i;
	document.querySelector('.updatebox').style.display='block'
	
	document.querySelector('.upname').value = studentArray[i].name
	document.querySelector('.upkor').value = studentArray[i].kor
	document.querySelector('.upeng').value = studentArray[i].eng
	document.querySelector('.upmath').value = studentArray[i].math
	
}

//점수 수정 클릭시 
let updatebtn = document.querySelector(`.Update`)
updatebtn.addEventListener('click', () =>{
	
	studentArray[upindex].kor = parseInt(document.querySelector('.upkor').value)
	studentArray[upindex].eng = parseInt(document.querySelector('.upeng').value)
	studentArray[upindex].math = parseInt(document.querySelector('.upmath').value)
	
	printTable();
	
	//숨기기
	document.querySelector('.updatebox').style.display='none'
})


