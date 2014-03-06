com.jay.newsfiddle.news = {
	getHotNews : function() {
		$.getJSON(GLOBAL_APP_CONTEXT + "/synd/hotNews", function(data) {
			// $("#newsTemplate").tmpl(data).appendTo("#newsContainer",data);
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
								+ "'> Link to original page</a></div>");
				$("#newsContainer").append("<div><hr class='hrColor'></div>");
				$("#newsContainer").append("<div>&nbsp;</div>");
				$("#newsContainer").append("</div>");
			});
		}, "json");
	},
};

var news = com.jay.newsfiddle.news;

$(document).ready(news.getHotNews());
