$(function(){
	console.log('아제발 ㅠㅠ');
	insertReply();
	viewComment();
	//writeReplyInReply();
	insertComment();
	commentWriteEvent();
//	$('.write_reply').handle(insertReply());
//	$('.comment_reply_container').handle(viewComment());
//	$('.comment_read_wrapper').handle(writeReplyInReply());
})



function insertComment(){
	$('.comment_container').on('click','.write_comment',function(event){
		 console.log('흠 왜 두번올까요 ? ');
		$.ajax({
			url:"/insertPostComment" ,
			type:"POST",
			data:{
				commentContent: $('textarea#commentContent').val(),
				postNo : $('#postNo').val()
			}
		}).done(function(data){
			$('textarea#commentContent').val('');
			$commentCount = parseInt( $('.comment_line h4').text().split(' ')[0] ) + 1;
			$commentCountText = $('.comment_line h4').text().substr(-6);
			$('.comment_line h4').text($commentCount+$commentCountText);
			$('.comment_read_wrapper').html(data);
			console.log('호옹이..');
		})
	})
}






function insertReply(){
	$('.comment_container').on('click','.write_reply',function(event){
		$targetTextarea=$(event.target).closest('.comment_write_wrapper')
		.find('textarea[name="commentContent"]');
		$.ajax({
			url:"/insertReply" ,
			type:"POST",
			data:{
				commentContent: $targetTextarea.val(),
				commentNo : $(event.target).attr('comment-no'),
				postNo : $('#postNo').val()
			}
		}).done(function(data){
			
			$(event.target).closest('.comment_read_container').
					find('.comment_reply_wrapper .comment_read_container').html(data);
			$targetTextarea.val('');
			
			$replyCountTarget = $(event.target).closest('.comment_read_container')
								.find('.comment_reply_container span').first(); 
			
			
			console.log( $replyCountTarget);
			
			if($replyCountTarget.text() == "답글달기" ){
				$replyCountTarget.text('1 개의 답글');
			}else{
				$replyCount = parseInt( $replyCountTarget.text().split(' ')[0] ) + 1;
				$replyCountText =$replyCountTarget.text().substr(-6);
				$replyCountTarget.text($replyCount+$replyCountText);
			}
		})
	})
}
function commentWriteEvent(){
	// 답글 작성하기 누를때
	$('.commnet_reply_write_content').on('click',function(event){
		$target = $(event.target);
		$target.toggleClass('active');
		$target.closest('.comment_read_container ').find('.comment_write_wrapper').toggleClass('active');
		
		//showCommentWrite($(event.target));
	})
	
	// 취소 버튼 누를 떄
	$('.cancel_comment').on('click',function(event){
		hideCommentWrite($(event.target));
	})
	
	
	
}


function showCommentWrite($target){
		$target.closest('.comment_reply_container').toggleClass('active');
		$target.closest('.comment_read_container ').find('.comment_write_wrapper').toggleClass('active');
}
function hideCommentWrite($target){
		$target.closest('.comment_write_wrapper').toggleClass('active');
		$target.closest('.comment_read_container ').find('.commnet_reply_write_content').toggleClass('active');
		
}


function viewComment(){
	$('.comment_container ').on('click','.comment_reply_wrapper .comment_reply_container',function(event){
		$target = $(event.target);
		
		$viewCommentTarget = $target.closest('.comment_reply_wrapper').find('.comment_read_wrapper');
		$showTarget = $viewCommentTarget.first();
		$commentCountText = $target.closest('.comment_reply_container').find('span');
		$icon =  $target.closest('.comment_reply_container').find('path').first();
		console.log($(event.target));
		// ↓ 댓글 보이기 이벤트임
		if(! $showTarget.hasClass('active')){
			$commentCountText.text('숨기기');
			$icon.attr('d','M9.5 6.5v-1h-7v1h7z');
			//showCommentWrite(event);
		// ↓ 댓글 숨기기 이벤트임
		}else{
			$length = $commentCountText.attr('comment-length');
			$length != 0 ? $commentCountText.text($length+' 개의 댓글' ) : $commentCountText.text('답글달기');
			$icon.attr('d','M5.5 2.5h1v3h3v1h-3v3h-1v-3h-3v-1h3v-3z');
		}
		
		//$writeComment = $target.closest('.comment_read_container').children('.comment_write_wrapper').toggleClass('active');
		$viewCommentTarget.first().toggleClass('active');
		
		//$viewCommentTarget.get(0).className  += " "+"active";
		//$viewCommentTarget.get(1).className  += " "+"active";
		 
		
	})
	
}


function writeReplyInReply(){
	$('.comment_read_wrapper').on('click','.commnet_reply_write_content',function(event){
		$target = $(this).closest('.comment_reply_wrapper').find('.comment_write_wrapper');
		console.log($target);
		//(event.target).closest('.comment_read_container').find('.username > a').text();
		$target.hasClass('active');
		
		
	})
}