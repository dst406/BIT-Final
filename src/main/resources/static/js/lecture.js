$(function(){
	lectureTime();
	lectureDelete();
	lectureMember();
	updateLecture();
	$('#lecture-updatecancel-btn').on('click',function(){
		location.href="/manager/getManagerLectureList"
	})
})

function updateLecture(){
	$('#lecture-update-btn').on('click',function(){
		if(confirm('수정하시겠습니까?')){
			var obj = new Object();
			var lectureContent = $('#lectureContent').val();
			if(lectureContent == null || lectureContent == '') lectureContent = "내용 없음";
			
			obj.lectureCode = $('#lectureCode').val();
			obj.lectureName = $('#lectureName').val();
			obj.seasonId = $('#lectureSeason').val();
			obj.userName = $('#userName').val();
			obj.userTel = $('#userTel').val();
			obj.lectureCost = $('#lectureCost').val();
			obj.lectureContent = lectureContent;
			console.log(obj);
			
			$.ajax({
				url : '/manager/lecture/update/',
				type : 'PUT',
				data : JSON.stringify(obj),
				contentType : 'application/json'
			}).done(function(){
				location.reload();
			}).fail(function(){
				alert('manager lecture update fail')
			})
		}
		
	})
}

function lectureMember(){
	$('#lecture-memeber-btn').on('click', function(){
		location.href = "/goLectureMember/" + $('#lecture-code').val();
	})
}

function lectureDelete(){
	$('#lecture-delete-btn').on('click', function(){
		if(confirm('삭제하시겠습니까?')){
			location.href = "/manager/deleteLecture/" + $('#lecture-code').val();
		}		
	})
}

function lectureTime(){
	var season = $('#season');
	$('.lecture-day-div input').on('click', function(e){
		var time = '';
		var day = $('.lecture-day-div').find('label[for='+$(this).attr('id')+']').text();
		console.log(day);
		
		if(season.val() == 'SUMMERVACATION' || season.val() == 'WINTERVACATION'){
			time = day + '<p></p><input id="vacation_1" type="checkbox"><label for="vacation_1">10:00</label>' + 
			'<input id="vacation_2" type="checkbox"><label for="vacation_2">11:00</label>' + 
			'<input id="vacation_3" type="checkbox"><label for="vacation_3">12:00</label>' + 
			'<input id="vacation_4" type="checkbox"><label for="vacation_4">14:00</label>' + 
			'<input id="vacation_5" type="checkbox"><label for="vacation_5">15:00</label>' + 
			'<input id="vacation_6" type="checkbox"><label for="vacation_6">16:00</label>' + 
			'<input id="vacation_7" type="checkbox"><label for="vacation_7">17:00</label>' + 
			'<input id="vacation_8" type="checkbox"><label for="vacation_8">18:00</label> <p></p>';
		} else if(season.val() == null || season.val() == ''){
			alert('시즌을 먼저 선택해주세요.');
			$(this).prop('checked', false);
		} else {
			time = day +  '<p></p><input id="normal_1" type="checkbox"><label for="normal_1">18:00</label>' + 
			'<input id="normal_2" type="checkbox"><label for="normal_2">19:00</label>' + 
			'<input id="normal_3" type="checkbox"><label for="normal_3">20:00</label>' + 
			'<input id="normal_4" type="checkbox"><label for="normal_4">21:00</label>' + 
			'<input id="normal_5" type="checkbox"><label for="normal_5">22:00</label> <p></p>';
		}
		
		$('#lecture-time-div').append(time);
	})
}


function lectureType() {
	$('#lecture-type').on('change', function() {
			var approvalType = $(this).val()
			if(approvalType == "전체") location.href = "/getManagerLectureList";
			// ajax
			$.ajax({
				url : '/manager/lecture/search/',
				type : 'GET',
				data : {
					approvalType : approvalType
				},
				dataType : 'json'
			}).done(
					function(list) {
						$('.pagination').hide();
						$('#approval-list').empty();
						$('#approval-list div').empty();
						$.each(list, function(index, value) {
							var example = '<tr>' + 
									'<td>' + (index + 1) + '</td>' +
									'<td>' + value.approvalTypeName + '</td>' + 
									'<td>' + value.approvalStateName +  '</td>' +
									'<td>' + value.userName + '</td>' +
									'<td>' + value.approvalContent + '</td>' +
									'<td>' + value.approvalRegisterDate + '</td>'
									+ '</tr>';
							$('#approval-list').append(example);
							
							approvalModal('.approval-modal');
							approvalAllow()
							approvalReject()
							
						})
						console.log(list)

					}).fail(function() {
				alert('approval search fail')
			})
		})
}