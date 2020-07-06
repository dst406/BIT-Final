//원장이 강사등록할때 선생의 이미지를 업로드 할 때
$(function(){
	studentImgUpload();
})

function studentImgUpload(){
	$('#student-insert-btn').on('click', function(event){
	
		var file = $('#student-file')[0].files[0];
		var fileName = '';
		if(file != null) fileName = file.name;
		else if(file == null) fileName = $('#student-img').data('img');
		
		var formData = new FormData();
		formData.append("imgFile", file);
		
		$.ajax({
			url: '/student/image/upload',
			type: 'post',
			data: formData,
			enctype: 'multipart/form-data',
			contentType: false,
			processData: false,
			cache: false
		}).done(function(){
			//location.reload();
			$('#insertStudentForm').submit();
		}).fail(function(){
		}).always(function(){
		})
	})
}