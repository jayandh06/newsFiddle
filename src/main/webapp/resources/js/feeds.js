com.company.rssfiddle.js.feeds = {
		
	getfeedsByCategory : function(categoryId){
		var feedsContainer = $("#feeds-container");
		feedsContainer.empty();
		$.when($.getJSON(GLOBAL_APP_CONTEXT + "/categoryDetail/list/" + categoryId)).then(function(data) {
			$.each(data,function(cnt,item){
				feedsObj.getfeedsByCategoryDetail(item.categoryDetailId);
			});	
			
		});
		
	},	
	
	getfeedsByCategoryDetail : function(categoryDetailId) {
		var feedsContainer = $("#feeds-container");		
		
		$.when($.getJSON(GLOBAL_APP_CONTEXT + "/synd/feeds/" + categoryDetailId)).then(function(data) {
			var dataCount = data.length;		
			var htmlContent = '';
			$.each(data, function(cnt, item) {
				if(cnt == 0) {
					htmlContent +="<div class='titleDiv collapsibleDiv_open'><div class='titleText'>" +  item.provider  + "</div><span></span></div><div class='provider-container'>";
				}
				htmlContent += "<div class='feed-block' data-url='" + item.link+"'>";
				//htmlContent +="<div class='labelText'>" + item.provider	+ "</div>";
				htmlContent +="<div class='feedsTitle'>" + item.title	+ "</div>";
				if(item.updateDate != undefined) {
					htmlContent +="<div class='feedsDate'>" + item.updateDate	+ "</div>";
				}
				htmlContent +="<div class='feedsDesc'>"+ item.description + "</div>";
				htmlContent += "</div>";
				if(cnt == dataCount - 1){
					htmlContent +="</div>";
				}
			});
			feedsContainer.append(htmlContent);
			feedsObj.attachEvent();
			
		});

	},	
	loadCategories : function() {
		
		$.getJSON(GLOBAL_APP_CONTEXT + "/category/list", function(data) {
			$.each(data, function(cnt, item) {
				$("#menu-container").append(
						"<div class='category-element'><a href='javascript:feedsObj.getfeedsByCategory("
								+ item.categoryId + ")' class='alink'>"
								+ item.categoryName + "</a></div>");
			});

		});

		$.getJSON(GLOBAL_APP_CONTEXT + "/category/default", function(data) {
			feedsObj.getfeedsByCategory(data.categoryId);
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
		
		$(".feed-block").unbind().click(function(){
			window.open($(this).data('url'));
			console.log($(this).data('url'));			
		}).mouseover(function(){
			$(this).addClass("active");
		}).mouseout(function(){
			$(this).removeClass("active");
		});
	}

};

var feedsObj = com.company.rssfiddle.js.feeds;
var pageId = "feeds";
$(document).ready(feedsObj.loadCategories());
