let num1 = Number(prompt("문제 1 입력하세요"))

if(num1>=90){
	console.log("합격")
	
}
else{
	console.log("탈락")
	
}


let str = String(prompt("문제 2 입력하세요"))

if(str=="M" || 
str=="m" || 
str=="남" || 
str=="남자" ) {
	console.log("남자 군요")
	
}else if(str=="w" || str=="W" || str=="여" || str=="여자"  ){
	console.log("여자 군요")
	
}else{
	console.log("남자면 \"m,M,남,남자\" 여자면 \"w,W,여,여자\" 라고 입력하세용가뤼")
	
}

num1 = Number(prompt("문제 3점수를 입력하세요"))
if (num1 >= 90){
	console.log("A등급")
	
}else if (num1 >= 80){
	console.log("B급")
	
}else if (num1 >= 70){
	console.log("C급")
	
}else{
	console.log("탈락")
	
}