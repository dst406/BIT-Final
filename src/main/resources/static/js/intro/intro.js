$(function(){
	sidemenuActive();
})

function sidemenuActive(){
	$('.site-main-menu > li').on('click',function(event){
		$('.site-main-menu li').removeClass('active');
		$(this).addClass('active');
		console.log($(event.target));
		mainContentsActive($(event.target));
	})
}

function mainContentsActive(target){
	console.log(target);
	$contentsNum = target.attr('data-goto');
	$('.subpages section').removeClass('pt-page-current');
	console.log($contentsNum);
	console.log($('.subpages section:nth-child('+$contentsNum+')'));
	$('.subpages section:nth-child('+$contentsNum+')').addClass('pt-page-current');
	
	
}