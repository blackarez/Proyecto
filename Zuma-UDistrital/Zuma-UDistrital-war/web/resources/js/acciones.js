$(document).ready(function(){
    $(".toggle").click(function(){
    	var x=$(this).prop('id');
    	//alert("var "+x);
    	$("."+x).toggleClass('acti');
    });
});