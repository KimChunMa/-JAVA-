/*공용*/
let userbox = document.querySelector('.userbox') //유저박스
let monbox = document.querySelector('.monbox') // 몬스터 박스

let logbox = document.querySelector('.logbox') //좌표알림
let logbox2 = document.querySelector('.logbox2')//몬스터 좌표알림


/*캐릭터 객체*/
let Character ={img:'캐릭터.png', left:10, top:450, hp:100,
exp:0, level:1}
/*캐릭터 공격력*/
Character.power=Character.level*10;

/*몬스터 배열*/
let monsters = [
	{img: '주황버섯.gif', hp:100, left:910, top:500, exp:1 , power:1, },
	{img: '독버섯.gif', hp:200, left:910, top:500, exp:2 , power:2},
	{img: '철버섯.gif', hp:250, left:910, top:500, exp:3 , power:3}
	]

/*몬스터 단계*/
let step = 0;
monster(step)
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/


//문서에 키입력시 발생하는 이벤트 (유저)
document.addEventListener('keydown',(e)=>{
	
	let key = e.keyCode;
	
	if(key == 37){//왼쪽
		Character.left -= 10
		Character.left = Character.left < 0 ? 0 : Character.left; //0보다 작으면 0고정
	
	}else if(key == 39){//오른쪽
		Character.left += 10
		userbox.style.backgroundImage = `url(img/이동.png)`
		Character.left = Character.left >= 910 ? 910 : Character.left;
	}
	
	userbox.style.left = `${Character.left}px`
	logbox.innerHTML = `<div> 좌표 : ${Character.left}</div>`
})

//키를 떼었을떄
document.addEventListener('keyup',(e)=>{
	userbox.style.backgroundImage = `url(img/${Character.img})`
	userbox.style.backgroundSize = `cover`
})


//몬스터 이동 [난수]
setInterval(mon_moving, 1000)

function mon_moving(){
		//0~1사이 => 0~70사이 => 1~71사이
	let rand = parseInt(Math.random()*70+1);  //이동거리
	
	let rand2 = parseInt(Math.random()*2); //이동방향 0또는 1
	if(rand2==1){monsters[step].left +=rand}
	else{monsters[step].left -=rand}
	
	//최대거리
	if(monsters[step].left<0){monsters[step].left = 0;}
	if(monsters[step].left>910){monsters[step].left = 910;}
	
	//실제 이동
	monbox.style.left = `${monsters[step].left}px`
	logbox2.innerHTML = `<div>몹 좌표 : ${monsters[step].left}</div>`
	
}

/*1. [공격시]*/
document.addEventListener('keydown',(e)=>{
	let key = e.keyCode;
	
	if(key == 65){ //a키 모션
		userbox.style.backgroundImage = `url(img/공격.png)`
		userbox.style.backgroundSize = `105%`
	
		//a키중 몬스터 범위 +-10일때 체력달기
		if(Character.left >= monsters[step].left - 100 
		&& Character.left <= monsters[step].left + 100 ){
		//몬스터 체력 -= 공격력 * 10이하 난수
		monsters[step].hp -= Character.power*( parseInt(Math.random()*2+1));
		hp();
		} //사거리 감소	
	} //a키 모션 끝
	
	/*방어 모드*/
	if(key == 83){ //s키 모션
		userbox.style.backgroundImage = `url(img/방어.png)`;
		userbox.style.backgroundSize = `contain`;
		monster_attack(false); 
	}else{monster_attack(true); }
	
})

/*1-2체력*/
function hp(){
	
	if(monsters[step].hp <=0){ //몬스터 0일시 
		alert('처치하였습니다.');	
		step++; 
		monster(step); //몬스터 +1단계
		user_location(); // 유저,hp제자리
		
		return;
	}
	
	if(Character.hp <=0){ //유저 0일시 게임오버
		alert('game over');	
		return;
	}
	
	
	let u_bar = document.querySelector('.u_bar') //유저체력
	u_bar.style.width =`${Character.hp * 1.5}px`
	
	let m_bar = document.querySelector('.m_bar')//몬스터 체력
	m_bar.style.width =`${monsters[step].hp * 1.5}px` 			
	
}

/*2. [공격 받을시]*/

function monster_attack( bool ){
		if(bool == false){  //방어시 그냥 스킾
			return;
		}else if ( bool == true ){ //방어를 안할시 hp 감소
		//유저범위 +-60일때 체력 감소 
			if(monsters[step].left >= Character.left - 60 && monsters[step].left <= Character.left + 60 )
			{
			//몬스터 체력 -= 공격력 * 10이하 난수
			Character.hp -=monsters[step].power* ( parseInt(Math.random()*10+1) );
			hp();
			}
		} 
		
}

/*몬스터 교체*/
function monster(i){
	if(i == 3){
		alert('컨텐츠가 종료되었습니다.');
	}
	
	let monster = document.querySelector('.monbox')
	monster.style.backgroundImage = `url(img/${monsters[i].img})`
	monster.style.left = `${monsters[i].left}`
	monster.style.top = `${monsters[i].top}`
	monster.style.width = `${monsters[i].hp}.px`
	
	
}

/*유저,hp 원위치*/
function user_location(){
	Character.left = 10;
	userbox.style.left = `${Character.left}px`
	Character.hp = 100;
	hp();
}

status()
/*상태창*/
function status(){
  let html = `
  		<li> 레벨 : ${Character.level} </li>
  		<li> 경험치 : ${Character.exp}	</li>
  		<li> HP : ${Character.hp}	</li>
  		<li> 공격력 : ${Character.power} </li>`
  
  document.querySelector('.user_status').innerHTML = html
}
