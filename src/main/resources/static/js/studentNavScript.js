$(function(){
	navBarSlide();
})

/* 보형 NavBar Slide */

function navBarSlide(){
	$('#student-lecture-view').on('click', function(){
		console.log('ddd');
		$('#student-lecture-ul').slideToggle('fast');
	})

	
}