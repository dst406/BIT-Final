$(function() {
	lectureChart();
})

function lectureChart() {
	$.ajax({
		url : '/lecture/chart',
		type : 'get',
		dataType : 'json'
	}).done(function(list) {
		console.log(list)
		google.charts.load("current", {
			packages : [ "corechart" ]
		});
		google.charts.setOnLoadCallback(function() {
			drawChart(list);
		});
	}).fail(function() {
		alert('lecture chart fail')
	})
}

function drawChart(array) {
	var lists = [];
	var data = new google.visualization.DataTable();
	data.addColumn('string', 'status');
	data.addColumn('number', 'account');
	array.forEach(function(element) {
		lists.push([ element.statusName, element.statusAccount ]);
	});
	data.addRows(lists);

	var options = {
		chartArea : {
			width : '80%',
			height : '80%'
		},
		pieHole : 0.4
		/*colors : [ '#4FC1E9', '#5D9CEC', '#48CFAD', '#A0D468', '#FFCE54',
				'#FC6E51' ]*/
	};

	var chart = new google.visualization.PieChart(document
			.getElementById('lectureStatusChart'));
	chart.draw(data, options);

}