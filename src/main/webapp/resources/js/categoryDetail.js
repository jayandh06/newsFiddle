/**
 * Manage category
 */

com.jay.newsfiddle.categoryDetail = {
	validateCategoryDetail : function(action){
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
			categoryForm.attr('action', GLOBAL_APP_CONTEXT + '/categoryDetail/delete');
			categoryForm.submit();			
		}
	},
	retrieveCategoryDetailList:function(){
		$.getJSON(GLOBAL_APP_CONTEXT+'/categoryDetail/list',function(data){
			$.each(data,function(cnt,item){
				var rowStyle='oddRow';
				if(cnt%2 == 0){
					rowStyle='evenRow';
				}				
				$("#categorydetail-list-table").append('<tr class='+rowStyle+'><td width="150px" class="valueCell" ><a href="javascript:categoryDetailObj.retrieveCategoryDetail('+item.categoryDetailId+')">'+item.categoryDetailId+'</a></td><td width="250px" class="valueCell" >'+item.companyName+'</td><td width="250px" class="valueCell" >'+item.companyUrl+'</td><td width="250px" class="valueCell" >'+item.rssUrl+'</td><td width="250px" class="valueCell" >'+item.categoryName+'</td></tr>');	
			});
			
		});
	},
	retrieveCategoryDetail : function(catDetailId){
		$("#category-list").hide();
		$("#categoryDetail-container").show();
		$.getJSON(GLOBAL_APP_CONTEXT + "/categoryDetail/"+catDetailId,function(data){
			$('[name="categoryDetailId"]').val(data.categoryDetailId);			
			$('[name="companyName"]').val(data.companyName);			
			$('[name="companyUrl"]').val(data.companyUrl);
			$('[name="rssUrl"]').val(data.rssUrl);			
			$('[name="categoryId"]').val(data.categoryId);
		});
	}
};

var categoryDetailObj = com.jay.newsfiddle.categoryDetail;
$(document).ready(categoryDetailObj.retrieveCategoryDetailList());
var pageId ="CategoryDetails";
