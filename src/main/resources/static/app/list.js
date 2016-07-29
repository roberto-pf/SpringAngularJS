$('#initBody').hide();


$(document).ready(function() {
	$('#initBody').show();
	
	$(document).on("click", ".removeItem", function () {
	     var url = $(this).attr('rel');
	     $(".modal-footer #confirmForm").attr( "action", url );
	});
	
});