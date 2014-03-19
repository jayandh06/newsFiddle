/**
 * Manage category
 */

com.jay.newsfiddle.categoryDetail = {
	validateCategoryDetail : function(action){
		
		var categoryForm = $('form[name="categoryDetailForm"]');
		
		if(action == 'create') {			
			if(!categoryDetailObj.validateFields()){
				categoryForm.attr('action', GLOBAL_APP_CONTEXT + '/categoryDetail/create');
				categoryForm.submit();
			}
		}
		
		if(action == 'update') {
			if(!categoryDetailObj.validateFields()){
				categoryForm.attr('action', GLOBAL_APP_CONTEXT + '/categoryDetail/update');
				categoryForm.submit();				
			}
		}
		
		if(action == 'delete') {
			categoryForm.attr('action', GLOBAL_APP_CONTEXT + '/categoryDetail/delete');
			categoryForm.submit();			
		}
	},
	validateFields : function(){
		var providerName=$("input[name='providerName']");
		var providerNameInfo=$("#providerNameInfo");
		var providerUrl=$("input[name='providerUrl']");
		var providerUrlInfo=$("#providerUrlInfo");
		var categoryId=$("select");
		var categoryIdInfo=$("#categoryIdInfo");
		var rssUrl=$("input[name='rssUrl']");
		var rssUrlInfo=$("#rssUrlInfo");
		var hasError = false;
		
		if(providerName.val().length<4){
			providerNameInfo.addClass('errorText');
			providerName.addClass('inputError');
			hasError = true;
		}
		else{
			providerNameInfo.removeClass('errorText');
			providerName.removeClass('inputError');
		}
		
		if(providerName.val().length <= 0){
			providerUrlInfo.addClass('errorText');
			providerUrl.addClass('inputError');
			hasError = true;
		}
		else{
			providerUrlInfo.removeClass('errorText');
			providerUrl.removeClass('inputError');
		}
		
		if(categoryId.val().length <= 0){
			categoryIdInfo.addClass('errorText');
			categoryId.addClass('inputError');
			hasError=true;
		}
		else{
			categoryIdInfo.removeClass('errorText');
			categoryId.removeClass('inputError');
		
		}	
		
		if(rssUrl.val().length<=0){
			rssUrlInfo.addClass('errorText');
			rssUrl.addClass('inputError');
			hasError = true;
		}else{
			rssUrlInfo.removeClass('errorText');
			rssUrl.removeClass('inputError');
		}
		
		return hasError;
	},
	retrieveCategoryDetailList:function(){
		$.getJSON(GLOBAL_APP_CONTEXT+'/categoryDetail/list',function(data){
			$.each(data,function(cnt,item){
				var rowStyle='oddRow';
				if(cnt%2 == 0){
					rowStyle='evenRow';
				}				
				$("#categorydetail-list-table").append('<tr class='+rowStyle+'><td width="150px" class="valueCell" ><a href="javascript:categoryDetailObj.retrieveCategoryDetail('+item.categoryDetailId+')">'+item.categoryDetailId+'</a></td><td width="250px" class="valueCell" >'+item.providerName+'</td><td width="250px" class="valueCell" >'+item.providerUrl+'</td><td width="250px" class="valueCell" >'+item.rssUrl+'</td><td width="250px" class="valueCell" >'+item.categoryName+'</td></tr>');	
			});
			
		});
	},
	addCategoryDetail:function(){
		$("#list-container").hide();
		$("form[name='categoryDetailForm']").show();
		$("input[name='providerName']").focus();
	},
	retrieveCategoryDetail : function(catDetailId){
		$("#list-container").hide();
		$("form[name='categoryDetailForm']").show();
		$.getJSON(GLOBAL_APP_CONTEXT + "/categoryDetail/"+catDetailId,function(data){
			$('[name="categoryDetailId"]').val(data.categoryDetailId);			
			$('[name="providerName"]').val(data.providerName);			
			$('[name="providerUrl"]').val(data.providerUrl);
			$('[name="rssUrl"]').val(data.rssUrl);			
			$('[name="categoryId"]').val(data.categoryId);
		});
	}
};

var categoryDetailObj = com.jay.newsfiddle.categoryDetail;


$(document).ready(categoryDetailObj.retrieveCategoryDetailList());

