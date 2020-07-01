//원장이 강사등록할때 선생의 이미지를 업로드 할 때
$(function(){
	teacherImgUpload();
})

function teacherImgUpload(){
	$('#teacher-update-btn').on('click', function(){
		var file = $('#teacher-file')[0].files[0];
		var fileName = '';
		if(file != null) fileName = file.name;
		else if(file == null) fileName = $('#teacher-img').data('img');
		
		var formData = new FormData();
		formData.append("imgFile", file);
		$.ajax({
			url: '/teacher/image/upload',
			type: 'post',
			data: formData,
			enctype: 'multipart/form-data',
			contentType: false,
			processData: false,
			cache: false
		}).done(function(){
			alert('이미지 업로드 성공')
			//location.reload();
		}).fail(function(){
			alert('teacher img upload fail')
		})
	})
}