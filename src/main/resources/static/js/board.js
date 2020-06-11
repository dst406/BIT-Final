$(function(){
	clickMorePostList();
	initPostDetail();
//	console.log( $('.postListWrapper li a:contains('+$.trim( $('textarea#postTitle').val() )+')').attr('data-number') );
//	$('.postListWrapper li a:contains('+$.trim( $('textarea#postTitle').val() )+')').addClass('active');
	
})


function initPostDetail(){
	const postListTarget = $('.postListWrapper li a:contains('+$.trim( $('textarea#postTitle').val() )+')');
	$('#thisPostNumber').text(postListTarget.attr('data-number'));
	postListTarget.addClass('active');
}

function clickMorePostList(){
	$('.postListViewGuide').on('click',function(){
		if( $('.postListWrapper').hasClass('active')){
			 $('.postListWrapper').removeClass('active');
			 $('.morePostList').text('목록보기');
			 $('.postListViewGuide path').attr('d','M7 10l5 5 5-5z');
			 return;
		}
		
		$('.morePostList').text('숨기기');
		$('.postListViewGuide path').attr('d','M7 14l5-5 5 5z');
		$('.postListWrapper').addClass('active');
	})
}