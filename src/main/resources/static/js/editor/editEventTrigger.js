$(function() {
	checkBlockquote();
	imgUploadDragAndDrop();
	removePreview();
	imageUploadAjax();
})

/*
 * function checkBlockquote(){
 * 
 * var blockquote = $('blockquote');
 * 
 * blockquote.onkeydown = function() {
 * 
 * var key = event.keyCode || event.charCode;
 * 
 * if( key == 13){
 * 
 * if (whichTag("blockquote")){ document.execCommand('InsertParagraph');
 * document.execCommand('Outdent'); } } }; }
 */

function checkBlockquote() {
	var blockquote = $('.editorDIV');
	blockquote.keydown(function(key) {
		if (key.keyCode == 13) {
			if (whichTag("blockquote")) {
				document.execCommand('InsertParagraph');
				document.execCommand('Outdent');
			}
		}
	});
}

function whichTag(tagName) {

	var sel, containerNode;
	var tagFound = false;

	tagName = tagName.toUpperCase();

	if (window.getSelection) {

		sel = window.getSelection();

		if (sel.rangeCount > 0) {
			containerNode = sel.getRangeAt(0).commonAncestorContainer;
		}

	} else if ((sel = document.selection) && sel.type != "Control") {

		containerNode = sel.createRange().parentElement();

	}

	while (containerNode) {

		if (containerNode.nodeType == 1 && containerNode.tagName == tagName) {

			tagFound = true;
			containerNode = null;

		} else {

			containerNode = containerNode.parentNode;

		}

	}

	return tagFound;
}

var uploadFiles = [];
var $drop = $(".editorDIV");

function imgUploadDragAndDrop() {

	$drop.on("dragenter", function(e) { // 드래그 요소가 들어왔을떄
		$(this).addClass('drag-over');
	}).on("dragleave", function(e) { // 드래그 요소가 나갔을때
		$(this).removeClass('drag-over');
	}).on("dragover", function(e) {
		e.stopPropagation();
		e.preventDefault();
	}).on('drop', function(e) { // 드래그한 항목을 떨어뜨렸을때
		e.preventDefault();
		$(this).removeClass('drag-over');
		var files = e.originalEvent.dataTransfer.files; // 드래그&드랍 항목
		for (var i = 0; i < files.length; i++) {
			var file = files[i];
			console.log(file);
			
			var size = uploadFiles.push(file); // 업로드 목록에 추가
			preview(file, size - 1, e); // 미리보기 만들기
			console.log('dd');
		}
	});
}

function preview(file, idx, event) {
	var reader = new FileReader();
	reader.onload = (function(f, idx) {
		return function(e) {
			var div = '<div> \
	<div class="close" data-idx="'+ idx + '">X</div> \
	<img src="' + e.target.result
					+ '" title="' + escape(f.name) + '"/> \
	</div>';
			$(event.target).closest('div').append(div);
			$(event.target).closest('div').append('<br><br>');
		};
	})(file, idx);
	reader.readAsDataURL(file);
	var formData = new FormData();
	$.each(file, function(i, file) {
			formData.append('upload-file', files[i]);
	});
	uploadImage(formData);
		

}


function uploadImage(formData){
	$.ajax({
		url : '/rest/board/imageUpload',
		data : formData,
		type : 'post',
		contentType : false,
		processData : false,
	}).done(function(result){
		$.each(result, function(index, item){
				console.log(item);
				document.execCommand("insertImage",false,"/uploadImg/"+item);
				document.execCommand('InsertParagraph');
				document.execCommand('Outdent');
				
		})
	});
	
}


function saveSelection(){
	var saveSelection, restoreSelection;
	if (window.getSelection) {
	       // IE 9 and non-IE
	       saveSelection = function() {
	           var sel = window.getSelection(), ranges = [];
	           if (sel.rangeCount) {
	               for (var i = 0, len = sel.rangeCount; i < len; ++i) {
	                   ranges.push(sel.getRangeAt(i));
	               }
	           }
	           return ranges;
	       };

	       restoreSelection = function(savedSelection) {
	           var sel = window.getSelection();
	           sel.removeAllRanges();
	           for (var i = 0, len = savedSelection.length; i < len; ++i) {
	               sel.addRange(savedSelection[i]);
	           }
	       };
	} else if (document.selection && document.selection.createRange) {
	       // IE <= 8
	       saveSelection = function() {
	           var sel = document.selection;
	           return (sel.type != "None") ? sel.createRange() : null;
	       };

	       restoreSelection = function(savedSelection) {
	           if (savedSelection) {
	               savedSelection.select();
	           }
	       };
	}
	
}




function removePreview(){
	$(".editorDIV").on("click",".close", function(e) {
		var $target = $(e.target);
		console.log($target);
		var idx = $target.attr('data-idx');
		console.log(idx);
		uploadFiles[idx].upload = 'disable'; // 삭제된 항목은 업로드하지 않기 위해 플래그 생성
		$target.parent().remove(); // 프리뷰 삭제
	});	
}

$(function(){
	$('body').bind('focus', '#editorForm *',function(event){
		console.log('aa');
		console.log($(event.target));
	})
	
})

function imageUploadAjax() {
	
	var sel = document.getSelection();
	
	
	$('#files').on('change',function(event) {
		
						//$('#editorForm').focus();
						//$('#editorForm').setSelectionRange($('div').length,$('div').length);
		                var formData = new FormData($('#image_form')[0]);
		                var files = $("#files")[0].files;
						
						for(var i = 0 ; i<files.length; i++){
							formData.append("fileObj", files[i]);
						}
						// Ajax call for file uploaling
						uploadImage(formData);
								
					})
}

