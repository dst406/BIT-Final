$(function(){
	getBoardLeftNavBar();
	topbarDropdownToggle();
	lecturePay();
})

function getBoardLeftNavBar(){
	$('.main-icon-menu .nav-link').on('click',function(event){
		$.ajax({
			url: "/board/getNavbar"
		}).done(function(data){
			$('.menu-body').html(data);
			$('.nav-link').removeClass('active');
			$(event.target).closest('.nav-link').addClass('active');
			$('.main-icon-menu-pane:first-child .metismenu').addClass('active');
		})
	})
}



function topbarDropdownToggle(){
	$('.topbar').on('click','.dropdown-toggle',function(event){
		$target = $(event.target).closest('li').find('.dropdown-menu');
		
		if($target.hasClass('active')){
			$target.removeClass('active');
			return;
		}
		$target.addClass('active');
	})
}


function lecturePay(){
	$('.notification-list').on('click',function(){
		IMP.init('imp89102236');
		
		IMP.request_pay({
		    pg : 'html5_inicis', // version 1.1.0부터 지원.
		    pay_method : 'card',
		    merchant_uid : 'merchant_' + new Date().getTime(),
		    name : '주문명:결제테스트',
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
		        		lectureCode : 2
		        	}
		        }).done(function(result){
		        	alert(result);
		        })
		        
		    } else {
		        var msg = '결제에 실패하였습니다.';
		        msg += '에러내용 : ' + rsp.error_msg;
		    }
		    alert(msg);
		});
		
	})
	
}
	
