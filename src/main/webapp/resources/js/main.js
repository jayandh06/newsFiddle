/**
 * 
 */

//Namespace declaration
var com = com || {};

com.company = {};
com.company.rssfiddle = {};
com.company.rssfiddle.js = {};
var mainObj = com.company.rssfiddle.js;

$(document).ready(function() {
var appId;
	
	$.getJSON(GLOBAL_APP_CONTEXT + '/login/appId',function(data){
			appId = data.appId;
	});
	
	$.getScript('//connect.facebook.net/en_UK/all.js', function() {
		FB.init({
			appId : appId,
		});
		$('#loginbutton,#feedbutton').removeAttr('disabled');
		
	});  

	//categoryObj.loadCategories();
	categoryObj.loadFeedCategories();
	tabObj.attachEvent();
	headerObj.attachEvent();
	loginObj.load();
	signupObj.load();
});
