// 230113, 김태호 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
let BookList = ['혼자공부하는자바','이것이자바다','열혈 C언어']

// 1-1. 검색창 도서명 JS 연결 및 검색 버튼 함수 생성 (기능 )
function bookSearch(){
		//console.log("검색 함수 작동 확인")
	
	let bookSearch = document.querySelector('.bookResist_HTML').value;
	
	let confirm = 0;
	
	if( bookSearch.length >= 5 && bookSearch.length <= 10 ){
		//console.log(BookList)
		confirm = 0
		printBookList()
	}
	else{
			//console.log(confirm)
		alert("도서명을 다시 입력하시오.(입력범위: 5 ~ 10)")
		confirm++
	}
	return confirm
}

// 1-2. 저장 버튼 함수 생성
function bookSave(){
		//console.log('저장 함수 작동 확인')
	
	let bookSave = document.querySelector('.bookResist_HTML').value;
	
	let confirm = bookSearch();
		// console.log(confirm)
	
	if(confirm == 0){
		// console.log(BookList)
		
		for( let i = 0; i < BookList.length; i++){
			// console.log(BookList[i])
			if(bookSave == BookList[i]){
				confirm++;
				// console.log(confirm)
				printBookList()
				alert("이미 등록된 도서입니다. 다시 확인해주세요.")
			}		
		}
	}
	if(confirm == 0){
		BookList.push(bookSave)		
		printBookList()		

		// console.log(BookList)
	}
}

// 2-1. 도서 현황 출력 함수 생성
function printBookList(){
	let tableBookList = '<table class="tableBookList"><tr> <th class="list1">번호</th> <th class="list2">도서명</th> <th class="list3">도서 대여 여부</th> <th class="list4">비고</tr></table>';
	// 해석: JS 변수 bookList 선언
	
	for(let i = 0; i < BookList.length; i++){
		tableBookList += `<table class="tableBookList">
							<tr>
								<th class="list1"> ${(i+1)} </th>
								<th class="list2"> ${BookList[i]} </th>
								<th class="list3"> <button onclick="checkRent( ${i} )">대여현황 확인</button></th>
						  	   	<th class="list4"> <button onclick="buttonDelete( ${i} )">삭제</button> </th>
					 	  </tr>
					 	 </table>`	
	}
	document.querySelector('.adminBookListPrint').innerHTML = tableBookList	
}

// 2-2. 도서대여 여부 (합체)


// 2-3. 삭제버튼 함수 생성
function buttonDelete( dNum ){

	BookList.splice( dNum, 1 )
	printBookList()
	alert("정상적으로 삭제되었습니다.")
}




/*이경석 하단ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
//현재 책
 let RentList = ['혼자 공부하는 자바','이것이 자바다','열혈 C언어'];
 
 //테이블시작 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
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

//고객페이지 밑에 붙여넣기
document.querySelector('#book_Checkout').innerHTML = bookList;
//테이블 끝 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ


//대여버튼
function buttonRent( i ){
	const target = document.querySelector(`#rental${i}`); //대여버튼을 누르면, 대여버튼 비활성화
		target.disabled = true;
		
		const target2 = document.querySelector('#return'+i);  //대여버튼을 누르면, 반납버튼 활성화
		target2.disabled =false;
	
	alert((i+1)+"번째 책, "+RentList[i] +"  가(이)  대여가 되었습니다")
	document.querySelector(`.book${i}`).innerHTML = "대여중";
	
}

//반납버튼
function buttonReturn( i ){
	const target = document.querySelector(`#rental${i}`); //반납버튼을 누르면, 대여버튼 활성화
		target.disabled = false;
		
		const target2 = document.querySelector('#return'+i); //반납버튼을 누르면, 반납버튼 비활성화
		target2.disabled =true;
	
	alert((i+1) +"번쨰 책, "+RentList[i] +"  가(이)  반납이 되었습니다")
	document.querySelector('.book'+i).innerHTML = "대여가능";
}

