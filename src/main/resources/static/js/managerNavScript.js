$(function(){
	navBarSlide();
	lectureList();
})


function lectureList(){
	$('#lecture-state-type').on('change', function(){
		location.href = '/teacher/getLectureListByState/' + $(this).val();
	})
	
}


/* 보형 NavBar Slide */

function navBarSlide(){
	$('#teacher-manage').on('click', function(){
		var teacher = $('#teacher-ul');
		teacher.slideToggle('fast');
	})
	
	$('#lecture-manage').on('click', function(){
		$('#lecture-ul').slideToggle('fast');
	})
	
	$('#student-manage').on('click', function(){
		$('#student-ul').slideToggle('fast');
	})
	
	$('#schedule-manage').on('click',function(){
		$('#schedule-ul').slideToggle('fast');
	})
	
	$('#approval-manage').on('click',function(){
		$('#approval-ul').slideToggle('fast');
	})
	
	$('#account-manage').on('click',function(){
		$('#account-ul').slideToggle('fast');
	})
}