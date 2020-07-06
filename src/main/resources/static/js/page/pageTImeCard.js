$(function() {

	var actionForm = $("#actionForm");

	$(".paginate_button a").on("click", function(e) {
		e.preventDefault();
		console.log("click");

		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
	});

	var timeDate = $('#time-card-date').val();
	if(timeDate == '') timeDate = '0';
	var stateName = $('#attendance-type').val();
	if((timeDate != '' && timeDate != '0') || stateName != '전체') 
		actionForm.attr("action", "/manager/attendance/search/" + timeDate + "/" + stateName);
})