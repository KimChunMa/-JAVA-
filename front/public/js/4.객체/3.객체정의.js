let 변수 = 10;
const 상수 = 10;
let 배열 = [1,2,3]
let 객체 = {나이:11,배열,상수,변수}
function 함수() {console.log('함수실행');}

let 객체1 = { // 객체, 변수, 배열, 상수, 변수, 함수 ,직접 입력 등 모든 데이터를 포함시킴
	이름 : '유재석',
	나이 : 변수,
	점수 : 배열,
	정보 : 객체,
	주민 : 상수,
	행동 : 함수
}

console.log(객체1)
console.log(객체1.이름)
console.log(객체1.점수[2])
console.log(객체1.정보.나이)
console.log(객체1.행동)
객체1.행동()

