

		window.onload = function() {
			google.charts.load('current', {packages: ['corechart', 'bar']});
			//google.charts.setOnLoadCallback(drawColColors);
			 google.charts.setOnLoadCallback(drawTopX);


			function drawTopX() {
			      var data = new google.visualization.DataTable();
			      data.addColumn('timeofday', 'Time of Day');
			      data.addColumn('number', 'Motivation Level');
			      data.addColumn('number', 'Motivation Level1');
			      data.addColumn('number', 'Energy Level');

			      data.addRows([
			        [{v: [8, 0, 0], f: '8 am'}, 1,0, .25],
			        [{v: [9, 0, 0], f: '9 am'}, 2,0, .5],
			        [{v: [10, 0, 0], f:'10 am'}, 3,0, 1],
			        [{v: [11, 0, 0], f: '11 am'}, 4,0, 2.25],
			        [{v: [12, 0, 0], f: '12 pm'}, 5,0, 2.25],
			        [{v: [13, 0, 0], f: '1 pm'}, 6,0, 3],
			        [{v: [14, 0, 0], f: '2 pm'}, 7,0, 4],
			        [{v: [15, 0, 0], f: '3 pm'}, 8, 0,5.25],
			        [{v: [16, 0, 0], f: '4 pm'}, 9,0, 7.5],
			        [{v: [17, 0, 0], f: '5 pm'}, 80,100, 90]
			      ]);

			      var options = {
			    		  width: 600,
			    	        height: 250,
			        axes: {
			          x: {
			            0: {side: 'top'}
			          }
			        },
			        hAxis: {
			          title: 'Time of Day',
			          format: 'h:mm a',
			          viewWindow: {
			            min: [7, 30, 0],
			            max: [17, 30, 0]
			          }
			        },
			        vAxis: {
			          title: 'Rating (scale of 1-10)'
			        }
			      };

			      var materialChart = new google.charts.Bar(document.getElementById('chart_div'));
			      materialChart.draw(data, options);
			    }
			
			
			/*
			
			var ctx = document.getElementById('avgChart').getContext('2d');
			var chart = new Chart(ctx, {
			    // The type of chart we want to create
			    type: 'bar',

			    // The data for our dataset
			    data: {
			        labels: ['국어', '영어', '수학', '사회', '과학'],
			        datasets: [{
			            label: '총점',
			            backgroundColor: 'rgb(255, 99, 132)',
			            borderColor: 'rgb(255, 99, 132)',
			            data: [60, 70, 80, 60, 90]
			        }]
			    },

			    // Configuration options go here
			    options: {
			        scales: {
			            xAxes: [{
			                stacked: true
			            }],
			            yAxes: [{
			                stacked: true
			            }]
			        }
			    }
			});
			
			*/
			
		};

	