document.addEventListener('DOMContentLoaded',() =>{
	console.log('HTML 열림')
})

document.addEventListener('DOMContentLoaded', function(){
	console.log('익명')
})

const h1 = document.querySelector('h1')
console.log(typeof(h1))

h1.innerHTML = '안녕'
h1.style.color = 'red'
h1.style.backgroundColor = 'blue'
h1.style.padding = '10px'


document.addEventListener('DOMContentLoaded',() => {
	const h1Array =document.querySelectorAll('h1')
	console.log(h1Array)
	console.log(typeof(h1Array))
	
	for(let i = 0 ; i < h1Array.length ; i++){
		h1Array[i].innerHTML = '안녕'+i
	}
	
	for(let index in h1Array){ //인덱스
		h1Array[index].innerHTML = '안녕'+index
	}
	
	for(let object of h1Array){//데이터
		object.innerHTML = '안녕'
	}
	
	//배열명.forEach (인수,요소값, 인덱스)=>{실행문}	오브젝트는 데이터
	h1Array.forEach( (object, index , array) => {
		console.log(object); console.log(index); console.log(array);
	})				
})

