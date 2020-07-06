$(function() {

	var actionForm = $("#actionForm");

	$(".paginate_button a").on("click", function(e) {
		e.preventDefault();
		console.log("click");

		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
	});
	
	searchStudentChange();
})


function searchStudentChange(){
	$('#keyword').on('keyup , search',function(event){
		$searchVal = $(this).val();
		$searchText = searchStudentSelect($searchVal) ;
		searchTarget( $searchText, $searchVal) ;
		
		$tableLength = $('tbody > tr:visible').length;
		if($tableLength < 8 ){
//			$('.pagination').html(
//				'<li class="paginate_button page-item active">'+
//					'<a href="1" aria-controls="dataTable" data-dt-idx="1" tabindex="0" class="page-link">1</a>'+
//				'</li>'
//			);
			$('.paginate_button').hide().slice(0,1).show();
		}else{
			$('.paginate_button').hide().slice(0,7).show();
//			$('.pagination').html(
//					
//				'<li class="paginate_button page-item active">'+
//					'<a href="/teacher/getStudentList?pageNum=1&amount=8" aria-controls="dataTable" data-dt-idx="1" tabindex="0" class="page-link">1</a>'+
//				'</li>'+
//				'<li class="paginate_button page-item">'+
//					'<a href="/teacher/getStudentList?pageNum=2&amount=8" aria-controls="dataTable" data-dt-idx="1" tabindex="0" class="page-link">2</a>'+
//				'</li>'
//			
//			);
		}
		
	})
}

function searchStudentSelect($searchVal){
	$('div, td, a').unmark();
	$searchText = $('tbody td:contains('+$searchVal+') , tbody a:contains('+$searchVal+')') ;
	return $searchText ;
	
}

function searchTarget($searchText,$searchVal){
	$('tbody > tr').hide();
	$searchText.closest($('tr')).show();
	$searchText.mark($searchVal);
}

