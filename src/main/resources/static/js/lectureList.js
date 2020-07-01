$(function(){
	$('#lecture-state-type').on('change', function(){
		location.href = '/getLectureListByState/' + $(this).val();
	})
})