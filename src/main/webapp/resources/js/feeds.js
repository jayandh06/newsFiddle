/***** Feed *****/
com.company.rssfiddle.js.feeds = function() {
	
};
com.company.rssfiddle.js.feeds.prototype = {	
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
	getfeedsByUrl : function(urlString,company) {
		var feedsContainer = $("#feeds-container");		
		
		$.when($.getJSON(GLOBAL_APP_CONTEXT + "/synd/feedsByUrl",{"urlString":urlString,"company":company})).then(function(data) {
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
			feedsContainer.empty();
			feedsContainer.append(htmlContent);
			feedsObj.attachEvent();
			
		});

	},
	getfeedsByName : function(name) {
		$("#categoryList-container").hide();
		google.feeds.findFeeds(name, tabObj.findDone);
	},
	attachEvent : function(){
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
	},
	showFeedPage : function() {
		
		$.ajax( {
			url: GLOBAL_APP_CONTEXT + "/synd/feeds'",
			success : function(){
				console.log("Feeds Success");
			},
			error : function(){
				console.log("Feeds failed");
			}
		
		});
		
	},
	showFeedUrl : function(url,company) {
		//feedsObj.showFeedPage();
		feedsObj.getfeedsByUrl(url, company);
	}

};
var feedsObj = new com.company.rssfiddle.js.feeds();