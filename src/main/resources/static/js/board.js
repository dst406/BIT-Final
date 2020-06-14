$(function(){
	clickMorePostList();
	initPostDetail();
	searchPosts();
	insertComment();

//	console.log( $('.postListWrapper li a:contains('+$.trim( $('textarea#postTitle').val() )+')').attr('data-number') );
//	$('.postListWrapper li a:contains('+$.trim( $('textarea#postTitle').val() )+')').addClass('active');
	
})



function searchPosts(){
	$('.searchPost').on('keyup',function(event){
		$search = $(this).val();
		$('strong, div, a').unmark();
		$searchVal = $('.article-post-list strong:contains('+$search+') , .post-list-info:contains('+$search+'),'
				+' .post-list-contents-bottom a:contains('+$search+')') ;
		$('.article-post-list').hide();
		$searchVal.closest('.article-post-list').show();
		$searchVal.mark($(this).val());
	})
}


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


function insertComment(){
	$('.write_comment').on('click',function(event){
		$.ajax({
			url:"/insertPostComment" ,
			type:"POST",
			data:{
				commentContent: $('textarea#commentContent').val(),
				postNo : $('#postNo').val()
			}
		}).done(function(data){
			$commentCount = parseInt( $('.comment_line h4').text().split(' ')[0] ) + 1;
			$commentCountText = $('.comment_line h4').text().substr(-6);
			$('.comment_line h4').text($commentCount+$commentCountText);
			$('.comment_read_wrapper').html(data);
		})
	})
}



