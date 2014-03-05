/**
 * Manage category
 */

com.jay.newsfiddle.category = {
	validateCreateCategory : function(action){
		var categoryForm = $('form[name="categoryForm"]');
		console.log(categoryForm);
		if(action == 'create') {
			categoryForm.attr('action', GLOBAL_APP_CONTEXT + '/category/create');
			categoryForm.submit();
		}
		
		if(action == 'modify') {
			ceatoryForm.action ='/category/modify'
		}
		
		if(action == 'delete') {
			
		}
	}
};

var categoryObj = com.jay.newsfiddle.category;