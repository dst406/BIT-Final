$(function(){
	imgUpload();
})

function imgUpload(){
	$('#info-update-btn').on('click', function(){
		var file = $('#manager-file')[0].files[0];
		var fileName = '';
		if(file != null) fileName = file.name;
		else if(file == null) fileName = $('#manager-img').data('img');
		console.log(fileName);
		
		var formData = new FormData();
		formData.append("imgFile", file);
		
		if(file != null){
			console.log('들어옴?')
			$.ajax({
				url: '/manager/image/upload',
				type: 'POST',
				data: formData,
				enctype: 'multipart/form-data',
				contentType: false,
				processData: false,
				cache: false
			}).done(function(){
				alert('이미지 업로드 성공')
				//location.reload();
			}).fail(function(){
				alert('manager img upload fail')
			})			
		}
		
		var obj = new Object();
		obj.userImage = fileName;
		obj.userId = $('#manager-id').val()
		obj.userName = $('#manager-name').val()
		obj.userTel = $('#manager-tel').val()
		obj.userBirth = $('#manager-birth').val()
		obj.userEmail = $('#manager-email').val()
		obj.userAddress = $('#manager-address').val()
		obj.userRemark = $('#manager-remark').val()
		obj.userRegistration = $('#manager-registration').val()
		formData.append("manager", obj);
		
		$.ajax({
			url: '/manager/update',
			type: 'PUT',
			contentType: 'application/json',
			data: JSON.stringify(obj)
		}).done(function(){
			alert('정보수정완료')
			location.reload();
		}).fail(function(){
			alert('manager update fail')
		})
	})
}