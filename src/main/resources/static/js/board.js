$(function(){
	initPostDetail();
	clickMorePostList();
	deletePostConfirm();
	updateBoardInfo();
//	console.log( $('.postListWrapper li a:contains('+$.trim( $('textarea#postTitle').val() )+')').attr('data-number') );
//	$('.postListWrapper li a:contains('+$.trim( $('textarea#postTitle').val() )+')').addClass('active');
	
})

function updateBoardInfo(){
	$(".container").on('focusout','.board_contents_text, .board_title_text',function(){
		var boardNo = $('#boardName').attr('data-board-no') ;
		var boardName = $('#boardName').val();
		var boardIntro = $('textarea#boardIntro').val() ; 
		$.ajax({
			url: "/updateBoard/"+boardNo+"/"+boardName+"/"+boardIntro
		})
		
		
	})
}




// 하이라이트 해결하기 
function initPostDetail(){
	$('.postListWrapper').find('li a').each(function(index, item){
		if( $('#postNo').val() == $(this).attr('data-post-no') ){
			$('#thisPostNumber').text($(this).attr('data-number'));
			$(this).addClass('active');
		}
	})
	
	$length = $('.postListWrapper').find('li').length;
	//console.log($length);
	
}

function clickMorePostList(){
	$('.postListViewGuide').on('click',function(){
		if( $('.postListWrapper').hasClass('active')){
			 $('.postListWrapper').toggleClass('active');
			 $('.morePostList').text('목록보기');
			 $('.postListViewGuide path').attr('d','M7 10l5 5 5-5z');
			 return;
		}
		
		$('.morePostList').text('숨기기');
		$('.postListViewGuide path').attr('d','M7 14l5-5 5 5z');
		$('.postListWrapper').toggleClass('active');
	})
}


function deletePostConfirm(){
	$('.deletePost').on('click',function(event){
		console.log('여기왔음 ? ');
		Swal.fire({
			  title: '게시글 삭제',
			  text: "정말로 삭제하시겠습니까 ?",
			  showCancelButton: true,
			  confirmButtonColor: ' rgb(118, 128, 255)',
			  confirmButtonText: '확인',
			  cancelButtonColor: 'rgb(233, 236, 239)',
			  cancelButtonText: '취소',
		      width: '350px'
			}).then((result) => {
			  if (result.value) {
				  
			    location.href = "/deletePost/"+$(event.target).data("post-no")+"/"+$('#boardNo').data("board-no");
			  }
			})
	})
}