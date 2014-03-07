/**
 * Manage category
 */

com.jay.newsfiddle.categoryDetail = {
	validateCreateCategoryDetail : function(action){
		var categoryForm = $('form[name="categoryDetailForm"]');
		console.log(categoryForm);
		if(action == 'create') {
			categoryForm.attr('action', GLOBAL_APP_CONTEXT + '/categoryDetail/create');
			categoryForm.submit();
		}
		
		if(action == 'update') {
			categoryForm.attr('action', GLOBAL_APP_CONTEXT + '/categoryDetail/update');
			categoryForm.submit();				
		}
		
		if(action == 'delete') {
			
		}
	},
	retrieveCategoryDetail : function(){
		var catDetailId = $('[name="catDetailId"]').val();
		if(catDetailId.length == 0){
			alert("Invalid CategoryDetail Id");
		}
		$.getJSON(GLOBAL_APP_CONTEXT + "/categoryDetail/"+catDetailId,function(data){
			$('[name="companyName"]').val(data.companyName);
			$('[name="companyUrl"]').val(data.companyUrl);
			$('[name="rssUrl"]').val(data.rssUrl);					
		});
	}
};

var categoryDetailObj = com.jay.newsfiddle.categoryDetail;
var pageId ="CategoryDetails";
