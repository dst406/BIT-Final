$(function(){
	getBoardLeftNavBar();
	topbarDropdownToggle();
	
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