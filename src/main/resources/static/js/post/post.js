$(function(){
	
	clickMorePostList();
	initPostDetail();
	deletePostConfirm();
	activePaging();
})

function getPostInfoPreviewPaging(visibleFirstPageList){
	
	// 첫페이지를 나타내는 넘버
	var firstPostRowNum = $('.postListWrapper > li').first().find('a').attr('data-number');
	
	
	// 마지막페이지를 나타내는 넘버
	var LastPostRowNum = $('.postListWrapper > li').last().find('a').attr('data-number');
	 
	// Limit 포스트개수 = 10개		 
	var visibleLastPageList = visibleFirstPageList + 10  ;
	$('#thisPostNumber').text(parseInt(visibleFirstPageList/10)+1);
	
	
	//첫페이지면  '<' 버튼 disalbed
	 firstPostRowNum == $('.postListWrapper li:nth-child('+visibleFirstPageList+1+')').find('a').attr('data-number') ? 
			 $('.postListPrevBtn').attr('disabled',true) : $('.postListPrevBtn').attr('disabled',false);
	
	// 마지막 페이지면 '>' 버튼 disabled
	LastPostRowNum - $('.postListWrapper li:nth-child('+ (visibleFirstPageList+1) +')').find('a').attr('data-number') < 10 ? 
					 $('.postListNextBtn').attr('disabled',true) : $('.postListNextBtn').attr('disabled',false);
			 
					 
	// 페이징
	$('.postListWrapper li').hide().slice(visibleFirstPageList,visibleLastPageList).show();
}

function activePaging(){
	
	//목록보기에 현재 페이지에 대한 값을 넣어주었음.
	var viewPostListDataNum = parseInt( $('.morePostList').attr('data-number') ) ;
	
	//이전 버튼
	$('.postListPrevBtn').on('click',function(event){
		// 목록보기 값 -1   =  -10개 페이지
		viewPostListDataNum -= 1;
		// 목록보기 값 -1 갱신
		$('.morePostList').attr('data-number',  viewPostListDataNum );
		//페이징 다시 호출
		getPostInfoPreviewPaging (viewPostListDataNum*10 );
		
	})
	
	// 다음버튼
	$('.postListNextBtn').on('click',function(event){
		// 목록보기 값 +1 = +10개 페이지
		viewPostListDataNum += 1;
		// 목록보기 값 -1 갱신
		$('.morePostList').attr('data-number', viewPostListDataNum  );
		//페이징 다시 호출
		getPostInfoPreviewPaging ( viewPostListDataNum*10 );
		
	})
	
	
}



//하이라이트 해결하기 
function initPostDetail(){
	$('.postListWrapper').find('li a').each(function(index, item){
		//현재 postNo이랑 목록에 있는 postNo이 같으면
		if( $('#postNo').val() == $(this).attr('data-post-no') ){
			// 목록에 있는 postNo
			var thisPostNum =  $(this).attr('data-number');
			// 목록에 있는 postList를 현재 페이지를 기준으로 
			var pageNumber =  parseInt( thisPostNum/10);
			// 10의 배수는 페이징 -1
			( thisPostNum % 10 == 0 ) && ( pageNumber != 0) ? pageNumber -= 1 : pageNumber;
			// 목록보기에 현재 페이지에 대한 값을 넣는다
			$('.morePostList').attr('data-number',pageNumber);
			// 페이징 처리
			getPostInfoPreviewPaging( ( pageNumber*10)  );
			// 현재 페이징 상황 갱신
			$('#thisPostNumber').text(pageNumber+1);
			// 목록보기에 있는 현재 포스트 하이라이트
			$(this).addClass('active');
			// 목록보기에 있는 현재 포스트 번호 하이라이트
			$(this).siblings().addClass('active');
		}
	})
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
		getPostInfoPreviewPaging( parseInt( $('.morePostList').attr('data-number') )*10 );
	})
}


function deletePostConfirm(){
	$('.deletePost').on('click',function(event){
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


