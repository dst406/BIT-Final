
$(function(){
	selectNavBar();
	selectBoardGroup();
	groupItemActive();
	getModalFormAddBoardGroup();
	getModalFormAddBoard();
	getModalFormEditPage();
	editAbleBoard();
	editBoardGroupTitle();
	
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



function getModalFormEditPage(){

	$('.editBoardGroup-popup-link').on('click',function(event){
		var title = $(event.target).closest('.nav-item').find('.edit-able').text();
		$('.formInputWrapper .inputInnerMedium').get(0).value = title;
		$('.inputInnerMedium').get(1).value="";
		
//		$('#originalTitle').val(title);
//		$('#changeTitle').val("");
		
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


function getModalFormAddBoardGroup(){
	

	$('.insert-board-group').on('click',function(event){
		$('.itemCardBodyContent').val('');
		lectureCode = $(event.target).closest('.main-icon-menu-pane').find('.hidden-lectureCode').val();
	})
	
		getModalForm(".insert-board-group",".itemCloseButton");
	
	
	$(".insertBoardGroupContainer .itemSaveButton").on('click',function(){
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
				$('.hidden-lectureCode[value='+lectureCode+']').
				closest('.main-icon-menu-pane').find('.metismenu').addClass('active');
				//$('.main-icon-menu-pane:first-child .metismenu').addClass('active');
				
			}
			
		})
	})
	
}


function getModalFormAddBoard(){
	$('.insert-board').on('click',function(event){
		$('.itemCardBodyContent').val('');
		boardGroupNo = $(event.target).closest('.nav-item').find('.board-group').attr("data");
		console.log(boardGroupNo);
	})
	getModalForm(".insert-board",".itemCloseButton");
	
	
	
	//console.log(order.closest('.main-icon-menu-pane').find('.metismenu'));
	
	$(".insertBoardContainer .itemSaveButton").on('click',function(){
		
		content : $('.itemCardBodyContent').val();
		
		$.ajax({
			url:"/insertBoard",
			type:"POST",
			data: { 
				content : $('.itemCardBodyContent').val(),
				boardGroupNo: boardGroupNo
			},
			success:function(data){
				alert('야쓰');
				$.magnificPopup.close();
				$('.menu-body').html(data);
				
				$boardGroup = $('.board-group[data='+boardGroupNo+']');
				
				$boardGroup.addClass('active');
				$boardGroup.closest('.main-icon-menu-pane').find('.metismenu ').addClass('active');
				$boardGroup.closest('li').find('ul').addClass('active');
				
				
				//$('.main-icon-menu-pane:first-child .metismenu').addClass('active');
				
			}
			
		})
	})
	//$('.insertPage-popup-link').on('click',function(event){})
	//getModalFormEditPage("insertPage-popup-link",".itemCloseButton");
	
}

function editAbleBoard(){
	$(".nav-item").hover(function(event){
			$(event.target).closest('li').find('.group_icon').css("display","block");
		},
		function(){
			$(event.target).closest('li').find('.group_icon').css("display","none");
		}
	)
	
	
}

function editBoardGroupTitle(){
   $('.buttonMediumBlueBase').on('click',function(event){
      const boardGroupName = $('#originalTitle').val();
      const changeName = $('#changeTitle').val();
      
      const boardGroupNo = $('.metismenu .nav-link:contains('+boardGroupName+')').attr("data");
      
      if(changeTitle.length == 0){
    	  $('#changeTitle').closest('.formGroupElement').append(
    			 '<p class="error">바꿀 이름을 정해주세요</p>'
    	  );
         return;
      }
      
      $.ajax({
         url:"/updateBoardGroupName",
         type:"POST",
         data: {
            boardGroupName : boardGroupName,
            changeName : changeName,
            boardGroupNo : boardGroupNo
         }
      }).done(function(data){
    	  $('.metismenu').find($('.nav-link[data='+boardGroupNo+']')).text(changeName);
    		$.magnificPopup.close();
      })
      
      
   })
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
	






// 강의이름 클릭했을 때 
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


function target(event){
	return $(event.target);
}

//그룹 클릭 시 게시판 목록 뜨기
function groupItemActive(){
	$('.board-group').on('click',function(event){
		var target = $(event.target); 
		var hasActive = target.closest('li').find('ul');
		
		if(target.hasClass('active') ){
			target.removeClass('active');
			hasActive.removeClass('active');
			return;
		}
		
		if(hasActive.find('li').length != 0){
			console.log(hasActive.find('li').length);
			target.addClass('active');
			hasActive.addClass('active');
		}
		
		
	})
}




//function navItemActive(){
//	$('.main-icon-menu-pane .nav-link').on('click',function(event){
//		moveActive('li','a',$(event.target));
//	})
//}




//좌측 내비게이션바 아이콘 이동
function selectNavBar(){
	$('.leftbar-tab-icon').on('click',function(event){
		moveActive('.nav','a',target(event));
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
	



















	
	


