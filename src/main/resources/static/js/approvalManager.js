$(function() {
	approvalModal('.approval-modal');
	approvalType();
	approvalAllow();
	approvalReject();
})

function approvalAllow(){
	$('.approval-modal').on('click', function(e){
		var approvalNo = $(e.target).data('no');
		console.log(approvalNo);
		var ele =  $('#' + approvalNo);
		$(ele.find('.approval-allow-btn')).on('click', function(e){
			$.ajax({
				url: '/manager/approval/allow',
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
		console.log(approvalNo);
		var ele =  $('#' + approvalNo);
		$(ele.find('.approval-reject-btn')).on('click', function(e){
			$.ajax({
				url: '/manager/approval/reject',
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
	$('#approval-type').on('change', function() {
			var approvalType = $(this).val()
			if(approvalType == "전체") location.href = "/manager/getManagerApprovalList";
			// ajax
			$.ajax({
				url : '/manager/approval/search/',
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
							'<td>' + value.userName +  '</td>' +
							'<td><a class="approval-modal" data-no="'+value.approvalNo+'" data-mfp-src="#'+value.approvalNo+'" style="cursor: pointer;">' + value.approvalContent + '</a></td>' +
							'<td>' + value.approvalRegisterDate
							+ '</a></td></tr>'
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