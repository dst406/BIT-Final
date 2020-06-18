$(function(){
	getMyPostList();
	searchPosts();
	searchPostsChange();
	searchDateText();
	searchDatePicker();
	searchDateLatelyPost();
	viewDataPicker();
	defaultPagingNumbers();
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

function defaultPagingNumbers(){
	pagingNumbers( $('.article-post-list'));

}

function visiblePostPagingNumbers(){
	pagingNumbers(  $('.article-post-list:visible') );
}


function pagingNumbers(target ){
	var paging = parseInt( target.length / 10 );
	var startCount = parseInt($('.page-item:nth-child(2) a').attr('data-dt-idx'));
	var endCount = ( paging / 5 ) > 1 ? parseInt( $('.page-item.active a').last().data('dt-idx') ) + 4 : paging;
	
	viewPagingNumber(startCount, endCount);
	
	
}


function previousPage(){
	$('.pagination_center').on('click','.previous',function(){
		var preData = parseInt ($('.previous').children().attr('data-dt-idx'));
		if( preData != 0 ){
			viewPagingNumber( preData-5, preData-1 );
			limitPaging(preData-1);
		}
			
		
	})
	
}

function nextPage(){
	$('.pagination_center').on('click','.next',function(){
		var nextData = parseInt ($('.next').children().attr('data-dt-idx'));
		
		if ( nextData < parseInt( $('.article-post-list').length / 10  ) ){
			viewPagingNumber( nextData+1, nextData+5 );
		}
		
	})
	
}


function viewPagingNumber(startCount, endCount){
	var isFirst = startCount == 0 ? "disabled" : "";	
	$('.pagination').html(
			'<li class="paginate_button page-item previous " '+isFirst+' id="datatable_previous">'+
			'<a href="javascript:void(0)"  data-dt-idx="'+startCount+'" class="page-link">이전</a></li>'
			)
	
	
	for(var i = startCount ; i <= endCount; i++){
		$('.pagination').append(	
		'<li class="paginate_button page-item ">'+
				'<a href="javascript:void(0)" a data-dt-idx="'+i+'" class="page-link">'+(i+1)+'</a></li>'
				)
		}
	$('.page-item:nth-child(2)').addClass('active');
	
	var isLast = endCount == 0 ? "disabled" : "" ;		
	
	$('.pagination').append(			
			'<li class="paginate_button page-item next '+isLast+'" id="datatable_next">'+
			'<a href="javascript:void(0)"  data-dt-idx="'+endCount+'" class="page-link">다음</a></li>'	
	)
	
}



function limitPaging(pagingNum){
	$('.page-item').siblings().removeClass('active');
	$('.page-link[data-dt-idx='+(pagingNum)+']').closest('.page-item').addClass('active');
	
	preNextBtnControll($('.previous'));
	preNextBtnControll($('.next'));
	
	function preNextBtnControll(btn){
		btn.removeClass("disabled");
		if (   btn.children().attr('data-dt-idx') == pagingNum ) {
			btn.removeClass('active');
			btn.addClass('disabled');
		}  
	}
	
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
		//defaultPagingNumbers();
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
//			console.log('앗 나갔다');
//			$(".box_opt_menu").addClass('active');
//		},'focusout':function(){
//			$(".box_opt_menu").removeClass('active');
//		}
//	})

	
	$('.closeDatePicker').on('click',function(){
		$(".box_opt_menu").removeClass('active');
	})
	
}
