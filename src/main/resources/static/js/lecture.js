$(function(){
	lectureTime();
})

function lectureTime(){
	var season = $('#season');
	$('.lecture-day-div input').on('click', function(){
		var time = '';
		
		if(season.val() == 'SUMMERVACATION' || season.val() == 'WINTERVACATION'){
			time = '<input id="vacation_1" type="checkbox"><label for="vacation_1">10:00</label>' + 
			'<input id="vacation_2" type="checkbox"><label for="vacation_2">11:00</label>' + 
			'<input id="vacation_3" type="checkbox"><label for="vacation_3">12:00</label>' + 
			'<input id="vacation_4" type="checkbox"><label for="vacation_4">14:00</label>' + 
			'<input id="vacation_5" type="checkbox"><label for="vacation_5">15:00</label>' + 
			'<input id="vacation_6" type="checkbox"><label for="vacation_6">16:00</label>' + 
			'<input id="vacation_7" type="checkbox"><label for="vacation_7">17:00</label>' + 
			'<input id="vacation_8" type="checkbox"><label for="vacation_8">18:00</label>';
		} else if(season.val() == null || season.val() == ''){
			alert('시즌을 먼저 선택해주세요.');
			$(this).prop('checked', false);
		} else {
			time = '<input id="normal_1" type="checkbox"><label for="normal_1">18:00</label>' + 
			'<input id="normal_2" type="checkbox"><label for="normal_2">19:00</label>' + 
			'<input id="normal_3" type="checkbox"><label for="normal_3">20:00</label>' + 
			'<input id="normal_4" type="checkbox"><label for="normal_4">21:00</label>' + 
			'<input id="normal_5" type="checkbox"><label for="normal_5">22:00</label>';
		}
		
		$('#lecture-time-div').append(time);
		
		var day = '';
		$('.lecture-time-div input').on('click', function(){
			
		})
	})
}