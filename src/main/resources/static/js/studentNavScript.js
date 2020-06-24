$(function(){
	navBarSlide();
})

/* 보형 NavBar Slide */

function navBarSlide(){
	$('#lecture-view').on('click', function(){
		var lecture = $('#lecture-ul');
		lecture.slideToggle('fast');
	})

	
	$('#schedule-manage').on('click', function(){
		$('#schedule-ul').slideToggle('fast');
	})

	
}