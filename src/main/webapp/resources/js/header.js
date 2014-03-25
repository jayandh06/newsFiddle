com.company.rssfiddle.js.header = {

	attachEvent : function() {
		$("#search-text").keypress(function(event){
			var keyCode = event.keyCode || event.which;
			if(keyCode == 13){
				console.log("enter key pressed");
			}
		}).on('click',function(){
			if($(this).val() == "Search feed") {
				$(this).val("");
			}
		});
		
	}

};
var headerObj = com.company.rssfiddle.js.header;
$(document).ready(headerObj.attachEvent());
