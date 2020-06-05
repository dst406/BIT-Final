
$(function(){
	selectNavBar();
	selectBoardGroup();
})



function target(event){
	return $(event.target);
}

function selectNavBar(){
	$('.nav-link').on('click',function(event){
		moveActive('.nav','a',target(event));
		
	})
}


function selectBoardGroup(){
	$('.title-box').on('click',function(event){
		//moveActive('.menu-body','ul',target(event));
		
		var target = $(event.target);
		target.closest('.menu-body').find('ul').removeClass('active');
		target.closest('.main-icon-menu-pane').find('ul').addClass('active');
		
		
		console.log(target.closest('.menu-body').find('.active'));
		console.log(target.closest('.main-icon-menu-pane').find('ul'));
	})
}

function moveActive(removeTarget, addTarget,target){
	target.closest(removeTarget).find('.active').removeClass('active');
	target.closest(addTarget).addClass('active');
	
}


