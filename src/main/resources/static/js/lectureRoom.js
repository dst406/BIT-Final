$(function(){
	modal('#lectureRoom-add')
	insertLectureRoom();
})

function modal(target){
	$(target).magnificPopup({
		type : 'inline',
		midClick : true
	})
}

function insertLectureRoom(){
	$('#lectureRoom-insert-btn').on('click', function(){
		var obj = new Object();
		obj.lectureDay = $('#lecture-day').val();
		obj.lectureCode = $('#lecture').val();
		obj.lectureAllocationTime = $('#lecture-allocation-time').val();
		obj.lectureStartTime = parseInt($('#lecture-time').val());
		
		console.log(obj);
		$.ajax({
			url : '/lecture/room/add',
			type : 'post',
			data : JSON.stringify(obj),
			contentType : 'application/json'
		}).done(function(){
			location.reload();
		}).fail(function(){
			alert('lectureRoom insert fail')
		})
	})
}