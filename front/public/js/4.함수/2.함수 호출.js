
function 함수1(){ // 시작
	console.log('함수1 ')	
} // 함수끝


함수1();

function 함수2( x ) {
	console.log('함수2 실행' + x)
}


함수2(7)

function 함수3 ( x,y){
	console.log('함수 3: '+  (x + y) )
}

함수3(1,1)


function 함수4 (x,y,z){
	return x+y+z;
}

let result = 함수4 (1,2,3)
console.log(result)



