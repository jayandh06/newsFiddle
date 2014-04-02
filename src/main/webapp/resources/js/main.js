/**
 * 
 */

//Namespace declaration
var com = com || {};

com.company = {};
com.company.rssfiddle = {};
com.company.rssfiddle.js = {};
var mainObj = com.company.rssfiddle.js;

jQuery.fn.center = function () {
    this.css("position","absolute");
    this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) + 
                                                $(window).scrollTop()) + "px");
    this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) + 
                                                $(window).scrollLeft()) + "px");
    return this;
}


/***** Utility *****/
com.company.rssfiddle.js.util = {
		
};
var utilObj = com.company.rssfiddle.js.util;

/***** Header *****/
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
		$("#tab-login-button").button().click(function() {
					loginObj.showLogin()
				});
		$("#tab-container").mouseover(function(){
			if($("#tab-container").width() == 50) {
				$(this).stop().animate({
					'width' : '+=300px'
				});
				$("#page-container").stop().animate({
					'marginLeft' : '+=300px'
				});
				$("#tab-arrow").hide(1000);	
				$("#login-tab").show(600);
			}
		}).mouseleave(function(){
			if($("#tab-container").width() ==350) {
				$(this).stop().animate({
					'width' : '-=300px'
				});
				$("#page-container").stop().animate({
					'marginLeft' : '-=300px'
				});
				$("#tab-arrow").show(1000);
				$("#login-tab").hide();
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
	
/***** Feed *****/
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


	
	
/***** Login *****/
com.company.rssfiddle.js.login = {
		clearLogin : function() {
			var username = $("input[name='username']");
		var password = $("input[name='password']");

		username.val("");
		password.val("");

	},
	clearSignup : function() {
		var username = $("input[name='username']");
		var password1 = $("input[name='password1']");
		var password2 = $("input[name='password2']");
		username.val("");
		password1.val("");
		password2.val("");

	},
	validateLogin : function() {
		var loginForm = $('form[name="loginForm"]');

		var username = $("input[name='username']");
		var usernameInfo = $("#usernameInfo");

		var password = $("input[name='password']");
		var passwordInfo = $("#passwordInfo");

		var hasError = false;
		if (username.val().length <= 5) {
			usernameInfo.text("Invalid Username");
			usernameInfo.addClass("errorText");
			hasError = true;
		} else {
			usernameInfo.text("");
			usernameInfo.removeClass("errorText");
		}

		if (password.val().length <= 7) {
			passwordInfo.text("Invalid Password");
			passwordInfo.addClass("errorText");
			hasError = true;
		} else {
			passwordInfo.text("");
			passwordInfo.removeClass("errorText");
		}

		if (!hasError) {
			loginForm.attr('action', GLOBAL_APP_CONTEXT + '/login/validate');
			loginForm.submit();
		}

	},
	validateSignup : function() {
		var signupForm = $('form[name="signupForm"]');

		var username = $("input[name='username']");
		var usernameInfo = $("#usernameInfo");
		var password1 = $("input[name='password1']");
		var password1Info = $("#password1Info")
		var password2 = $("input[name='password2']");
		var password2Info = $("#password2Info");

		var hasError = false;
		if (username.val().length <= 3) {
			usernameInfo.addClass('errorText');
			username.addClass('inputError');
			hasError = true;
		} else {
			usernameInfo.removeClass('errorText');
			username.removeClass('inputError');
		}

		if (password1.val().length <= 7) {
			password1Info.addClass('errorText');
			password1.addClass('inputError');
			hasError = true;
		} else {
			password1Info.removeClass('errorText');
			password1.removeClass('inputError');
		}

		if (password2.val().length <= 7 || password2.val() !== password1.val()) {
			password2Info.addClass('errorText');
			password2.addClass('inputError');
			hasError = true;
		} else {
			password2Info.removeClass('errorText');
			password2.removeClass('inputError');
		}

		if (!hasError) {
			signupForm.attr('action', GLOBAL_APP_CONTEXT + '/login/signup');
			signupForm.submit();
		}

	},
	showLogin : function(modal_id) {
		$("#login-container").dialog({
					title : 'RSSFiddle Login',
					width : 650,
					modal : true,
					close : function() {
						loginObj.closeLogin();
					}
				});				
		
		$("#login-submit-button").button();
		$("#login-clear-button").button();
		$("#login-signup-button").button();
		$("#login-fb-button").button();
	},
	closeLogin : function() {		
		$("#login-container").dialog("close");
	},
	fbLogin : function() {
		FB
				.login(function(response) {
					if (response.authResponse) {
						//console.log('Welcome!  Fetching your information.... ');					
						loginObj.fbGetUserDetails();

					} else {
						console
								.log('User cancelled login or did not fully authorize.');
					}
				},{scope:'email'});
	},
	fbGetUserDetails : function(){
		FB.api('/me', function(response) {
			var fbData = '{"id":"'+ response.id +'",' +
              '"firstName":"'+ response.first_name +'",'+
              '"lastName":"'+ response.last_name +'",'+
              '"username":"'+ response.username +'",'+
              '"gender":"'+ response.gender +'",'+
              '"email":"'+ response.email +'"'+
             '}"'; 
			
			$.ajax({
				url : GLOBAL_APP_CONTEXT + '/login/fblogin',
				type : "POST",
				data : fbData,
				contentType : 'application/json',
				dataType:'JSON',
				success : function(data){
					window.location.href = GLOBAL_APP_CONTEXT+data.redirectPage;
				}
			})
			
		});
	},
	fbGetLoginStatus : function(){
		FB.getLoginStatus(loginObj.fbLoginStatus);
	},
	fbLoginStatus : function(response) {
		if (response.status === 'connected') {
			// the user is logged in and has authenticated your
			// app, and response.authResponse supplies
			// the user's ID, a valid access token, a signed
			// request, and the time the access token
			// and signed request each expire
			var uid = response.authResponse.userID;
			var accessToken = response.authResponse.accessToken;
			loginObj.fbGetUserDetails();
		} else if (response.status === 'not_authorized') {
			// the user is logged in to Facebook,
			// but has not authenticated your app
			loginObj.fbLogin();
		} else {
			loginObj.fbLogin();
			// the user isn't logged in to Facebook.
		}
	}
};
var loginObj = com.company.rssfiddle.js.login;
	

$(document).ready(function() {
	feedsObj.loadCategories();

	$("#login-container").hide();
	headerObj.attachEvent();
});
