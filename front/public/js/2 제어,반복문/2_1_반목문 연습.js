/*for(let i = 0 ; i <= 10; i++){
	console.log(i);
}

let output = '';

for(let i = 1 ;i <= 10 ; i++ ){

	output += (i + " ")
}

console.log(output);

console.log("예 3 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ")
output  = ''

for (let i = 0; i<10; i++){
	output += i + "\t" 
}

console.log(output)
document.querySelector('#a').innerHTML = output;

console.log("예 4 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ")

let sum = 0 ;
for(let i = 0 ; i <=10 ; i ++){
	sum += i ;
	document.querySelector('#a').innerHTML = sum;

}

console.log("예 5 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ")

sum = 0 ;
for(let i = 0 ; i <=100 ; i+=7){
	sum += i ;
	document.querySelector('#a').innerHTML = sum;
}

console.log("예 6 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ")

sum = 0 ;
for(let i = 0 ; i <=100 ; i++){
	if(i%7==0){
	sum += i ;
	document.querySelector('#a').innerHTML = sum;
	}
}

*/
let a = '';

for(let i = 1 ; i <10 ; i++){
	for(let j = 2 ; j < 10 ; j++)
	{
		a += (j + "*" + i +"=" + i*j +'&nbsp&nbsp&nbsp&nbsp')
		document.querySelector('body').innerHTML = a;
	}
	a+='<br/>'
}
