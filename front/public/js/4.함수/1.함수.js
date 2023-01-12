function 함수1( x ){
	console.log(2*x)
}

함수1(3) // 6

function 함수2 (x ,y ) {
	console.log(x+y)
}

함수2 ( 3,5)// 8

function 함수3 (x , y,z ){
	let 결과 = x+y+z;
	return 결과;
}

let 결과 = 함수3(1,2,3)
console.log('함수3 결과 값' + 결과 );