getBoard();
function getBoard(){
	let bno = document.querySelector('.bno').innerHTML ;
	console.log(bno)
	
	
		$.ajax({
			url: "/jspWeb/board/info", 		
			method: "get", 
			data: {"type":2, "bno":bno},
			success: (r)=>{
				console.log('통신');
				console.log(r);
			}
		})
	
}