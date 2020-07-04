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
		}).done(function(){
			nowTime("출근");
			
		})
	})
	
	$('body').on('click','#go-btn', function(event){
		event.preventDefault();
		$.ajax({
			url:"/teacher/go"
		}).done(function(){
			nowTime("퇴근");
		})
	})
	
	
	function nowTime(attendance){
		var now = new Date();
		var nowTime = now.getFullYear();
		var nowMonth = (now.getMonth() + 1 );
			nowMonth = nowMonth < 10 ? "0"+nowMonth : nowMonth; 
		var nowDate = ( now.getDate() < 10 ? "0"+now.getDate() : now.getDate() );
			
		nowTime += '-' + nowMonth;
		nowTime += '-' + nowDate;
		nowTime += ' ' + now.getHours();
		nowTime += ':' + now.getMinutes();
		nowTime += ':' + now.getSeconds();
		$('#attendanceTime').text(nowTime+" "+attendance+"완료");
		
		setInterval(function(){
			$("#attendanceTime").text("");
		},5000);
	}
	
}