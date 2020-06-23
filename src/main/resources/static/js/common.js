$(function(){
	// 게시판 그룹 불러오기

			$('.menu-body').html(data);
			$('.nav-link').removeClass('active');
			$(event.target).closest('.nav-link').addClass('active');
			$('.main-icon-menu-pane:first-child .metismenu').addClass('active');
			
	
	
	
	
//		$('#board').on('click',function(event){
//		$.ajax({
//			url: "/getNavbar/jin2020"
//		}).done(function(data){
//			$('.menu-body').html(data);
//			$('.nav-link').removeClass('active');
//			$(event.target).closest('.nav-link').addClass('active');
//			$('.main-icon-menu-pane:first-child .metismenu').addClass('active');
//			
//		//	var popupLink = document.querySelector('.editBoardGroup-popup-link');
//			
//		//	popupLink.addEventListener('click',getModalFormEditPage);
//		})
//		
//	})
	
})
