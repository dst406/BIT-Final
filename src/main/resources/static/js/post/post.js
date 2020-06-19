$(function(){
	getMyPostList();
	searchPosts();
	searchPostsChange();
	searchDateText();
	searchDatePicker();
	searchDateLatelyPost();
	viewDataPicker();
	defaultPostPagingNumbers();
	limitPaging(0);
	selectPaging();
	nextPage();
	previousPage();
})




function getMyPostList(){
	$('.getPost').on('click',function(evnet){
		$target = $(this);
		$targetId = $target.attr('id');
		var url = "/getSearchMyPostList/"+$('#boardName').attr('data-board-no');
		
		if( $targetId == 'getAllPost' ){
			/*url = '/board/postList/'+$('#boardName').attr('post-no');
			$target.attr('id','getMyPost');
			$target.text('내 글보기');*/
			location.reload();
		}
		
		
		
		$.ajax({
			url:url
		}).done(function(data){
			$('.postList').html(data);
			$target.attr('id','getAllPost');
			$target.text('전체 글 보기');
			visiblePostPagingNumbers();
		})
	})
}

function selectPaging(){
	$('.pagination_center').on('click','.page-item > a',function(event){
		limitPaging($(event.target).attr('data-dt-idx'));
	})
}

function defaultPostPagingNumbers(){
	pagingNumbers( $('.article-post-list'));

}

function visiblePostPagingNumbers(){
	pagingNumbers(  $('.article-post-list:visible') );
}


function pagingNumbers(target ){
				// 버튼 갯수 구하기
	var paging = parseInt( target.length / 10 );
				// 첫 버튼 숫자 구하기
	var startCount = parseInt($('.page-item:nth-child(2) a').attr('data-dt-idx'));
				// 페이징 갯수 5개로 제한
	var endCount = ( paging / 5 ) > 1 ? 
						parseInt( $('.page-item.active a').last().data('dt-idx') ) + 4 : 
						paging;
	
	viewPagingNumber(startCount, endCount, paging);
	
	
}


function previousPage(){
	$('.pagination_center').on('click','.previous',function(){
		var preData = parseInt ($('.previous').children().attr('data-dt-idx'));
		if( preData != 0 ){
			viewPagingNumber( preData-5, preData-1 ,0 );
			limitPaging(preData-1);
		}
			
		
	})
	
}

function nextPage(){
	$('.pagination_center').on('click','.next',function(){
		
		//들어왔을때 막으면 댐 !!
		var nextData = parseInt ($('.next').children().attr('data-dt-idx'));
		var maxCount = parseInt ( $('.page-link').last().attr('data-dt-max') ) ;
		
		if( isNaN(maxCount) ) {return ;}
		
		if ( ( nextData < parseInt( $('.article-post-list').length / 10 ) ) && ( ( maxCount - nextData) > 4  ) ){
			viewPagingNumber( (nextData+1) , (nextData+5) , 0 );
		}else{
			if( $('.page-link').length < 5  ){
				limitPaging(maxCount);
				return;
			}
			viewPagingNumber( (nextData+1), maxCount, maxCount );
		}
	})
}


function viewPagingNumber(startCount, endCount, maxCount){
	var isFirst = startCount == 0 ? "disabled" : "";
	maxCount = maxCount == 0 ? parseInt( $('#datatable_next a').attr('data-dt-max') ) : maxCount;
	$('.pagination').html(
			'<li class="paginate_button page-item previous " '+isFirst+' id="datatable_previous">'+
			'<a href="javascript:void(0)"  data-dt-idx="'+startCount+'" class="page-link">이전</a></li>'
			)
	endCount = maxCount-startCount < 4 ? ( endCount = maxCount-endCount != 0 ? endCount : startCount+ 1 )  : endCount ;
	for(var i = startCount ; i <= endCount; i++){
		$('.pagination').append(	
		'<li class="paginate_button page-item ">'+
				'<a href="javascript:void(0)" a data-dt-idx="'+i+'" class="page-link">'+(i+1)+'</a></li>'
				)
		}
	$('.page-item:nth-child(2)').addClass('active');
	
	var isLast = maxCount-startCount < 4 ? "isLast" : "" ;		
	var isOne = endCount == 0 ? "disabled" : "" ;
	
	$('.pagination').append(			
			'<li class="paginate_button page-item next '+isLast+'  '+isOne+'" id="datatable_next">'+
			'<a href="javascript:void(0)"  data-dt-idx="'+endCount+'" data-dt-max="'+maxCount+'" class="page-link">다음</a></li>'	
	)
	
}



function limitPaging(pagingNum){
	$('.page-item').siblings().removeClass('active');
	$('.page-link[data-dt-idx='+(pagingNum)+']').closest('.page-item').addClass('active');
	
	preNextBtnControll($('.previous'));
	preNextBtnControll($('.next'));
	

	
	function preNextBtnControll(btn){
		btn.removeClass("disabled");
		btn.removeClass("active");
		
		console.log(  btn.children().attr('data-dt-idx')  == 0 && pagingNum == 0 ? true : false );
		console.log(  (  btn.children().attr('data-dt-idx') == $('.isLast').children().attr('data-dt-max') )   );
		
				// 이전  버튼
		if ( btn.children().attr('data-dt-idx')  == 0 && pagingNum == 0 ? true : false ||
					// 마지막 버튼을 눌렀는지
				(  ( pagingNum == btn.children().attr('data-dt-idx') )
							// 다음버튼을 눌렀는지.
						&& ( btn.children().attr('data-dt-idx') == $('.isLast').children().attr('data-dt-max') )) )  {
			btn.addClass('disabled');
		}  
	}
	
	//$('#datatable_next').children().attr('data-dt-max') ) 
	
	$('.article-post-list').hide();
	var startLength = parseInt(pagingNum+"0");
	
	var endLength = parseInt(startLength+9);
	
	if( parseInt($('.article-post-list').length / 10 )==  parseInt(pagingNum) ){
		endLength = startLength + ( $('.article-post-list').length % 10 );
	}
	
	for(var i = startLength ; i <= endLength ; i++ ){
		$('.article-post-list:nth-child('+(i+1)+')').attr("style","display:block");
		//$('.article-post-list').get(i).style.display = "block";
	}
	
}




