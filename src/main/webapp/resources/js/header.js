com.company.rssfiddle.js.header = {
	searchClick : function(event) {
		var query = $("#top-search-text").val();
		if(query.length >= 4){
			google.feeds.findFeeds(query, tabObj.findDone);			
		}
		else{
			console.log('Search text very small');
		}
	},
	attachEvent : function(){
		$("#top-search-button").button().click(headerObj.searchClick);
		
		$("#top-search-text").keypress(function(event){
			var keyCode = event.keyCode || event.which;
			if(keyCode == 13){
				console.log("enter key pressed");
				var query = $(this).val();
				if(query.length >= 4){
					google.feeds.findFeeds(query, tabObj.findDone);
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
		
	
		
	}
	
};
var headerObj = com.company.rssfiddle.js.header;


