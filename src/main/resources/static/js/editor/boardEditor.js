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
			url:"/board/deleteTemporaryPost",
			data : {
				temporaryNo:$target.attr('temporaryno')
			}
		}).done(function(){
			$target.closest('a').remove();
		})
	})
}

//게시글 등록
function addPostSubmit(){
	$('body').on('click','#saveButton , #updateButton',function(){
		console.log('왔얼');
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
	$('body').on('click','.temporarySaveButton',function(){
		addContentsAsTextarea();
		$('#postTitle').val( $('textarea#postTitleArea').val() );
		$.ajax({
			type:'POST',
			url:'/board/insertTemporaryPost',
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
		document.execCommand("formatBlock",null,'H'+$(event.target).closest('button').val());
	})
	
	//Bold, Italic, StrikeThrough
	$('.textControl').on('click',function(event){
		document.execCommand($(this).val(),null,document.getSelection());
	})
	
	
	//algin
	$('.ql_text_align').on('click',function(){
		document.execCommand($(this).val());
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







