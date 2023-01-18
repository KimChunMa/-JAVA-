let selectbox = document.querySelector('.selectbox')
selectbox.addEventListener('change',(e) =>{
	console.log(e) //이벤트 결과
	
	console.log(e.currentTarget) 
	// 이벤트를 실행한 곳
	console.log(e.currentTarget.options)
	//모든 옵션들의 배열을 가져옴
	
	console.log(e.currentTarget.options.selectedIndex)
	//선택한 인덱스
	
	let option = e.currentTarget.options
	let index = e.currentTarget.options.selectedIndex
	
	console.log(option[index].text)
	//배열중 선택한 배열 가져오기 (.value, .innerHTML, .text)
	
	document.querySelector('h3').innerHTML = `선택한 옵션 : ${option[index].text}`
})

let check = document.querySelector('.checkbox')
check.addEventListener('change', (e)=>{
	console.log(e)
	
	console.log(e.currentTarget) //무엇이 작동했는가
	
	console.log(e.currentTarget.checked)//체크되었는가
})

let timer = 0
let timerId = 0

let timerbox = document.querySelector('.timerbox')
let timerspan = document.querySelector('.timerspan')
timerbox.addEventListener('change',(e)=>{
	if(e.currentTarget.checked){
		
		timerId = setInterval( () => {
			timer++
			timerspan.innerHTML = timer + '초'
		},1000)
		//특정 시간마다 함수 실행
		
	}else{
		clearInterval(timerId)
		timer=0
		timerspan.innerHTML = ''
	}
})