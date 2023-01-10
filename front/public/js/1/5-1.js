/* (+,-,*,/,%)= 대입연산자*/
let a =3;

a+=3;

console.log(a)

a-=3

console.log(a)

a%=3;

console.log(a)


let html = '<h3>와우</h3>'
html += '<div>우외</div>'
document.write(html);


/*증감 연산자*/

console.log("증감연산자")

let b=0


console.log(b++) //출력후 증가
console.log(++b)


console.log(b--) //출력후 감소
console.log(--b)

/* 삼항 연산자*/
let age=38;
let 나이대 = age<=19? '청소년' : '성인'

console.log(나이대)

let 점수 = 78;
let 등급 = 점수 >= 90 ? 'A' 
		: 점수 >= 80 ? 'B등급' 
		: 점수 >= 70 ? 'C등급'
		: '탈락' 

console.log(등급)



