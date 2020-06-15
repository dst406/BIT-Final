$(function(){
	

	
	clickMorePostList();
	initPostDetail();
	searchPosts();
	searchDateText();
	searchDatePicker();
	searchDateLatelyPost();
	viewDataPicker();
	pagingNum();
	limitPaging(0);
	selectPaging();
//	console.log( $('.postListWrapper li a:contains('+$.trim( $('textarea#postTitle').val() )+')').attr('data-number') );
//	$('.postListWrapper li a:contains('+$.trim( $('textarea#postTitle').val() )+')').addClass('active');
	
})


function selectPaging(){
	$('.page-item > a').on('click',function(event){
		console.log($(event.target).attr('data-dt-idx'));
		limitPaging($(event.target).attr('data-dt-idx'));
	})
}

function pagingNum(){
	var paging = parseInt( $('.article-post-list').length / 10 )+1;
	
	$('.pagination').html(
			'<li class="paginate_button page-item previous disabled" id="datatable_previous">'+
			'<a href="javascript:void(0)" aria-controls="datatable" data-dt-idx="0" tabindex="0" class="page-link">이전</a></li>'
			)
	
	
	for(var i = 0; i<paging; i++){
		$('.pagination').append(	
		'<li class="paginate_button page-item ">'+
				'<a href="javascript:void(0)" aria-controls="datatable" data-dt-idx="'+i+'" tabindex="0" class="page-link">'+(i+1)+'</a></li>'
				)
		}
			
	$('.pagination').append(			
			'<li class="paginate_button page-item next disabled" id="datatable_next">'+
			'<a href="javascript:void(0)" aria-controls="datatable" data-dt-idx="7" tabindex="0" class="page-link">다음</a></li>'	
	)
}

function limitPaging(pagingNum = 0){
	$('.page-item').siblings().removeClass('active');
	$('.page-link[data-dt-idx='+(pagingNum)+']').closest('.page-item').addClass('active');
	
	$('.article-post-list').hide();
	var start = parseInt(pagingNum+"0");
	for(var i = start ; i < start+9 ; i++ ){
		$('.article-post-list').get(i).style.display = "block";
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
			 searchDate($startDate, $endDate);
			 
		});
}

function searchDateLatelyPost(){
	$('.menu_item a').on('click',function(event){
		$startDate = $(this).attr('date');
		
		if($startDate == null){
			console.log($startDate);
			searchDate(null, null);
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
		searchDate(resultDate, null);
		
	})
}

function searchDate($startDate, $endDate){
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
		$('strong, div, a').unmark();
		$searchText = $('.article-post-list strong:contains('+$searchVal+') , .post-list-info:contains('+$searchVal+'),'
				+' .post-list-contents-bottom a:contains('+$searchVal+')') ;
		
		searchTarget( $searchText, $searchVal);
	})
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



function initPostDetail(){
	const postListTarget = $('.postListWrapper li a:contains('+$.trim( $('textarea#postTitle').val() )+')');
	$('#thisPostNumber').text(postListTarget.attr('data-number'));
	postListTarget.addClass('active');
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

function searchDatePicker(){
	console.log('읽긴읽음');

	$('#dataTable_dateFilter .form-control').on({
		'click':function(event){
			$(".box_opt_menu").addClass('active');
			$(".box_opt_menu").prop('active');
			$('.inner_search').prop('active');
		},'keydown':function(event){
			$(".box_opt_menu").removeClass('active');
		}
	})
//	
//	$('#dataTable_dateFilter .form-control').on('click',function(event){
//		console.log('클릭이벤트');
//		if(! $('.form-control').hasClass('active') ){
//			$('.form-control').addClass('active');
//			$(".box_opt_menu").addClass('active');
//		}
//	})
//	
//	$("body").click(function(e) {
//		console.log('aa');
//		if(  $('.form-control').hasClass('active') ){
//			$('.form-control').removeClass('active');
//			$(".box_opt_menu").removeClass('active');
//		}
//	})
	

	
	
//	,'keydown':function(event){
//			$(".box_opt_menu").removeClass('active');
//		}
//	})
//	
//	$('.box_opt_menu').on('active',function(){
//		$(".box_opt_menu").removeClass('active');
//	})
}
