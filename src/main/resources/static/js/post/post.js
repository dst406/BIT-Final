$(function(){
	
	clickMorePostList();
	initPostDetail();
	deletePostConfirm();
	
})

function getPostInfoPreviewPaging(visibleFirstPageList){
	
	// Limit 포스트개수 = 10개
	var visibleLastPageList = visibleFirstPageList + 10 ;
	
	// 첫페이지를 나타내는 넘버
	var firstPostRowNum = $('.postListWrapper > li').first().children().attr('data-number');
	
	// 마지막페이지를 나타내는 넘버
	var LastPostRowNum = $('.postListWrapper > li').last().children().attr('data-number');
	
	// 페이징
	$('.postListWrapper li').hide().slice(visibleFirstPageList,visibleLastPageList).show();
		
	//첫페이지면  '<' 버튼 disalbed
	 firstPostRowNum == $('.postListWrapper').find('li:visible').first().children().attr('data-number') ? 
			 $('.postListPrevBtn').attr('disabled',true) : $('.postListPrevBtn').attr('disabled',false);
			 
	// 마지막 페이지면 '>' 버튼 disabled
	 LastPostRowNum == $('.postListWrapper > li:visible').last().children().attr('data-number') ? 
			 $('.postListNextBtn').attr('disabled',true) : $('.postListNextBtn').attr('disabled',false);
	
	//on click
	$('.postListPrevBtn').one('click',function(){
		visibleFirstPageList -= 10;
		getPostInfoPreviewPaging ( visibleFirstPageList );
	})
	
	$('.postListNextBtn').one('click',function(){
		visibleFirstPageList += 10;
		getPostInfoPreviewPaging ( visibleFirstPageList );
	})
	
	
	
}


//하이라이트 해결하기 
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
		console.log('click more '+ parseInt( $('.postListWrapper > li:visible').first().children().attr('data-number') ));
		getPostInfoPreviewPaging( parseInt( $('.postListWrapper > li:visible').first().children().attr('data-number') ) -1 );
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


