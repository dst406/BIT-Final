$(function(){
	studentAdd();
	studentDelete();
})

function studentAdd(){
	var array = new Array();
	
	$('.student-check').on('click', function(e){
		array.push($(e.target).val())
	})
	
	$('#student-add-btn').on('click', function(){
		$.ajax({
			url : '/lecture/student/add/' + $('#lecture-code').val(),
			type : 'post',
			data : JSON.stringify(array),
			contentType : 'application/json'
		}).done(function(){
			location.reload();
		}).fail(function(){
			alert('lecture student add fail')
		})
	})
}

function studentDelete(){
	var array = new Array();
	
	$('.student-delete-check').on('click', function(e){
		array.push($(e.target).val());
	})
	
	$('#student-delete-btn').on('click', function(){
		$.ajax({
			url : '/lecture/student/delete/' + $('#lecture-code').val(),
			type : 'delete',
			data : JSON.stringify(array),
			contentType : 'application/json'
		}).done(function(){
			location.reload();
		}).fail(function(){
			alert('lecture student delete fail')
		})
	})
}