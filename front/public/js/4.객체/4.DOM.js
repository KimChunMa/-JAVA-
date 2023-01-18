let h1 = `<h1> ${'하이'}</h1>`
document.body.innerHTML = h1;

	//일반
function 함수1(){console.log('문서열림')}
window.onload = 함수1()
window.addEventListener('DOMContentLoaded', 함수1)

	// 익명 함수
window.onload = function() {console.log('문서열림2')}
window.addEventListener('DOMContentLoaded', function(){console.log('문서열림2')})

	//화살표 (인수) => { 실행문 }
window.onload = () =>{ console.log('문서열림3')}
window.addEventListener('DOMContentLoaded', () => {console.log('문서열림3')})

let 변수 = () => {console.log('문서열림4')}


let 익명함수 = function (){console.log('문서열림5')}
let 객체 = {행동 : () => {console.log('문서열림6')}}