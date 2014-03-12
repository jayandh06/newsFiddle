/**
 * Manage category
 */

com.jay.newsfiddle.category = {
	validateCategory : function(action){
		var categoryName = $("input[name='categoryName']");
		var categoryNameInfo =$("#categoryNameInfo");
		
		var categoryForm = $('form[name="categoryForm"]');
		var hasError =false;
		if(action == 'create') {			
			if(categoryName.val().length <= 3){
				categoryNameInfo.addClass('errorText');
				categoryName.addClass('inputError');
				hasError = true;
			}
			else{
				categoryNameInfo.removeClass('errorText');
				categoryName.removeClass('inputError');
			}
			if(!hasError) {
				categoryForm.attr('action', GLOBAL_APP_CONTEXT + '/category/create');
				categoryForm.submit();
			}
		}
		
		if(action == 'modify') {
			if(categoryName.val().length <= 3){
				categoryNameInfo.toggleClass('errorText');
				categoryName.toggleClass('inputError');
				hasError = true;
			}
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
	addCategory:function(){
		$("#list-container").hide();
		$("form[name='categoryForm']").show();
		$("input[name='categoryName']").focus();
		
	},
	retrieveCategory:function(catId){
		$("#list-container").hide();
		$("form[name='categoryForm']").show();
		
		$.getJSON(GLOBAL_APP_CONTEXT + "/category/"+catId,function(data){
			$('[name="categoryId"]').val(data.categoryId);
			$('[name="categoryName"]').val(data.categoryName);								
		});
	}
	
	
};

var categoryObj = com.jay.newsfiddle.category;
$(document).ready(categoryObj.retrieveCategoryList());
