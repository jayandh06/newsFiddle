com.company.rssfiddle.js.header = {

	attachEvent : function() {
		$("#search-text").keypress(function(event){
			var keyCode = event.keyCode || event.which;
			if(keyCode == 13){
				console.log("enter key pressed");
				var query = $(this).val();
				if(query.length >= 4){
					google.feeds.findFeeds(query, headerObj.findDone);
				}
				else{
					console.log('Search text very small');
				}
			}
		}).on('click',function(){
			if($(this).val() == "Search feed") {
				$(this).val("");
			}
		});
		
		$("#tab-container").mouseover(function(){
			if($("#tab-container").width() == 50) {
				$(this).stop().animate({
					'width' : '+=300px'
				});
				$("#page-container").stop().animate({
					'marginLeft' : '+=300px'
				});
				$("#tab-arrow").hide();				
			}
		}).mouseleave(function(){
			if($("#tab-container").width() ==350) {
				$(this).stop().animate({
					'width' : '-=300px'
				});
				$("#page-container").stop().animate({
					'marginLeft' : '-=300px'
				});
				$("#tab-arrow").show();			
			}
		});
		
	},
	findDone: function (result) {
		  $("#feeds-container").empty();
		  // Make sure we didn't get an error.
		  if (!result.error) {
		    // Get content div
		    var content = document.getElementById('feeds-container');
		    var html = '';

		    // Loop through the results and print out the title of the feed and link to
		    // the url.
		    for (var i = 0; i < result.entries.length; i++) {
		      var entry = result.entries[i];
		      html += '<p>'+entry.contentSnippet+'<br><a href="' + entry.url + '">' + entry.title + '</a></p><hr>';
		    }
		    content.innerHTML = html;
		  }
		}
	

};
var headerObj = com.company.rssfiddle.js.header;
$(document).ready(headerObj.attachEvent());
