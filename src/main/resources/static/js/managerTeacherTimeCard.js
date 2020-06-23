$(function(){
	dateSearch();
	attendanceTypeSearch();
})

function dateSearch(){
	$('#time-card-date').on('change', function(){
		console.log($(this).val());
		console.log($.type($(this).val()));
		$.ajax({
			url: '/teacher/timeCard/dateSearch',
			type: 'get',
			data: {attendanceGoTime: $(this).val()},
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
						attendanceType : attendanceType
					},
					dataType : 'json'
				}).done(
						function(list) {
							$('#attendance-list').empty();
							$('#attendance-list div').empty();
							$.each(list, function(index, value) {
								var example = '<tr>' + 
										'<td>' + (index + 1) + '</td>' +
										'<td>' + value.userName + '</td>' + 
										'<td>' + value.attendanceComeTime +  '</td>' +
										'<td>' + value.attendanceGoTime + '</td>' +
										'<td>' + value.userTel + '</td>' +
										'<td>' + value.attendanceStateName
										+ '</a></td>' + 
										'<td>'+ value.approvalRegisterDate + '</td> </tr>';
								$('#approval-list').append(example);
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