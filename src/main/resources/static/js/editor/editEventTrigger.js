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
			var size = uploadFiles.push(file); // 업로드 목록에 추가
			preview(file, size - 1, e); // 미리보기 만들기
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

		
		$("#btnSubmit").on("click", function() {
			var formData = new FormData();
			$.each(uploadFiles, function(i, file) {
				if (file.upload != 'disable') // 삭제하지 않은 이미지만 업로드 항목으로 추가
					formData.append('upload-file', file, file.name);
			});
			
					$.ajax({
						url : '/api/etc/file/upload',
						data : formData,
						type : 'post',
						contentType : false,
						processData : false,
						success : function(ret) {
							alert("완료");
						}
					});
		});
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



function imageUploadAjax() {
	$('#files').on('change',function(event) {
						event.preventDefault();
		                var formData = new FormData($('#image_form')[0]);
		                var files = $("#files")[0].files;
		                
		                console.log(files);
						
						for(var i = 0 ; i<files.length; i++){
							formData.append("fileObj", files[i]);
						}
						console.log(formData.get("fileObj"));
						// Ajax call for file uploaling
						$.ajax({
									/*enctype : 'multipart/form-data',*/
									url : '/rest/board/imageUpload',
									type : 'POST',
									contentType : false,
									processData : false,
									data : formData,
									success : function(result) {
										$.each(result, function(index, item){
											document.execCommand("insertImage",null,"/uploadImg/"+item);
											document.execCommand('InsertParagraph');
											document.execCommand('Outdent');
										})
										
										
										
										
									}
								})
								
					})
}

