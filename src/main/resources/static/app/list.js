$('#initBody').hide();


$(document).ready(function() {
	$('#initBody').show();
	
	$(document).on("click", ".removeItem", function () {
	     var url = $(this).attr('rel');
	     $(".modal-footer #confirmForm").attr( "action", url );
	});
	
	
	var orderBy = $("#filterForm input[name=orderBy]").val();
	var orderMode = $("#filterForm input[name=orderMode]").val();
	$(".orderClick").each(function (index) { 
		if(orderBy == $(this).attr("role")){
			$(this).removeClass("fa-sort");
			$(this).addClass("fa-sort-"+orderMode);
		}
	}) 
	
});

var submitForm = function(idBtn, fields, values){
	if($("#"+idBtn ).hasClass( "toggle-button" )){//remove
		$.each(fields, function( index, field ) {
			$("#filterForm input[name="+field+"]").val( "" );
		});
		$("#"+idBtn ).removeClass("toggle-button");
		$("#"+idBtn ).blur();
		
	}else{
		$.each(fields, function( index, field ) {
			$("#filterForm input[name="+field+"]").val( values[index] );
		});
	}
	$("#filterForm").submit();
}



var resetForm = function(){
	$(':input','#filterForm')
		.not(':button, :submit, :reset, :hidden')
		.val('')
		.removeAttr('checked')
		.removeAttr('selected');
	$("#filterForm").submit();
}




$(document).on('click', '.orderClick', function () {
	var orderBy = $("#filterForm input[name=orderBy]").val();
	var orderMode = $("#filterForm input[name=orderMode]").val();
	
	if(orderBy == $(this).attr("role")){
		orderMode = (orderMode =="asc"?"desc":"asc");
	}else{
		orderMode = "asc";
	}
	
	$("#filterForm input[name=orderBy]").val( $(this).attr("role") );
	$("#filterForm input[name=orderMode]").val( orderMode );
	
	$("#filterForm").submit();
});




$(document).on('click', '.paginationClick', function () {
	$('#filterForm').attr("action",  $(this).attr("rel") );
	$("#filterForm").submit();
});

