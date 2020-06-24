$(function(){
	navBarSlide();
})

/* 보형 NavBar Slide */

function navBarSlide(){
	$('#lecture-manage').on('click', function(){
		var lecture = $('#lecture-ul');
		lecture.slideToggle('fast');
	})
	
	$('#student-manage').on('click', function(){
		$('#student-ul').slideToggle('fast');
	})
	
	$('#schedule-manage').on('click', function(){
		$('#schedule-ul').slideToggle('fast');
	})
	
	$('#approval-manage').on('click',function(){
		$('#approval-ul').slideToggle('fast');
	})
	
}