$(function(){
	navBarSlide();
})

/* 보형 NavBar Slide */
function navBarSlide(){
	$('body').on('click','#teacher-manage', function(){
		var teacher = $('#teacher-ul');
		teacher.slideToggle('fast');
	})
	
	$('body').on('click','#lecture-manage', function(){
		$('#lecture-ul').slideToggle('fast');
	})
	
	$('body').on('click','#student-manage', function(){
		$('#student-ul').slideToggle('fast');
	})
	
	$('body').on('click','#schedule-manage',function(){
		$('#schedule-ul').slideToggle('fast');
	})
	
	$('body').on('click','#approval-manage',function(){
		$('#approval-ul').slideToggle('fast');
	})
	
	$('body').on('click','#account-manage',function(){
		$('#account-ul').slideToggle('fast');
	})
}