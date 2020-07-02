$(function(){
	getBoardLeftNavBar();
	topbarDropdownToggle();
	moveJobLeftNavBar();
})

function getBoardLeftNavBar(){
	$('body').on('click','#board',function(event){
		$.ajax({
			url: "/board/getNavbar"
		}).done(function(data){
			$('.menu-body').html(data);
			leftNavBarMoveActive(event);
		})
	})
}


function moveJobLeftNavBar(){
	$('body').on('click','#manager , #teacher , #student',function(event){
		moveJobLeftNavBarAjax($(this).attr('id'));
		leftNavBarMoveActive(event);
	})
}

function leftNavBarMoveActive(event){
	$('.nav-link').removeClass('active');
	$(event.target).closest('.nav-link').addClass('active');
	$('.main-icon-menu-pane:first-child .metismenu').addClass('active');
}

function moveJobLeftNavBarAjax(target){
	$.ajax({
		url : "/"+target+"/getNavbar",
	}).done(function(data){
		$('.menu-body').html(data);
	})
}


function topbarDropdownToggle(){
	$('.topbar').on('click','.dropdown-toggle',function(event){
		$target = $(event.target).closest('li').find('.dropdown-menu');
		
		if($target.hasClass('active')){
			$target.removeClass('active');
			return;
		}
		$target.addClass('active');
	})
}


	
