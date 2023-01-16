/*let math, english, literature;

math=Number(prompt("수학 점수를 입력하세요."))

english=Number(prompt("영어 점수를 입력하세요."))

literature=Number(prompt("국어 점수를 입력하세요."))

console.log("수학 점수는 " + math+" 입니다.")
console.log("영어 점수는 " + english+" 입니다.")
console.log("국어 점수는 " + literature+" 입니다.")

//문자데이터
console.log("총 점수는 "+ (math + english+literature)/3 + " 입니다")


숫자형 Number(prompt('메세지'))
논리형 Boolean(prompt('메세지'))


let a=3;
let b=6;

console.log("와우"+a+b);
*/ 

/* 문제 2*/
let  radius = Number(prompt("문제 2 원의 반지름을 입력하세요"))

console.log("문제 1 원의 넓이는" +(radius * radius *3.14))

/* 문제 3*/
let  num1= Number(prompt("문제 3  실수(1)를 입력하세요"))
let  num2= Number(prompt("문제 3 실수(2)를 입력하세요"))
console.log("문제 2 는" +(num1/num2)*100+'%' )

/* 문제 4*/
let  num3= Number(prompt("문제 4 짝수를 입력하세요"))
console.log("문제 3의 정답은 "+ (!( (num3)%2 )) )
console.log("문제 3의 정답은 "+ ( num3%2 == 0) )

/* 문제 5*/
let  num4= Number(prompt("문제 5 7배수를 입력하세요"))
console.log("문제 4의 정답은 "+(!( (num4)%7 )) )

/*문제 6*/

/*let money= Number(prompt("문제 5 돈을 입력하세요"))
const money1 = parseInt(money/100000)
const money2 = Math.floor((money%100000)/10000)
const money3 = Math.floor(money%100000 %10000 / 1000)

console.log("십만원은 " + money1 + "장, 만원은" + money2 + "장, 천원은"+money3)
*/

let 금액 = Number( prompt('금액 입력') )
console.log( '입력받은 금액 : ' + 금액 )
console.log( '십만원권 : ' + parseInt( 금액 / 100000 )+'장' )
		// 356789 / 100000 -> 3.56789 
		// parseInt( 3.56789 ) -> 3
// ! : 금액에서 십만원 권 제외
금액 = 금액 - parseInt( 금액/100000 ) * 100000
	// 356789 - 300000 -> 56789
 		/* 연산순서
				1. ( 금액/100000 )			3.56789
				2. parseInt( 금액/100000 )	3
				3. * 100000					300000
				4. 금액 - 300000				56789
				5. 금액 = 56789				새로운값 변경 	
		*/
console.log( '만원권 : ' + parseInt(금액/10000) + '장' )
금액 = 금액 - parseInt(금액/10000) * 10000

/* 
56,789 / 10,000 * 10,000= 50,000
56,789 - 50,000 = 6,789
*/

console.log( '천원 : ' + parseInt(금액/1000) + '장' )

/*	-문제7 : prompt 함수 로 아이디와 비밀번호를 입력받아 아이디가 admin 이고 비밀번호가 1234 와 일치하면 
			결과 : true 출력 아니면 false 출력 
	-문제8 : prompt 함수로 정수를 입력받아 홀수 이면서 7배수이면 true 아니면 false 출력
	
	*/

/*문제 7 */

let ID = prompt("아이디를 입력하시오")
let PW = prompt("비밀번호를 입력하시오")

console.log( (ID=='admin') && (PW=='1234') )

/*문제 8*/

let NUM = Number(prompt("홀수이면서 7배수를 입력하시오"))
console.log( (NUM%7 === 0)&&(NUM%2 === 0 ) )


