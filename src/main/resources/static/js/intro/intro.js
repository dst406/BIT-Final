$(function(){
	sidemenuActive();
})

function sidemenuActive(){
	$('.site-main-menu > li').on('click',function(event){
		$('.site-main-menu li').removeClass('active');
		$(this).addClass('active');
		mainContentsActive($(event.target));
	})
}

function mainContentsActive(target){
	$contentsNum = target.attr('data-goto');
	$('.subpages section').removeClass('pt-page-current');
	$('.subpages section:nth-child('+$contentsNum+')').addClass('pt-page-current');
	
	
}