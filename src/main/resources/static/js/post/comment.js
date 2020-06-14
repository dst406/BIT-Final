$(function(){
	console.log('아제발 ㅠㅠ');
	insertReply();
	viewComment();
	writeReplyInReply();
})


function insertReply(){
	$('.write_reply').on('click',function(event){
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
			$(event.target).closest('.comment_read_container').find('.comment_reply_wrapper:nth-child(1)').html(data);
			$targetTextarea.val('');
			
			
			$replyCountTarget = $(event.target).closest('.comment_read_container')
								.find('.comment_reply_container span').first(); 
			if($replyCountTarget.text().conatins("답글달기") ){
				$replyCountTarget.text('1 개의 답글');
			}else{
				$replyCount = parseInt( $replyCountTarget.text().split(' ')[0] ) + 1;
				$replyCountText =$replyCountTarget.text().substr(-6);
				$replyCountTarget.text($replyCount+$replyCountText);
			}
		})
	})
}



function viewComment(){
	$('.comment_reply_container').on('click',function(event){
		console.log('ㅠㅠ 왜 안오누');
		$target = $(event.target);
		$viewCommentTarget = $target.closest('.comment_reply_wrapper').find('.comment_read_wrapper').first();
		$writeComment = $target.closest('.comment_read_container').children('.comment_write_wrapper').addClass('active');
		$viewCommentTarget.addClass("active");
		
		
//		$viewCommentTarget.append(
//				'<button class="commnet_reply_write_content active">답글 작성하기</button>'
//		);
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