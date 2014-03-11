com.jay.newsfiddle.news = {
	getHotNews : function(categoryId) {
		
		$.getJSON(GLOBAL_APP_CONTEXT + "/synd/hotNews/"+categoryId, function(data) {
			
			$("#newsContainer").empty();
			$.each(data, function(cnt, item) {
				
				$("#newsContainer").append("<div class=''>");
				$("#newsContainer").append(
						"<div class='newsTitle'>" + item.title + "</div>");
				$("#newsContainer").append(
						"<div class='newsDate'>" + item.updateDate + "</div>");
				$("#newsContainer").append(
						"<div class='newsDesc'>" + item.description + "</div>");
				$("#newsContainer").append(
						"<div class><a href='" + item.uri
								+ "' target='_blank'> Read More ...</a></div>");
				$("#newsContainer").append("<div><hr class='hrColor'></div>");
				$("#newsContainer").append("<div>&nbsp;</div>");
				$("#newsContainer").append("</div>");
			});
		}, "json");
		
		
	},
	loadCategories : function(){
		$.getJSON(GLOBAL_APP_CONTEXT +"/category/list",function(data) {			
			$.each(data,function(cnt,item){
				$("#category-menucontainer").append("<div class='category-element'><a href='javascript:news.getHotNews("+item.categoryId+")' class='alink'>"+item.categoryName+"</a></div>");
			});
			
		});
		
		$.getJSON(GLOBAL_APP_CONTEXT +"/synd/defaultCategory",function(data) {			
			news.getHotNews(data.categoryId);			
		});
	}
	
};

var news = com.jay.newsfiddle.news;
var pageId ="News";
$(document).ready(news.loadCategories());
