 $(function(){
	 
	 $.ajax({
			url:"/manager/getMonthlyIncome"
		}).done(function(data){
			 google.charts.load('current', {'packages':['bar']});
		     google.charts.setOnLoadCallback(chart);
		     
		     function chart(){
		    	 var chartArray = new Array();
		    	 var costArray = new Array();
		    	 var userArray = new Array();
		    	 	userArray.push("월별 통계");
		    	 
					 $.each(data,function(index,item){
						 costArray.push(item.paymentDate);
			        	 $.each( item.income,function(idx,value){
			        		 costArray.push(value.cost.toString());
			        		 userArray.push(value.userName);
			        	 })
			        	 chartArray.push(costArray);
			        	 costArray = [];
			      })
					 
					 var resultArr = []; 
					 $.each(userArray , function(key, value){ 
						 if($.inArray(value, resultArr) === -1) 
							 resultArr.push(value); 
						 })
					var chartData = google.visualization.arrayToDataTable([
						resultArr
					]);
					
					$.each(chartArray,function(index,item){
						chartData.addRow(item);
					})
					
				      
					
					
				      var options = {
				        width: 1100,
				        height: 400,
//				        legend: { position: 'top', maxLines: 3},
				        bar: { groupWidth: '75%' },
				        isStacked: true,
				      };


				      var chart = new google.charts.Bar(document.getElementById('monthlyIncomeChart'));

				      chart.draw(chartData, google.charts.Bar.convertOptions(options));
				}
		
		})
	
		
		
		
	 
})




//
//$(function(){
//	
//	console.log('여기왔냐');
//	$.ajax({
//		url:"/manager/getMonthlyIncome"
//	}).done(function(data){
//		 google.charts.load('current', {'packages':['bar']});
//	     google.charts.setOnLoadCallback(chart(data));
//	     
//		function chart(data){
//			var array = new Array();
//			
//			$.each(data,function(index,item){
//				array.push(item);
//			})
//			
//			console.log(array);
//			
//			var chartData = google.visualization.arrayToDataTable([
//				 ['Genre', 'Fantasy & Sci Fi', 'Romance', 'Mystery/Crime', 'General',
//			         'Western', 'Literature', { role: 'annotation' } ],
//			        ['2010', 10, 24, 20, 32, 18, 5, ''],
//			        ['2020', 16, 22, 23, 30, 16, 9, ''],
//			        ['2030', 28, 19, 29, 30, 12, 13, ''],
//			        ['2030', 28, 19, 29, 30, 12, 13, ''],
//			        ['2030', 28, 19, 29, 30, 12, 13, ''],
//			        ['2030', 28, 19, 29, 30, 12, 13, '']
//		      ]);
//			
////			var data = google.visualization.arrayToDataTable([
////		        ['Genre', 'Fantasy & Sci Fi', 'Romance', 'Mystery/Crime', 'General',
////		         'Western', 'Literature', { role: 'annotation' } ],
////		        ['2010', 10, 24, 20, 32, 18, 5, ''],
////		        ['2020', 16, 22, 23, 30, 16, 9, ''],
////		        ['2030', 28, 19, 29, 30, 12, 13, ''],
////		        ['2030', 28, 19, 29, 30, 12, 13, ''],
////		        ['2030', 28, 19, 29, 30, 12, 13, ''],
////		        ['2030', 28, 19, 29, 30, 12, 13, '']
////		      ]);
//		      var options = {
//		        width: 1100,
//		        height: 400,
//		        legend: { position: 'top', maxLines: 3},
//		        bar: { groupWidth: '75%' },
//		        isStacked: true,
//		      };
//		      
//		      var chart = new google.charts.Bar(document.getElementById('monthlyIncomeChart'));
//		      chart.draw(chartData, google.charts.Bar.convertOptions(options));
//		}
//	})
//})
