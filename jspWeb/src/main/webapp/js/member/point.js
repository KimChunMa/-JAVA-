  var IMP = window.IMP; // 생략 가능
  IMP.init("imp45847583"); // 예: imp00000000a
  
  function requestPay() {
	  
	  if(pay==0){
		  alert('충전할 금액을 선택해주세요')
		  return;
	  }
	  
    IMP.request_pay({
      pg: "kakaopay",
      pay_method: "card",
      merchant_uid: "ORD20180131-0000011",   // 주문번호
      name: "노르웨이 회전 의자", 
      amount: pay,                         // 숫자 타입
      
      buyer_email: "gildong@gmail.com", //관리자 정보
      buyer_name: "홍길동",
      buyer_tel: "010-4242-4242",
      buyer_addr: "서울특별시 강남구 신사동",
      buyer_postcode: "01181"
    }, function (rsp) { // callback
      if (rsp.success) { // 결제성공
		  console.log(rsp)
      } else { //결제 실패
		  console.log(rsp)
		  
		  let info = {
			  mpcomment : '포인트 충전',
			  mpamount : pay,
			  mno: memberInfo.mno
		  }
		  
		  console.log(info)
		  
		  $.ajax({
				url:"/jspWeb/point", // ??? 응답x
				method:"post",
				data: info,
				success:(r)=>{
					if(r=="true"){alert('충전성공')}
				}
			  
		  })//ajax e
      }//else e
    });
  }
  
  let pay = 0 ;
  
function setpay(p){
	  pay = p;  
	 requestPay();
}


//--------------------------------------- 본인인증 -------------------
IMP.certification({
    merchant_uid : 'merchant_' + new Date().getTime() //본인인증과 연관된 가맹점 내부 주문번호가 있다면 넘겨주세요
}, function(rsp) {
    if ( rsp.success ) {
    	 // 인증성공
        console.log(rsp.imp_uid);
        console.log(rsp.merchant_uid);
        
        $.ajax({
				type : 'POST',
				url : '/certifications/confirm',
				dataType : 'json',
				data : {
					imp_uid : rsp.imp_uid
				}
		 }).done(function(rsp) {
		 		// 이후 Business Logic 처리하시면 됩니다.
		 });
        	
    } else {
    	 // 인증취소 또는 인증실패
        var msg = '인증에 실패하였습니다.';
        msg += '에러내용 : ' + rsp.error_msg;

        alert(msg);
    }
});



  
  