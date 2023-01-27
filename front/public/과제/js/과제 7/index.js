/*공용*/
let u_left = 10; let u_top = 420; //유저 좌표
let m_left = 910; //몬스터 좌표

let userbox = document.querySelector('.userbox') //유저박스
let monbox = document.querySelector('.monbox') // 몬스터 박스

let logbox = document.querySelector('.logbox') //좌표알림
let logbox2 = document.querySelector('.logbox2')//몬스터 좌표알림

/* 체력*/
let u_hp=100;
let m_hp=100;

/* 공격력*/
let u_attack = 1; 
let m_attack =1;

/*몬스터 배열*/
let monster = [
	{m_ing: '주황버섯.gif', hp:100, left:910, top:440, exp:1},
	{m_ing: '독버섯.gif', hp:200, left:910, top:440, exp:2},
	{m_ing: '철버섯.gif', hp:300, left:910, top:440, exp:3}
	]
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/

//문서에 키입력시 발생하는 이벤트
document.addEventListener('keydown',(e)=>{
	
	let key = e.keyCode;
	
	if(key == 37){//왼쪽
		u_left -= 10
		u_left = u_left < 0 ? 0 : u_left; //0보다 작으면 0고정
	
	}else if(key == 39){//오른쪽
		u_left += 10
		userbox.style.backgroundImage = `url(img/이동.png)`
		u_left = u_left >= 910 ? 910 : u_left;
	}
	
	userbox.style.left = `${u_left}px`
	logbox.innerHTML = `<div> 좌표 : ${u_left}</div>`
})

//키를 떼었을떄
document.addEventListener('keyup',(e)=>{
	userbox.style.backgroundImage = `url(img/캐릭터.png)`
	userbox.style.backgroundSize = `cover`
})


//몬스터 이동 [난수]
setInterval(mon_moving, 1000)

function mon_moving(){
		//0~1사이 => 0~10사이 => 1~11사이
	let rand = parseInt(Math.random()*70+1);  //이동거리
	
	let rand2 = parseInt(Math.random()*2); //이동방향 0또는 1
	if(rand2==1){m_left +=rand}
	else{m_left -=rand}

	if(m_left<0){m_left = 0;}
	if(m_left>910){m_left = 910;}
	monbox.style.left = `${m_left}px`
	logbox2.innerHTML = `<div>몹 좌표 : ${m_left}</div>`
	
	monster_attack(); //몬스터 공격
}

/*1. [공격시]*/
document.addEventListener('keydown',(e)=>{
	let key = e.keyCode;
	
	if(key == 65){ //a키 모션
		userbox.style.backgroundImage = `url(img/공격.png)`
		userbox.style.backgroundSize = `105%`
	
		//a키중 몬스터 범위 +-10일때 체력달기
		if(u_left >= m_left - 100 && u_left <= m_left + 100 ){
		//몬스터 체력 -= 공격력 * 10이하 난수
		m_hp -=u_attack* ( parseInt(Math.random()*20+1) );
		
		hp();
		}	
		
	}
	
	
})

/*1-2체력*/
function hp(){
	
	if(m_hp <=0){ //몬스터 0일시 안보이게
		alert('처치하였습니다.');	
		document.querySelector('.monbox').style.display="none"
		return;
	}
	
	if(u_hp <=0){ //유저 0일시 게임오버
		alert('game over');	
		return;
	}
	
	
	let u_bar = document.querySelector('.u_bar') //유저체력
	u_bar.style.width =`${u_hp * 3}px`
	
	let m_bar = document.querySelector('.m_bar')//몬스터 체력
	m_bar.style.width =`${m_hp * 3}px` 			
	
	console.log('몬'+ m_hp);
	console.log('유'+ u_hp);
}

/*2. [공격 받을시]*/
function monster_attack(){
	
		//유저범위 +-60일때 체력 감소 
		if(m_left >= u_left - 60 && m_left <= u_left + 60 )
		{
		//몬스터 체력 -= 공격력 * 10이하 난수
		u_hp -=m_attack* ( parseInt(Math.random()*10+1) );
		hp();
		}
}