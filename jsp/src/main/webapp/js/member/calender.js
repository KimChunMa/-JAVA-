let contents = []


let year = (new Date().getFullYear()) 
let month = new Date().getMonth() +1  //0~11 => 1~12

date();	
function date(){
	//현 년도,월 출력
	document.querySelector('.top_date').innerHTML = `${year}년 ${month}월` 
	//요일 
	let html = `<div class="day weekday sunday"> 일 </div>
				<div class="day weekday"> 월 </div> <div class="day weekday"> 화 </div>
				<div class="day weekday"> 수 </div> <div class="day weekday"> 목 </div>
				<div class="day weekday"> 금 </div> <div class="day weekday"> 토 </div>`
	
	// 1~12월의 마지막일
	let lastday = new Date( year , month , 0 ).getDate();  
	
	// 0~11의 시작일 (0부터 시작함)
	let weekday = new Date( year , month-1 , 1  ).getDay(); 
	
	// 시작일 전까지 공백
	for( let b = 0 ; b<weekday ; b++ ){
		html += `<div class="day"></div>`
	} 
	
	// * 1. 일 만들기  [  1 ~ 마지막 일[ new Date( year , month , 0 ).getDate()  ] 까지 ] 
	for( let day = 1 ; day<=lastday; day++ ){
		
		let date = new Date(year,month-1,day);  //현재날짜	
		let fdate = date_format(date)
		html += `<div class="day"  onclick="openModal(${fdate})"> ${ day } ${contents_print(fdate)}</div>`
	} // for end
	
	document.querySelector('.cal_day').innerHTML = html
}

//날짜포맷
function date_format(date){
	let d_year = date.getFullYear();
	let d_month = (date.getMonth()+1)<= 9 ? '0' + (date.getMonth()+1): (date.getMonth()+1);
	let d_day = date.getDate()<=9 ? '0' + (date.getDate()): (date.getDate());
	return `${d_year}${d_month}${d_day}`
}

//일정 출력
function contents_print( date ){
	let html =``;
	contents.forEach((o,i)=>{
		if(date == o.date){
			html += `<div class="content" style="background-color : ${o.bg_color}"> ${o.content}</div>`
		}
	})

	return html;
}

//전
document.querySelector('.previousbtn').addEventListener('click',(e)=>{
	month--;
	
	if(month<1){year--; month = 12; }
	
	date();
})

//후 
document.querySelector('.nextbtn').addEventListener('click',(e)=>{
	month++;
	if(month>=13){year++; month = 1; }
	date();
})

//클릭시 해당 날짜의 모달열기함수
function openModal( fdate ){
	document.querySelector('.modal_wrap').style.display="flex" 
	document.querySelector('.modal_date').innerHTML = fdate; //날짜 출력
	modal_print(fdate)
}

//모달 닫기 눌렀을때
document.querySelector('.modal_close').addEventListener('click',(e)=>{
	document.querySelector('.modal_wrap').style.display="none"
})

//등록 누를때
document.querySelector('.modal_write').addEventListener('click',(e)=>{
	
	let content ={
		date:document.querySelector('.modal_date').innerHTML ,
		content: document.querySelector('.modal_input').value,
		bg_color : document.querySelector('.modal_color').value
	}; console.log(content)
	//등록된 객체 푸쉬
	contents.push(content) 
	//빈칸으로
	document.querySelector('.modal_input').value = '';
	//듣기
	document.querySelector('.modal_wrap').style.display="none"
	date()
	
	
})

//해당 날짜 컨텐츠 출력
function modal_print( fdate){
	//헤더
	let html = `<tr>
					<td width="5%"> #</td> <td> 일정내용 </td> <th width="15%"> 비고 </th>
				</tr>` 
	
	//일정을 1부터 동일하면 2,3,4.. 증가
	let i = 1;
	contents.forEach((obj,idx)=>{ //컨텐츠 날짜와 동일하면 출력
		if(obj.date == fdate){
			html += `<tr>
						 <td> ${i} </td> <td>${obj.content}</td> 
						 <th><button class="del" style="background-color : ${o.color}"
						 onclick="Del(${idx})">삭제</button> </th>
					 </tr>`
			i++
		}
	})			
	document.querySelector('.table').innerHTML = html
}

//삭제
function Del(i){
	contents.splice(i,1);
	document.querySelector('.modal_wrap').style.display="none"
	date()
}