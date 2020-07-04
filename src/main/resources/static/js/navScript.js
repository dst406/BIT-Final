
$(function(){
	selectNavBar();
	selectBoardGroup();
	groupItemActive();
	getModalFormAddBoardGroup();
	getModalFormAddBoard();
	getModalFormEditPage();
	editAbleBoard();
	editBoardGroupTitle();
})





function getModalFormEditPage(){

	$('body').on('click','.editBoardGroup-popup-link',function(event){
		var target = $(event.target).closest('.nav-item').find('.edit-able');
		var title = target.text();
		var boardGroupNo = target.attr('data');
		$('.formInputWrapper .inputInnerMedium').get(0).value = title;
		$('.inputInnerMedium').get(1).value="";
		$('.deleteBoardGroup').attr("href","/board/deleteBoardGroup/"+boardGroupNo);
//		$('#originalTitle').val(title);
//		$('#changeTitle').val("");
		getModalForm(".editBoardGroup-popup-link",".boardGroupPanelHeaderClose, .actionsSecondary");
	})
	
	
}	
	
function getModalForm(openTarget, closeTarget){
	$(openTarget).magnificPopup({
		type:'inline',
		midClick:true,
		showCloseBtn:false
	}).magnificPopup('open');
	
	$(closeTarget).on('click',function(){
		$.magnificPopup.close();
	})
}


function getModalFormAddBoardGroup(){
	

	$('body').on('click','.insert-board-group',function(event){
		console.log('boardGroup 클릭 이벤트');
		$('.itemCardBodyContent').val('');
		lectureCode = $(event.target).closest('.main-icon-menu-pane').find('.hidden-lectureCode').val();
		getModalForm($(this),".itemCloseButton");
	})
	
	
	$("body").on('click','.insertBoardGroupContainer .itemSaveButton',function(){
		$.ajax({
			url:"/board/insertBoardGroup",
			type:"POST",
			data: { 
				content : $('.itemCardBodyContent').val(),
				lectureCode: lectureCode
			}
		}).done(function(data){
				$.magnificPopup.close();
				$('.menu-body').html(data);
				$('.hidden-lectureCode[value='+lectureCode+']').
				closest('.main-icon-menu-pane').find('.metismenu').addClass('active');
		})
	})
	
}


function getModalFormAddBoard(){
	$('body').on('click','.insert-board',function(event){
		console.log('board 클릭 이벤트');
		$('.itemCardBodyContent').val('');
		boardGroupNo = $(event.target).closest('.nav-item').find('.board-group').attr("data");
		getModalForm($(this),".itemCloseButton");
	})
	
	
	$("body").on('click','.insertBoardContainer .itemSaveButton',function(){
		
		content : $('.itemCardBodyContent').val();
		
		$.ajax({
			url:"/board/insertBoard",
			type:"POST",
			data: { 
				content : $('.itemCardBodyContent').val(),
				boardGroupNo: boardGroupNo
			}
				// 변수 var , 없이 : https://hue9010.github.io/%ED%94%84%EB%A1%A0%ED%8A%B8%EC%97%94%EB%93%9C/JavaScript-var/
				//    L Scope 체인
				// $변수 , 변수   : https://seras.tistory.com/45
				//    L Jqeury 변수, javascript변수
				
			}).done(function(data){
				$.magnificPopup.close();
				$('.menu-body').html(data);
				
				$boardGroup = $('.board-group[data='+boardGroupNo+']');
				
				$boardGroup.addClass('active');
				$boardGroup.closest('.main-icon-menu-pane').find('.metismenu ').addClass('active');
				$boardGroup.closest('li').find('ul').addClass('active');
			})
			
		})
}

function editAbleBoard(){
	
	$("body").on({
			mouseover: function(event){
				$(event.target).closest('li').find('.group_icon').css("display","block");
			},
			mouseout: function(event){
				$(event.target).closest('li').find('.group_icon').css("display","none");
			}
		},".nav-item")
		
	
}

function editBoardGroupTitle(){
   $('body').on('click','.buttonMediumBlueBase',function(event){
      const boardGroupName = $('#originalTitle').val();
      const changeName = $('#changeTitle').val();
      
      const boardGroupNo = $('.metismenu .nav-link:contains('+boardGroupName+')').attr("data");
      
      if(changeName.length == 0){
    	  $('#changeTitle').closest('.formGroupElement').append(
    			 '<p class="error">바꿀 이름을 정해주세요</p>'
    	  );
         return;
      }
      
      $.ajax({
         url:"/board/updateBoardGroupName",
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







// 강의이름 클릭했을 때 
function selectBoardGroup(){
	$('body').on('click','.menu-title',function(event){
		//moveActive('.menu-body','ul',target(event));
		
		var $target = $(event.target);
		$target.closest('.menu-body').find('ul').removeClass('active');
		$hasActive = $target.closest('.main-icon-menu-pane').find('.metismenu');
		if($hasActive.hasClass('active')){
			$hasActive.removeClass('active');
			return;
		}
		$hasActive.addClass('active');
	})
}


function target(event){
	return $(event.target);
}

//그룹 클릭 시 게시판 목록 뜨기
function groupItemActive(){
	$('body').on('click','.board-group',function(event){
		var target = $(event.target); 
		var hasActive = target.closest('li').find('ul');
		$icon = target.closest('li').find('.nav-link-more-group > i');
		
		
		if(target.hasClass('active') ){
			target.removeClass('active');
			hasActive.removeClass('active');
			$icon.attr('class','fas fa-chevron-right');
			return;
		}
		
		if(hasActive.find('li').length != 0){
			target.addClass('active');
			hasActive.addClass('active');
			$icon.attr('class','fas fa-chevron-down');
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
	$('body').on('click','.leftbar-tab-icon',function(event){
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
	



















	
	


