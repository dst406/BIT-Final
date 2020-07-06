$(function(){
	$('#lecture-state-type').on('change', function(){
		location.href = '/teacher/getLectureListByState/' + $(this).val();
	})
})