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
			        		 costArray.push(value.cost);
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
					
						 
					var chartData = new google.visualization.DataTable();
					 chartData.addColumn('string','월별 통계');
					 
					 $.each(resultArr.slice(1,4) , function(key,index){
						 chartData.addColumn('number',resultArr[key+1]);
					 })
					
					 $.each(chartArray,function(key,index){
						 chartArray[key].slice(1,3).unshift(resultArr[key+1]);
						 chartData.addRows([
							 chartArray[key]
						 ])
					 })

					
				      var options = {
				        width: 1100,
				        height: 400,
				        colors: ['#4FC1E9','#5D9CEC','#48CFAD','#A0D468','#FFCE54','#FC6E51'],
//				        legend: { position: 'top', maxLines: 3},
				        bar: { groupWidth: '75%' },
				        isStacked: true,
				        vAxis:{
					        format: '#,###,###원'
				        }

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
