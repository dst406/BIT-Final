$(function(){
	console.log('아제발 ㅠㅠ');
	insertReply();
	viewComment();
	//writeReplyInReply();
	insertComment();
	commentWriteEvent();
	viewReplyComment();
	viewWriteCommentAreaFirst();
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





// 대댓글은 잘 되는데 댓글이 안됨 ;
function insertReply(){
	$('.comment_container').on('click','.write_reply',function(event){
		$targetTextarea=$(event.target).closest('.comment_write_wrapper')
		.find('textarea[name="commentContent"]');
		var targetClass = $(event.target).closest('.button_wrapper').find('.write_reply').hasClass('write_re_reply');
		console.log($(event.target).closest('.button_wrapper').find('write_reply'));
		console.log(targetClass);
		
		var url = ! targetClass ? "/insertReply" : "/insertReplyInReply";
		$.ajax({
			url:url ,
			type:"POST",
			data:{
				commentContent: $targetTextarea.val(),
				commentNo : $(event.target).data("comment-no"),
				postNo : $('#postNo').val()
				
			}
		}).done(function(data){
			const isFirst = $(event.target).closest('.comment_read_container').find('.comment_reply_container span').attr("data-comment-length") == 0 ?
							true:false;
			const appendTarget = targetClass ?
					$(event.target).closest('.comment_write_wrapper').parent().find('.comment_read_wrapper .comment_read_container') 
					: isFirst
					? $(event.target).closest('.comment_read_container').find('.comment_reply_wrapper .comment_read_container')
					: $(event.target).closest('.comment_read_container').first()
					// $(event.target).closest('.comment_read_container').first() ㅇ ㅣ부분이 잘못됬음 ! 
					
			if(isFirst){
				$(event.target).closest('.comment_write_wrapper').remove();
			}	
					
					
			console.log($(event.target).closest('.comment_write_wrapper').parent());
			console.log($(event.target).closest('.comment_write_wrapper').parent().find('.comment_read_wrapper') );
			console.log(appendTarget);
			
			appendTarget.html(data);
			$targetTextarea.val('');
			
			$replyCountTarget = $(event.target).closest('.comment_read_container')
								.find('.comment_reply_container span').first(); 
			
			
			console.log( $replyCountTarget);
			
			if($replyCountTarget.text() == "숨기기" ){
				$replyCountTarget.attr("data-comment-length", parseInt( $replyCountTarget.attr("data-comment-length"))+1);
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
	$('.comment_read_wrapper').on('click','.commnet_reply_write_content',function(event){
		$target = $(event.target);
		$target.removeClass('active');
		
		console.log($(event.target));
		console.log($target.closest('.comment_reply_view_wrapper ').find('.comment_write_wrapper'));
		
		$target.closest('.comment_reply_view_wrapper ').find('.comment_write_wrapper').last().addClass('active');
		
		//showCommentWrite($(event.target));
	})
	
	// 취소 버튼 누를 떄
	$('.comment_read_wrapper').on('click','.cancel_comment',function(event){
		var target = $(event.target);
		hideCommentWrite(target);
		// 취소 버튼 누르면 숨기기 사라지고 *개의 답글 또는 답글달기로 바뀌기
		
		// *개의 답글, 답글보기로 바뀜
		var $commentCountText = target.closest('.comment_write_wrapper').parent().find('.comment_reply_container span');
		var $length = $commentCountText.attr("data-comment-length");
		console.log( $commentCountText);
		console.log( $length);
		$length != 0 ? $commentCountText.text($length+' 개의 댓글' ) : $commentCountText.text('답글달기');
		$icon.attr('d','M5.5 2.5h1v3h3v1h-3v3h-1v-3h-3v-1h3v-3z');
		
		// 댓글 영역 닫기
		target.closest('.comment_write_wrapper').removeClass('active');
		target.closest('.comment_write_wrapper').parent().find('button').addClass('active');
		target.closest('.comment_write_wrapper').parent()
			.find('.comment_read_wrapper').removeClass('active');
		
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

function viewReplyComment(){
	$('.comment_container').on('click','.reply_comment',function(event){
		console.log($(this).closest('.comment_read_container '));
		$(this).closest('.comment_read_container ').find('.comment_write_wrapper').toggleClass('active');
	})
}


function viewWriteCommentAreaFirst(){
	$('.comment_container').on('click','comment',function(event){
		console.log("여기왔음");
		console.log($(event.target).find('span').data("comment-length"));
		if ( $(event.target).find('span').data("comment-length") == 0 ){
			console.log("띠용 ? ");
			$(event.target).closest('.coment_reply_wrapper').parent().find('.comment_write_wrapper').addClass('active');
		}
	})
}

function viewComment(){
	$('.comment_container ').on('click','.comment_reply_container',function(event){
		$target = $(event.target);
		

		
		// 댓글 입력창 찾기
		//$writeComment = $target.closest('.comment_read_container').find('.comment_write_wrapper');
		//$showWriteTarget = $writeComment.first();
		//$showWriteTarget = $target.closest('.comment_read_container').find('.comment_write_wrapper').first();
		
		// 답글 있는 영역 
		//$viewCommentTarget = $target.closest('.comment_reply_wrapper').find('.comment_read_wrapper');
		//$showViewTarget = $viewCommentTarget.first();
		$showViewTarget = $target.closest('.comment_reply_wrapper').find('.comment_read_wrapper').first();

		// * 개의 답글, 답글달기	
		$commentCountText = $target.closest('.comment_reply_container').find('span');
		// +, -  아이콘 찾기
		$icon =  $target.closest('.comment_reply_container').find('path').first();
		
		
		console.log("여기왔음");
		console.log($(event.target).closest('.comment_reply_container ').find('span').data("comment-length"));
		if ( $(event.target).closest('.comment_reply_container ').find('span').hasClass("comment_first") ){
			console.log("띠용 ? ");
			console.log($(event.target).closest('.coment_reply_wrapper').parent().find('.comment_write_wrapper'));
			$(event.target).closest('.comment_reply_wrapper').parent().find('.comment_write_wrapper').addClass('active');
		}
		
		
		// ↓ 댓글 보이기 이벤트임
		if(! $showViewTarget.hasClass('active')){
			$commentCountText.text('숨기기');
			$icon.attr('d','M9.5 6.5v-1h-7v1h7z');
			//$showWriteTarget.addClass('active');
			$showViewTarget.addClass('active');
			//showCommentWrite(event);
		// ↓ 댓글 숨기기 이벤트임
		}else{
			console.log('여기옴 ? ');
			$length = $commentCountText.attr("data-comment-length");
			console.log($length);
			$length != 0 ? $commentCountText.text($length+' 개의 댓글' ) : $commentCountText.text('답글달기');
			$icon.attr('d','M5.5 2.5h1v3h3v1h-3v3h-1v-3h-3v-1h3v-3z');
			//$showWriteTarget.removeClass('active');
			$showViewTarget.removeClass('active');
		}
		

		
		//$showWriteTarget.toggleClass('active');
		
		//$viewCommentTarget.get(0).className  += " "+"active";
		//$viewCommentTarget.get(1).className  += " "+"active";
		 
		
	})
	
}

// 답글의 답글 입력창 보이기
function writeReplyInReply(){
	$('.comment_read_wrapper').on('click','.commnet_reply_write_content',function(event){
		console.log($(event.target));
		console.log($(event.target).closest('.comment_reply_view_wrapper').find('.comment_write_wrapper'));
		$target = $(event.target).closest('.comment_reply_view_wrapper').find('.comment_write_wrapper');
		console.log($target);
		//(event.target).closest('.comment_read_container').find('.username > a').text();
		$target.toggleClass('active');
		
		
	})
}