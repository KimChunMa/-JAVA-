/*공용 ㅡㅡㅡㅡㅡㅡㅡ*/
let star1 = Number(prompt('입력할 별 갯수를 선택하세요'))

let star2 = star1

let output = ''


/*
for( let i = 1 ; i<=star1 ; i++ ){ // for s 
	// 1. 별출력
	output +='*'
	// 2. 줄바꿈출력  
	if( i % 3 == 0 ){ output +='\n' }
} // for e 
console.log( output )
*/


/*문제 1 */
/*for (let i = 1 ; i <=star1 ; i ++)
{
	for(let j = 1 ; j<=i ; j++){
		output += '*'
	}
	output +='\n'
}

console.log(output)
*/

/*문제 2 */
/*for (let i = 1 ; i <= star1 ; i++)
{
	for(let j = star1 ; j>= i ; j--){
		output += '*'
	}
	output +='\n'
}

console.log(output)*/

/* 문제 3 */

/*for (let i = star1 ; i >= 1 ; i--)
{
	for(let j = 1 ; j <= star1 ; j++){
		if(i<= j){
			output += '*'
		}
		if(i> j){ 
		output += ' '
		}
	}
	output+='\n'
	
}

console.log(output)*/

/*문제 4*/
/*
for (let i = 1; i <= star1 ; i++){
	for(let j = 1 ; j <= star1 ; j++){
		if(j>=i ){
			output += '*'
		}else{
			output+= ' '
		}
	}
	output += '\n'
}
console.log(output)
 */



/*문제 5 */

/*for ( let i = star1 ; i >= 1 ; i--)
{
		for(let j = 1 ;j < star1 ; j++){
			if( j <i){
				output += ' '
			}else{
				output += '*'
			}
		}
		
		for(let k = star1 ; k >= 1 ; k --){
			if(k >= i ){
				output += '*'
			}  else { //오른쪽 공백은 없어도됨
				output += ' '
			} 
		}	
	output += '\n'
}

console.log(output)*/

/*문제 6*/

/*for (let i = 1 ; i <= star1 ; i++, star2--){
	
	for(let j = 1 ; j <= star1 ; j ++){
		if( j == i || j == star2){
			output+= '*'
		}else{
			output += ' '
		}
	}
	
	output+= '\n'
}

console.log(output)*/



