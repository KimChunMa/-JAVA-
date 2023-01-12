let star1 = Number(prompt("별줄을 확인하세요"))
let output = '';

//상단 별
for ( let i = star1 ; i >= 1 ; i--)
{
		//왼쪽 별
		for(let j = 1 ;j < star1 ; j++){
			//왼쪽은 항상 주어진값보다 가로가 1 작아야됨 
			
			if( j < i ){ // 
				output += ' '
			}  else{ 
				output += '*'
			} 
		}
		
   //오른쪽 별
		for(let k = star1 ; k >= 1 ; k --){
			//오른쪽은 항상 주어진값과 가로가 동일해야됨 
			if(k >= i ){
				output += '*'
			}else { //공백 없어도됨
				output += ' '
			}
		}	
	output += '\n'
}


//하단 별
for (let i = 1 ; i <=star1 ;i++){
	//왼쪽별
	for(let j= 1 ; j <= star1 ;j++)
	{
		if(j>=i){
			output+="*"
		}else{
			output += " "
		}
	}
	//오른쪽 별
	for (let k = star1 ; k >= 1 ; k--){
		if(k >i){
			output +="*"
		}else{
			output+= ""
		}
	}
	output += '\n'
}



console.log(output)