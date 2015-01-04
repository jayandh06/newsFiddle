/**
 * 
 */

//Namespace declaration
var com = com || {};

com.company = {};
com.company.rssfiddle = {};
com.company.rssfiddle.js = {};
com.company.rssfiddle.js.main = function() {
	
};
com.company.rssfiddle.js.main.prototype = {
	load:function() {
		categoryObj.loadFeedCategories();
		tabObj.attachEvent();
		headerObj.attachEvent();
		loginObj.load();
		signupObj.load();
	}
	

};

var mainObj = new com.company.rssfiddle.js.main();