function viewDataPicker(){
		$('#search-start-date,#search-end-date').datepicker({
			dateFormat:'yy-mm-dd',
			dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
		}).bind('change',function(event){
			 $startDate=  dataIsNull($('#search-start-date').datepicker("getDate")); 
			 $endDate= dataIsNull( $('#search-end-date').datepicker("getDate") );
			 
			 if(this.id == 'search-start-date'){
				 rimitDate('#search-start-date', '#search-end-date', 'minDate' );
			 }else if(this.id == 'search-end-date'){
				 rimitDate('#search-end-date', '#search-start-date', 'maxDate' );
			 }
			 
			 // search ajax 요청
			 searchDate($startDate, $endDate, ($startDate != null ? $startDate : "모두" )+" ~ "+ ( $endDate != null ? $endDate : "오늘" ) );
			 visiblePostPagingNumbers();
			 
		});
}

function searchDateLatelyPost(){
	$('.menu_item a').on('click',function(event){
		$startDate = $(this).attr('date');
		var dateTarget = $(this).text();
		if($startDate == null){
			searchDate(null, null,dateTarget);
			$('.box_opt_menu').removeClass('active');
			return;
		}
		var nowDate = new Date();
		var calcDate = nowDate.getTime() - ($startDate * 24 * 60 * 60 * 1000);
		nowDate.setTime(calcDate);
		
		var year = nowDate.getFullYear();
		var month = nowDate.getMonth()+1;
		var day = nowDate.getDate();
		
		if(month<10) { 
			month = "0" + month;
		}
		if(day<10){
			day = "0" + day;
		}
		var resultDate = year + "-" + month + "-" + day;
	
		
		searchDate(resultDate, null,dateTarget);
		
		$('.box_opt_menu').removeClass('active');
	})
}

function searchDate($startDate, $endDate, text){
	 $.ajax({
		 url:"/getSearchDatePostList",
		 type:"POST",
		 data:{
			 boardNo : $('#boardName').attr('post-no'),
			 startDate : $startDate,
			 endDate : $endDate
		 }
	 }).done(function(data){
		$('.postList').html(data);
		$('.searchDate').val(text);
		visiblePostPagingNumbers();
	 })
}


function isNull(obj) {
	return (typeof obj != "undefined" && obj != null && obj != "") ? false : true;
}

function dataIsNull(date){
	 if(! isNull(date)){
		 date =  $.datepicker.formatDate('yy-mm-dd',
			 new Date(date.getFullYear(), date.getMonth(),date.getDate()));
	 }
	 return date;
}

function rimitDate(checkDate, rimitDate, minOrMax ){
		 var datePicker = $(checkDate).datepicker("getDate");
		 var date = new Date(datePicker.getFullYear(), datePicker.getMonth(),datePicker.getDate());
		 $(rimitDate).datepicker("option", minOrMax ,date);
}


function searchPosts(){
	$('.searchPost').on('keyup',function(event){
		$searchVal = $(this).val();
		$searchText = searchPostsSelect($searchVal) ;
		searchTarget( $searchText, $searchVal);
		visiblePostPagingNumbers();
	})
}

function searchPostsChange(){
	$('.searchPost').on('search',function(event){
		$searchVal = $(this).val();
		$searchText = searchPostsSelect($searchVal) ;
		searchTarget( $searchText, $searchVal) ;
		visiblePostPagingNumbers();
		//defaultPostPagingNumbers();
	})
}

function searchPostsSelect($searchVal){
	$('strong, div, a').unmark();
	$searchText = $('.article-post-list strong:contains('+$searchVal+') , .post-list-info:contains('+$searchVal+'),'
			+' .post-list-contents-bottom a:contains('+$searchVal+')') ;
	return $searchText ;
	
}



function searchDateText(){
	$('#dataTable_dateFilter .form-control').on('keyup',function(event){
		$searchVal = $(this).val();
		$('.post-list-contents-bottom .postDate').unmark();
		$searchText = $('.post-list-contents-bottom .postDate:contains('+$searchVal+')');
		searchTarget($searchText, $searchVal);
		
	})
}

function searchTarget($searchText,$searchVal){
	$('.article-post-list').hide();
	$searchText.closest($('.article-post-list')).show();
	$searchText.mark($searchVal);
}

function searchDatePicker(){
	$('#dataTable_dateFilter .form-control').on({
		'click':function(event){
			$(".box_opt_menu").addClass('active');
		},'keydown':function(event){
			$(".box_opt_menu").removeClass('active');
		}
//		,'focusout':function(){
//			$(".box_opt_menu").removeClass('active');
//		}
	})
	
//	$('.date_picker').on({
//		'click':function(){
//			$(".box_opt_menu").addClass('active');
//		},'focusout':function(){
//			$(".box_opt_menu").removeClass('active');
//		}
//	})

	
	$('.closeDatePicker').on('click',function(){
		$(".box_opt_menu").removeClass('active');
	})
	
}
