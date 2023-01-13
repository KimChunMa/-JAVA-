/*이경석 하단ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
//현재 책
 let RentList = ['혼자 공부하는 자바','이것이 자바다','열혈 C언어'];
 
 //테이블시작
 let bookList = `<table> 
 						<tr> 
 							<th>번호</th> <th>도서</th>
 							<th>도서대여여부</th> <th colspan="2">비고</th>
 						</tr>`;
 
 //함수는 끝따옴표
 for(let i = 0 ; i<RentList.length ;i++){
	 bookList += `<tr> 
	 				<td>${i+1}</td>
	 				<td>${RentList[i]}</td>
	 				<td class="book${i}">대여가능</td>
	 				
	 				
	 				<td><input type='button'
	 				onclick="buttonRent( ${i} )"
	 				value="[대여버튼]" id="rental${i}"
	 				/></td>
	 				
	 				<td><input type='button'
	 				onclick="buttonReturn( ${i} )"
	 				value="[반납버튼]" id="return${i}"
	 				disabled
	 				/></td>
	 				</tr>`
 }
bookList+= `</table>`;

document.querySelector('#book_Checkout').innerHTML = bookList;
//테이블 끝


//대여버튼
function buttonRent( i ){
	const target = document.querySelector('#rental'+i);
		target.disabled = true;
		
		const target2 = document.querySelector('#return'+i);
		target2.disabled =false;
	
	alert((i+1)+"번째 책, "+RentList[i] +"  가(이)  대여가 되었습니다")
	document.querySelector('.book'+i).innerHTML = "대여중";
	
}

//반납버튼
function buttonReturn( i ){
	const target = document.querySelector('#rental'+i);
		target.disabled = false;
		
		const target2 = document.querySelector('#return'+i);
		target2.disabled =true;
	
	alert((i+1) +"번쨰 책, "+RentList[i] +"  가(이)  반납이 되었습니다")
	document.querySelector('.book'+i).innerHTML = "대여가능";
}

