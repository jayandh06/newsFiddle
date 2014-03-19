com.jay.newsfiddle.news = {
		
	getNewsByCategory : function(categoryId){
		var newsContainer = $("#news-container");
		newsContainer.empty();
	$.getJSON(GLOBAL_APP_CONTEXT + "/categoryDetail/list/" + categoryId, function(data) {
			$.each(data,function(cnt,item){
				newsObj.getNewsByCategoryDetail(item.categoryDetailId);
			});			
		});
		
	},	
	
	getNewsByCategoryDetail : function(categoryDetailId) {
		var newsContainer = $("#news-container");		
		
		$.when($.getJSON(GLOBAL_APP_CONTEXT + "/synd/news/" + categoryDetailId)).then(function(data) {
			var dataCount = data.length;		
			var htmlContent = '';
			$.each(data, function(cnt, item) {
				if(cnt == 0) {
					htmlContent +="<div class='titleDiv collapsibleDiv_open'><div class='titleText'>" +  item.provider  + "</div><span></span></div><div class='provider-container'>";
				}
				//htmlContent +="<div class='labelText'>" + item.provider	+ "</div>";
				htmlContent +="<div class='newsTitle'>" + item.title	+ "</div>";
				if(item.updateDate != undefined) {
					htmlContent +="<div class='newsDate'>" + item.updateDate	+ "</div>";
				}
				htmlContent +="<div class='newsDesc'>"+ item.description + "</div>";
				htmlContent +="<div class><a href='" + item.uri + "' target='_blank'> Read More ...</a></div>";
				htmlContent +="<div><hr class='hrColor'></div>";
				htmlContent +="<div>&nbsp;</div>";				
				if(cnt == dataCount - 1){
					htmlContent +="</div>";
				}
			});
			newsContainer.append(htmlContent);
			newsObj.attachEvent();
			
		});

	},	
	loadCategories : function() {
		
		$.getJSON(GLOBAL_APP_CONTEXT + "/category/list", function(data) {
			$.each(data, function(cnt, item) {
				$("#menu-container").append(
						"<div class='category-element'><a href='javascript:newsObj.getNewsByCategory("
								+ item.categoryId + ")' class='alink'>"
								+ item.categoryName + "</a></div>");
			});

		});

		$.getJSON(GLOBAL_APP_CONTEXT + "/category/default", function(data) {
			newsObj.getNewsByCategory(data.categoryId);
		});
	},attachEvent : function(){
		$(".titleDiv").unbind().click(function(){
			$(this).next().toggle("slow");
			$(this).toggleClass(function(){
				if($(this).hasClass('collapsibleDiv_open')){
					return "collapsibleDiv_close";
				}
				else{
					return "collapsibleDiv_open";
				}
			});
			
		});
	}

};

var newsObj = com.jay.newsfiddle.news;
var pageId = "News";
$(document).ready(newsObj.loadCategories());
