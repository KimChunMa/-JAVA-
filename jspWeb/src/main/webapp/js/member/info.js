	console.log(memberInfo);
	console.log(memberInfo.mpoint);

	
	document.querySelector('.mid').innerHTML = memberInfo.mid;
	document.querySelector('.memail').innerHTML = memberInfo.memail;
	
		console.log(memberInfo.mpoint);

	document.querySelector('.mimg').src=`/jspWeb/member/pimg/${memberInfo.mimg == null ? 'default.webp' : memberInfo.mimg}`;
		console.log(memberInfo.mpoint);
	document.querySelector('.mpoint').innerHTML = memberInfo.mpoint;
	


	