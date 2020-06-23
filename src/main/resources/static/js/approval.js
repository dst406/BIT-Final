$(function() {
	approvalModal('.approval-modal');
	approvalType();
	approvalAllow();
	approvalReject();
})

function approvalAllow(){
	$('.approval-modal').on('click', function(e){
		var approvalNo = $(e.target).data('no');
		var ele =  $('#' + approvalNo);
		$(ele.find('.approval-allow-btn')).on('click', function(e){
			$.ajax({
				url: '/approval/allow',
				type: 'PUT',
				data: approvalNo
			}).done(function(){
				location.reload();
			}).fail(function(){
				alert('approval allow fail')
			})
			
		})
	})
}

function approvalReject(){
	$('.approval-modal').on('click', function(e){
		var approvalNo = $(e.target).data('no');
		var ele =  $('#' + approvalNo);
		$(ele.find('.approval-reject-btn')).on('click', function(e){
			$.ajax({
				url: '/approval/reject',
				type: 'PUT',
				data: approvalNo
			}).done(function(){
				location.reload();
			}).fail(function(){
				alert('approval reject fail')
			})
			
		})
	})
}

function approvalModal(target) {
	$(target).magnificPopup({
		type : 'inline',
		midClick : true
	})

}

function approvalType() {
	$('#approval-type').on(
			'change',
			function() {
				var approvalType = $(this).val()
				// ajax
				$.ajax({
					url : '/manager/approval/search',
					type : 'GET',
					data : {
						approvalType : approvalType
					},
					dataType : 'json'
				}).done(
						function(list) {
							$('#approval-list').empty();
							$('#approval-list div').empty();
							$.each(list, function(index, value) {
								var example = '<tr>' + 
										'<td>' + (index + 1) + '</td>' +
										'<td>' + value.approvalTypeName + '</td>' + 
										'<td>' + value.approvalStateName +  '</td>' +
										'<td>' + value.userName + '</td>' +
										'<td>' + '<a class="approval-modal" data-mfp-src="#'+value.approvalNo+'" style="cursor: pointer;">' + value.approvalContent
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
								approvalModal('.approval-modal');
							})
							console.log(list)

						}).fail(function() {
					alert('approval search fail')
				})
			})
}