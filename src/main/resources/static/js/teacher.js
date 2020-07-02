$(function(){
	teacherDelete();
})


function teacherDelete(){
	$('#teacher-delete-btn').on('click', function(){
		if(confirm('삭제하시겠습니까?')){
			location.href = "/manager/deleteTeacher/" + $('#user-id').val();
		}		
	})
}