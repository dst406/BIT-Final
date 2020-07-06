$(function(){
	lecturePay();
})


function lecturePay(){
	$('body').on('click','.buyLectureButton',function(event){
		console.log($(event.target).closest('tr').find('td:nth-child(2)').text());
		IMP.init('imp89102236');
		console.log( $(event.target).closest('tr') );
		console.log( $(event.target).closest('tr').find('.lectureCode') );
		console.log($.trim($(event.target).closest('tr').find('.lectureCode').val()));
		
		IMP.request_pay({
		    pg : 'html5_inicis', // version 1.1.0부터 지원.
		    pay_method : 'card',
		    merchant_uid : 'merchant_' + new Date().getTime(),
		    name : $.trim( $(event.target).closest('tr').find('td:nth-child(2)').text() ),
		    amount : 100, //판매 가격
		    buyer_email : 'iamport@siot.do',
		    buyer_name : '구매자이름',
		    buyer_tel : '010-1234-5678',
		    buyer_addr : '서울특별시 강남구 삼성동',
		    buyer_postcode : '123-456'
		}, function(rsp) {
		    if ( rsp.success ) {
		        var msg = '결제가 완료되었습니다.';
		        msg += '고유ID : ' + rsp.imp_uid;
		        msg += '상점 거래ID : ' + rsp.merchant_uid;
		        msg += '결제 금액 : ' + rsp.paid_amount;
		        msg += '카드 승인번호 : ' + rsp.apply_num;
		        
		        $.ajax({
		        	url:"/student/insertLectureForPayment",
		        	method: "POST",
		        	data:{
		        		paymentMethodNo:2,
		        		lectureCode : $.trim($(event.target).closest('tr').find('.lectureCode').val())
		        	}
		        }).done(function(result){
		        	//내가 수강중인 강의로 이동
		        })
		        
		        
		    } else {
		        var msg = '결제에 실패하였습니다.';
		        msg += '에러내용 : ' + rsp.error_msg;
		    }
		    alert(msg);
		});
		
	})
	
}