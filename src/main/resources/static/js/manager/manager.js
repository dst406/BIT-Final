 
$(function(){
	  google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(chart);
	
	
	function chart(){
		var data = google.visualization.arrayToDataTable([
	        ['Genre', 'Fantasy & Sci Fi', 'Romance', 'Mystery/Crime', 'General',
	         'Western', 'Literature', { role: 'annotation' } ],
	        ['2010', 10, 24, 20, 32, 18, 5, ''],
	        ['2020', 16, 22, 23, 30, 16, 9, ''],
	        ['2030', 28, 19, 29, 30, 12, 13, ''],
	        ['2030', 28, 19, 29, 30, 12, 13, ''],
	        ['2030', 28, 19, 29, 30, 12, 13, ''],
	        ['2030', 28, 19, 29, 30, 12, 13, '']
	      ]);

	      var options = {
	        width: 1100,
	        height: 400,
	        legend: { position: 'top', maxLines: 3},
	        bar: { groupWidth: '75%' },
	        isStacked: true,
	      };


	      var chart = new google.charts.Bar(document.getElementById('monthlyIncomeChart'));

	      chart.draw(data, google.charts.Bar.convertOptions(options));
	}
		
	
	

})


/*window.onload = function () {

	var chart = new CanvasJS.Chart("monthlyIncomeChart", {
		animationEnabled: true,
		theme: "light1", // "light1", "light2", "dark1", "dark2"
		title: {
			 text: "GDP Growth Rate - 2016" 
		},
		axisY: {
			 title: "Growth Rate (in %)", 
			suffix: "%",
			includeZero: false
		},
		axisX: [{
			title: "Countries"
		}],
		data: [{
			type: "column",
			yValueFormatString: "#,##0.0#\"%\"",
			label : ["abc","dcdc"],
			dataPoints: [
				{ label:'aaa', y: 10.1 },	
				{  y: 6.70 },	
				{ label: "Indonesia", y: 5.00 },
				{ label: "Australia", y: 2.50 },	
				{ label: "Mexico", y: 2.30 },
				{ label: "UK", y: 1.80 },
				{ label: "United States", y: 1.60 },
				{ label: "Japan", y: 1.60 }
				
			]
		},{
			type: "column",
			yValueFormatString: "#,##0.0#\"%\"",
			label : ["abc","dcdc"],
			dataPoints: [
				{ label:'sss',y: 5.1 },	
				{ y: 4.70 },	
				{ label: "Indonesia", y: 3.00 },
				{ label: "Australia", y: 2.50 },	
				{ label: "Mexico", y: 2.30 },
				{ label: "UK", y: 1.80 },
				{ label: "United States", y: 1.60 },
				{ label: "Japan", y: 1.60 }
				
			]
		}]
	});
	chart.render();

	}*/