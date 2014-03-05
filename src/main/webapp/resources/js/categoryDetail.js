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
		
		if(action == 'modify') {
			ceatoryForm.action ='/category/modify'
		}
		
		if(action == 'delete') {
			
		}
	}
};

var categoryDetailObj = com.jay.newsfiddle.categoryDetail;