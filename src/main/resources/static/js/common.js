$(function(){
	// 게시판 그룹 불러오기
	$('.leftbar-tab-menu .nav-link').on('click',function(){
		$.ajax({
			url: "/getNavbar/jin2020"
		}).done(function(data){
			$('.menu-body').html(data);
			$('.main-icon-menu-pane:first-child .metismenu').addClass('active');
		//	var popupLink = document.querySelector('.editBoardGroup-popup-link');
			
		//	popupLink.addEventListener('click',getModalFormEditPage);
		})
		
	})
	
})
