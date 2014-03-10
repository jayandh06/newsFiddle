/**
 * Manage category
 */

com.jay.newsfiddle.category = {
	validateCategory : function(action){
		var categoryForm = $('form[name="categoryForm"]');
		console.log(categoryForm);
		if(action == 'create') {
			categoryForm.attr('action', GLOBAL_APP_CONTEXT + '/category/create');
			categoryForm.submit();
		}
		
		if(action == 'modify') {
			categoryForm.attr('action', GLOBAL_APP_CONTEXT + '/category/update');
			categoryForm.submit();
		}
		
		if(action == 'delete') {
			categoryForm.attr('action', GLOBAL_APP_CONTEXT + '/category/delete');
			categoryForm.submit();
		}
	},
	retrieveCategoryList : function(){
		$.getJSON(GLOBAL_APP_CONTEXT+'/category/list',function(data){
			var rowStyle='evenRow';
			$.each(data,function(cnt,item){
				if(cnt%2 == 0){
					rowStyle='evenRow';
				}
				else{
					rowStyle='oddRow';
				}
				$("#category-list-table").append('<tr class='+rowStyle+'><td width="150px" class="valueCell" ><a href="javascript:categoryObj.retrieveCategory('+item.categoryId+')">'+item.categoryId+'</a></td><td width="250px" class="valueCell" >'+item.categoryName+'</td></tr>');	
			});
			
		});
	},
	retrieveCategory:function(catId){
		$("#category-list").hide();
		$("#category-container").show();
		
		$.getJSON(GLOBAL_APP_CONTEXT + "/category/"+catId,function(data){
			$('[name="categoryId"]').val(data.categoryId);
			$('[name="categoryName"]').val(data.categoryName);								
		});
	}
};

var categoryObj = com.jay.newsfiddle.category;
$(document).ready(categoryObj.retrieveCategoryList());
var pageId ="Category";
