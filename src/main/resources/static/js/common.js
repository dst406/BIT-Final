$(function(){

	$('.main-icon-menu .nav-link').on('click',function(event){
		$.ajax({
			url: "/getNavbar/jin2020"
		}).done(function(data){
			$('.menu-body').html(data);
			$('.nav-link').removeClass('active');
			$(event.target).closest('.nav-link').addClass('active');
			$('.main-icon-menu-pane:first-child .metismenu').addClass('active');

		})
		
	})
	
})
