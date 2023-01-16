/*문제 9*/
let a = Number(prompt("문제9 숫자를 입력하세요"))
let result =  (a%2) ? "홀수":"짝수" 
console.log(result)

/*문제 10*/

let b =  Number(prompt("문제10 숫자를 입력하세요 1"))
let c =  Number(prompt("문제10 숫자를 입력하세요 2"))
let result2 = b>c? b : c 

console.log(result2)

/*문제 11*/

a =   Number(prompt("문제11 숫자를 입력하세요 1"))
b =   Number(prompt("문제11 숫자를 입력하세요 2"))
c =   Number(prompt("문제11 숫자를 입력하세요 3"))

let result3 = a>b ? (a>c ? a : c) : (b>c ? b : c)
// a 가 b 보다 크면 => a 가 c 보다 크면 a, c
//				 => b 가 c 보다 크면 b , c

console.log(result3) 

/* 강사님 */

/*let max = a;

max = max > b ? (max>c ? max : c)  : (b > c ? b : c)

// a가 b보다 크면 => c보다 크면 a,c
// 				=> b보다 c 가 크면 
*/

/*문제 12 */
let abc = [];

a =   Number(prompt("문제12 숫자를 입력하세요 1"))
b =   Number(prompt("문제12 숫자를 입력하세요 2"))
c =   Number(prompt("문제12 숫자를 입력하세요 3"))

abc[0] = a>b ? (a>c ? a : c) : (b<c ? b: c )
abc[1] = a<b ? (b<c ? b : (a<c ? c:a)) : (a<c ? a: c)
// 		a< (b<c)?(a<c<b)?(c<a<b)			b<(a<c)? (c<a)
abc[2] = a<b ? (a<c ? a: c ) : (b<c ? b : c)

console.log(abc[0],abc[1],abc[2])
					

