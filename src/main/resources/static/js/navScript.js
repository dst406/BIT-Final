
$(function(){
	selectNavBar();
	selectBoardGroup();
	groupItemActive();
	getModalFormEditPage();
	getModalFormAddPage();
//	getModalFormEditPage();
//	getModalFormEditPage("insertPage-popup-link",".itemCloseButton");
	
})




//function getModalFormEditPage(){
//	$('.menu-body').bind('click','.editBoardGroup-popup-link',function(event){
//		console.log('1  ');
//		event.preventDefault();
//		var title = $(event.target).closest('.title-box').find('.edit-able').text();
//		$('.formInputWrapper .inputInnerMedium').val(title);
//		console.log(title);
//		$('.editBoardGroup-popup-link').magnificPopup({
//			type:'inline',
//			midClick:true,
//			showCloseBtn:false
//		});
//		console.log('3  ');
//		
//		$(".boardGroupPanelHeaderClose, .actionsSecondary").on('click',function(){
//			$.magnificPopup.close();
//		})
//	})
//	
//}	
//	

function editBoardGroupTitle(){
	$('.buttonMediumBlueBase').on('click',function(event){
		const boardGroupName = $('.originalTitle').val();
		const changeName = $('.changeTitle').val();
		
		if(changeTitle.length == 0){
			return;
		}
		
		$.ajax({
			url:"/updateBoardGroupName",
			data: {
				boardGroupName : boardGroupName,
				changeName : changeName
			}
		}).done(function(data){
			
		})
		
		
	})
}


function getModalFormEditPage(){

	$('.editBoardGroup-popup-link').on('click',function(event){
		var title = $(event.target).closest('.title-box').find('.edit-able').text();
		$('.formInputWrapper .inputInnerMedium').get(0).value = title;
		$('.inputInnerMedium').get(1).value="";
	})
		
	getModalForm(".editBoardGroup-popup-link",".boardGroupPanelHeaderClose, .actionsSecondary");
	
}	
	
function getModalForm(openTarget, closeTarget){
	$(openTarget).magnificPopup({
		type:'inline',
		midClick:true,
		showCloseBtn:false
	});
	
	$(closeTarget).on('click',function(){
		$.magnificPopup.close();
	})
}

function getModalFormAddPage(){
	
	var lectureCode ;
	
	
	$('.insertPage-popup-link').on('click',function(event){
		$('.itemCardBodyContent').val('');
		lectureCode = $(event.target).closest('.main-icon-menu-pane').find('.hidden-lectureCode').val();
	})
	getModalForm(".insertPage-popup-link",".itemCloseButton");
	
	
	
	//console.log(order.closest('.main-icon-menu-pane').find('.metismenu'));
	
	$(".itemActivityToolbar .itemSaveButton").on('click',function(){
		
		
		
		$.ajax({
			url:"/insertBoardGroup",
			type:"POST",
			data: { 
				content : $('.itemCardBodyContent').val(),
				lectureCode: lectureCode
			},
			success:function(data){
				alert('야쓰');
				console.log(data);
				$.magnificPopup.close();
				$('.menu-body').html(data);
				var order = $('.hidden-lectureCode[value='+lectureCode+']');
				order.closest('.main-icon-menu-pane').find('.metismenu').addClass('active');
				//$('.main-icon-menu-pane:first-child .metismenu').addClass('active');
				
			}
			
		})
	})
	//$('.insertPage-popup-link').on('click',function(event){})
	//getModalFormEditPage("insertPage-popup-link",".itemCloseButton");
	
}


//
//function getModalFormEditPage(){
//	$('.menu-body').bind('click','.editBoardGroup-popup-link',function(event){
//		console.log('1  ');ㅈ
//		event.preventDefault();
//		var title = $(event.target).closest('.title-box').find('.edit-able').text();
//		$('.formInputWrapper .inputInnerMedium').val(title);
//		console.log(title);
//		$('.editBoardGroup-popup-link').magnificPopup({
//			type:'inline',
//			midClick:true,
//			showCloseBtn:false
//		});
//		console.log('3  ');
//		
//		$(".boardGroupPanelHeaderClose, .actionsSecondary").on('click',function(){
//			$.magnificPopup.close();
//		})
//	})
//	
//}	
	


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
	



















	
	


