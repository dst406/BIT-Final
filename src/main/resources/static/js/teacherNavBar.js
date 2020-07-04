$(function(){
	attendance();
	$('body').on('click','.teacher-nav-1', function(){
		$('#teacher-ul').slideToggle('fast');
	})
	
})




function attendance(){
	$('body').on('click', '#come-btn',function(event){
		event.preventDefault();
		$.ajax({
			url:"/teacher/come"
		}).done(function(data){
			$('.navbar-custom').html(data);
			nowTime("출근");
			
		})
	})
	
	$('body').on('click','#go-btn', function(event){
		event.preventDefault();
		$.ajax({
			url:"/teacher/go"
		}).done(function(data){
			$('.navbar-custom').html(data);
			nowTime("퇴근");
		})
	})
	
	
	function nowTime(attendance){
		var now = new Date();
		var nowTime = now.getFullYear();
	
		nowTime += '-' + isLowTime((now.getMonth() + 1 ));
		nowTime += '-' + isLowTime( now.getDate()) ;
		nowTime += ' ' + isLowTime( now.getHours() );
		nowTime += ':' + isLowTime( now.getMinutes() );
		nowTime += ':' + isLowTime( now.getSeconds() );
		$('#attendanceTime').text(nowTime+" "+attendance+"완료");
		
		setInterval(function(){
			$("#attendanceTime").text("");
		},5000);
	}
	
	function isLowTime(time){
		time = time < 10 ? "0"+time : time;
		return time;
	}
	
}