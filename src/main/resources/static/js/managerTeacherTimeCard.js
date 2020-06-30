$(function(){
	dateSearchVer2();
})

function dateSearchVer2(){
	$('#time-card-date').on('change', function(){
		var timeDate = $(this).val();
		if(timeDate == '') timeDate = '0';
		location.href = "/manager/attendance/search/" + timeDate + "/" + $('#attendance-type').val();
	})
	
	$('#attendance-type').on('change', function(){
		var timeDate = $('#time-card-date').val();
		if(timeDate == '') timeDate = '0';
		location.href = "/manager/attendance/search/" + timeDate + "/" + $(this).val();
	})
}

function dateSearch(){
	$('#time-card-date').on('change', function(){
		$.ajax({
			url: '/manager/attendance/search',
			type: 'get',
			data: {
				attendanceGoTime: $(this).val(),
				attendanceStateName : $('#attendance-type').val()
			},
			dataType: 'json'
		}).done(function(list){
			console.log(list)
			const tbody = $('.time-card-list');
			tbody.empty();
			
			$.each(list, function(index, value){
				var item = '<tr>' + 
				'<td>' + (index+1) + '</td>' +
				'<td>' + value.userName + '</td>' +
				'<td>' + value.attendanceComeTime + '</td>' +
				'<td>' + value.attendanceGoTime + '</td>' +
				'<td>' + value.userTel + '</td>' +
				'<td>' + value.attendanceStateName + '</td>' +
				 '</tr>';
				tbody.append(item);
			})
			
		}).fail(function(){
			alert('date search fail')
		})
	})
}


function attendanceTypeSearch() {
	$('#attendance-type').on(
			'change',
			function() {
				var attendanceType = $(this).val()
				// ajax
				$.ajax({
					url : '/manager/attendance/search',
					type : 'GET',
					data : {
						attendanceStateName : attendanceType,
						attendanceGoTime : $('#time-card-date').val()
					},
					dataType : 'json'
				}).done(
						function(list) {
							$('#attendance-list').empty();
							$('#attendance-list div').empty();
							$.each(list, function(index, value) {
								if(value.attendanceComeTime == null) value.attendanceComeTime = '';
								if(value.attendanceGoTime == null) value.attendanceGoTime = '';
								var example = '<tr>' + 
										'<td>' + (index + 1) + '</td>' +
										'<td>' + value.userName + '</td>' + 
										'<td>' + value.attendanceComeTime +  '</td>' +
										'<td>' + value.attendanceGoTime + '</td>' +
										'<td>' + value.userTel + '</td>' +
										'<td>' + value.attendanceStateName + '</td>' 
										+ '</tr>';
								$('#attendance-list').append(example);
								/*var modal = '<div id="' + value.approvalNo + '" class="white-popup mfp-hide">' +
												'<h5>결재종류</h5> <span>' + value.approvalTypeName + '</span>' +
												'<h5>결재상태</h5> <span>' + value.approvalStateName + '</span>' +
												'<h5>신청자</h5> <span>' + value.userName + '</span>' +
												'<h5>결재내용</h5> <span>' + value.approvalContent + '</span>' +
												'<h5>결재일자</h5> <span>' + value.approvalRegisterDate + '</span>' +
											'</div>';
								$('#approval-list').append(modal);*/
								
							})
							console.log(list)

						}).fail(function() {
					alert('attendance search fail')
				})
			})
}