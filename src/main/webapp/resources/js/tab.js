/***** Header *****/
com.company.rssfiddle.js.tab = function() {
	
};

com.company.rssfiddle.js.tab.prototype = {
	attachEvent : function() {
		var tabContainerExpWidth = 250;
		var tabContainerColWidth = 50;
		
		$("#tab-login-button").button().click(function() {
					loginObj.showLogin();
				});
		$("#tab-signout-button").button().click(function() {
					loginObj.signout();
				});
		$("#tab-container").mouseover(function(){
			if($("#tab-container").width() == tabContainerColWidth) {
				$(this).stop().animate({
					'width' : '+='+tabContainerExpWidth+'px'
				});
				$("#page-container").stop().animate({
					'marginLeft' : '+='+tabContainerExpWidth+'px'
				});
				$("#tab-arrow").hide(1000);
				if(GLOBAL_HAS_USERSESSION){
					$("#signout-tab").show(600);
					$("#category-tab").show(600);
				}
				else{
					$("#login-tab").show(600);
				}
			}
		}).mouseleave(function(){
			if($("#tab-container").width() == (tabContainerExpWidth + tabContainerColWidth)) {
				$(this).stop().animate({
					'width' : '-='+tabContainerExpWidth+'px'
				});
				$("#page-container").stop().animate({
					'marginLeft' : '-='+tabContainerExpWidth+'px'
				});
				$("#tab-arrow").show(1000);
				if(GLOBAL_HAS_USERSESSION){
					$("#signout-tab").hide();
					$("#category-tab").hide();
				}
				else{
					$("#login-tab").hide();
				}
			}
		});
		
	},
	findDone : function(result) {
		$("#feeds-container").empty();
		// Make sure we didn't get an error.
		if (!result.error) {
			// Get content div
			var content = $("#feeds-container");
			var query =  $("#top-search-text").val();
			var html = '';
			html+= '<div class="titleDiv"><div class="titleText"> Search Result - ' + query +' </div></div>';
			
			// Loop through the results and print out the title of the feed and link to the url.
			for ( var i = 0; i < result.entries.length; i++) {
				var entry = result.entries[i];
				var title = entry.title;
				title = title.replace('"','');
				title = title.replace('<b>','');
				title = title.replace('</b>','');
				html += '<div class="feed-block">';				
				html += '<div class="feedsTitle"><a href=\'javascript:feedsObj.showFeedUrl("'+entry.url+'","'+title+'")\'>' + entry.title + '</a></div>';
				html += '<div class="feedsDesc">' + entry.contentSnippet + '</div>';
				html += '<div class="feedsFollow"><button class="fiddleFollow" data-url="'+  entry.url + '">Fiddle+</button></div></div>';
			}
			content.html(html);
			$(".fiddleFollow").button();
			$("#top-search-text").val('Search feed');
		}
	}
	

};
var tabObj = new com.company.rssfiddle.js.tab();