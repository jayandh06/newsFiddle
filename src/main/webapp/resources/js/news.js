
com.jay.newsfiddle.news = {
		getHotNews : function() {
			$.get(GLOBAL_APP_CONTEXT + "/synd/hotNews",function(data) {
				alert('data :' + data);
			},"json");
		}
};

var news = com.jay.newsfiddle.news;

$(document).ready(news.getHotNews());