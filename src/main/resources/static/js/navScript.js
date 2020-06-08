
$(function(){
	selectNavBar();
	selectBoardGroup();
	groupItemActive();
	getModalFormEditPage("editBoardGroup-popup-link",".boardGroupPanelHeaderClose, .actionsSecondary");
	getModalFormEditPage("insertPage-popup-link",".itemCloseButton");
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
	$('.menu-title').on('click',function(event){
		//moveActive('.menu-body','ul',target(event));
		
		var target = $(event.target);
		target.closest('.menu-body').find('ul')
		.removeClass('active');
		target.closest('.main-icon-menu-pane').find('ul').addClass('active');
		
		var hasActive = $(this).closest('a');
		if(hasActive.hasClass('active')){
			
			hasActive.closest('a').removeClass('active');
			return;
		}
		
	})
}

function navItemActive(){
	$('.main-icon-menu-pane .nav-link').on('click',function(event){
		moveActive('li','a',$(event.target));
	})
}

function groupItemActive(){
	$('.nav-item .nav-link').on('click',function(event){
		$target = $(event.target).closest('.li'); 
		var hasActive = $target.find('ul');
		
		console.log($target);
		if($target.hasClass('active')){
			$target.removeClass('active');
			hasActive.removeClass('active');
			return;
		}
		$target.addClass('active');
		hasActive.addClass('active');
		
	})
}


function moveActive(removeTarget, addTarget,target){
	target.closest(removeTarget).find('.active').removeClass('active');
	target.closest(addTarget).addClass('active');
	
}

/*
 function getModalFormEditPage(target){
	$('.'+target).magnificPopup({
		type:'inline',
		midClick:true,
		showCloseBtn:false
	});
	
	$('.boardGroupPanelHeaderClose, .actionsSecondary ').on('click',function(){
		$.magnificPopup.close();
	})
}	
*/
	



















	
	


