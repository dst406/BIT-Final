/**
 * 
 *  <input type="button" class="BOLD" value="B" onclick="document.execCommand('bold')" />
    <input type="button" class="ITALIC" value="Italic" onclick="document.execCommand('Italic')" />
    <input type="button" class="UNDERBAR" value="밑줄" onclick="document.execCommand('Underline')" />
    <input type="button" class="BAR" value="삭선" onclick="document.execCommand('StrikeThrough')" />
    <input type="button" class="aignLeft" value="왼쪽 정렬" onclick="document.execCommand('justifyleft')" />
    <input type="button" class="aignCenter" value="가운데 정렬" onclick="document.execCommand('justifycenter')" />
    <input type="button" class="aignRight" value="오른쪽 정렬" onclick="document.execCommand('justifyright')" />
    <input type="button" class="fontsize" value="h3" onclick="execH3Element()" />
    
        <div class="editorDIV" contenteditable="true"></div>
    
 */
$(function(){
	deleteFirstContents();
	qlHeadercursor();
	addPostSubmit();
	addTemporaryPostSubmit();
	deleteTemporaryPost();
	
})

function deleteTemporaryPost(){
	$('.removeTempWrapper').on('click',function(event){
		event.preventDefault();
		var $target = $(this).find('i');
		$.ajax({
			url:"/deleteTemporaryPost",
			data : {
				temporaryNo:$target.attr('temporaryno')
			}
		}).done(function(){
			$target.closest('a').remove();
		})
	})
}

//function editorScroll(){
//	 console.log( $('.editorDIV').height());
//	$('.editorDIV *').on('change',function(){
//		console.log('edit change');
//		if( $('.editorDIV').height() > 552 ){
//			console.log('min !!');	
//			$('.editorDIV').attr('style','overflow-y:scroll');
//		}else{
//			console.log('maX !!');	
//			$('.editorDIV').attr('style','overflow-y:hidden');
//		}
//	})
//	
//}


//게시글 등록
function addPostSubmit(){
	$('.saveButton').on('click',function(){
		addContentsAsTextarea();
		$('#postTitle').val( $('textarea#postTitleArea').val() );
		var previewText = $('.editorDIV *').text();
		if(previewText.length > 200){
			previewText = previewText.substr(0,200);
		}	
		$('#postPreview').val(previewText);
		if($('.editorDIV img').length > 0 ){
			$('#postThumbnail').val($('.editorDIV img').get(0).getAttribute('src'));
		}
		$('#postsForm').submit();
	})
}

//임시저장
function addTemporaryPostSubmit(){
	$('.temporarySaveButton').on('click',function(){
		addContentsAsTextarea();
		$('#postTitle').val( $('textarea#postTitleArea').val() );
		$.ajax({
			type:'POST',
			url:'/insertTemporaryPost',
			data:{
				boardNo : $('#boardNo').val(),
				temporaryTitle: $('#postTitle').val(),
				temporaryContents : $('#postContents').val()
			}
		}).done(function(data){
			$('.postForm_header_temporary').html(data);
		})
		
		
		
		//	$('#postTitle').attr('name','temporaryTitle');
		//	$('#postTitle').attr('id','temporaryTitle');
		//	$('#temporaryTitle').val( $('textarea#postTitleArea').val() );
		//	console.log( $('textarea#postTitleArea').val() );
		//	console.log( $('#temporaryTitle').val() );
	})
}


function addContentsAsTextarea(){
	const content=  $.trim( document.querySelector(".editorDIV").innerHTML );
	$('#postContents').html(content);
}

// 게시글 본문 클릭시 placeholder 역할 해주는 div태그 삭제
function deleteFirstContents(){
	$('.editorDIV').on('click',function(){
		$('.first_editor_contents').remove();
	})
}

function qlHeadercursor(){
	
	//H1, H2, H3, H4
	$('.ql_header').on('click',function(event){
		console.log(window.getSelection());
		document.execCommand("formatBlock",null,'H'+$(event.target).closest('button').val());
	})
	
	//Bold, Italic, StrikeThrough
	$('.textControl').on('click',function(event){
		document.execCommand($(this).val(),null,document.getSelection());
	})
	

	// BlackQuote
	$('.ql_quote').on('click',function(event){
		document.execCommand("formatBlock",null,"BLOCKQUOTE");
	})
	
	//link ql_link
	$('.ql_link').on('click',function(event){
		var link = document.getSelection().toString();
		var isHttp = link.substring(0,4);
		if(isHttp != "http" ){
			link = "http://"+link;
		}
		document.execCommand("createLink",null,link);
		//document.execCommand("createLink",null," ");
	})
	
	// img 삽입.   미완성
	$('.ql_img').on('click',function(event){
		document.execCommand("insertImage",null,"img/human.png");
	})
	
	
	
}







// ------------------------text event 샘플 ----------------------------------


function ql_header(){
	$('.ql_header').on('click',function(event){
		var target_header = '<h'+$(event.target).closest('button').val()+'/>';
		
		 /*var stringHeader = $(target_header, {
		        'text': document.getSelection()
		    }).prop('outerHTML');
		    */
		 var stringHeader = $(target_header, {
		        'text': document.getSelection()
		    }).prop('outerHTML');
		    
	    document.execCommand('insertHTML', false, stringHeader);
	})
}


var execH3Element = function () {
	//getSelection = 드래그 한 영역
	//드래그 안하고 H 태그 눌렀을때 나와야하는 로직이 생성되야함., IF문같은거
    var spanString = $('<h3/>', {
        'text': document.getSelection()
    }).prop('outerHTML');
    document.execCommand('insertHTML', false, spanString);
}
