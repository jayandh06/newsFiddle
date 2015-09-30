/***** Login *****/
com.company.rssfiddle.js.login = function() {
	
};

com.company.rssfiddle.js.login.prototype = {
	clearLogin : function() {
		var loginUsername = $("input[name='loginUsername']");
		var loginUsernameInfo = $("#loginUsernameInfo");

		var password = $("input[name='password']");
		var passwordInfo = $("#passwordInfo");
		
		loginUsernameInfo.text("");
		loginUsernameInfo.removeClass("errorText");
		
		passwordInfo.text("");
		passwordInfo.removeClass("errorText");
		
		$("#login-message-container").html("");
		
		loginUsername.val("");
		password.val("");

	},
	load : function(){
		$("#login-submit-button").button();
		$("#login-clear-button").button();
		$("#login-signup-button").button();
		$("#login-fb-button").button();
		$("#login-container").dialog({
			autoOpen: false,
			title : 'RSSFiddle Login',
			width : 650,
			modal : true,
			close : function() {
				loginObj.closeLogin();
			}
		});
	},
	validateLogin : function() {
		//var loginForm = $('form[name="loginForm"]');

		var loginUsername = $("input[name='loginUsername']");
		var loginUsernameInfo = $("#loginUsernameInfo");

		var password = $("input[name='password']");
		var passwordInfo = $("#passwordInfo");

		var hasError = false;
		if (loginUsername.val().length <= 5) {
			loginUsernameInfo.text("Invalid Username");
			loginUsernameInfo.addClass("errorText");
			hasError = true;
		} else {
			loginUsernameInfo.text("");
			loginUsernameInfo.removeClass("errorText");
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
		
			$.ajax({
				url : GLOBAL_APP_CONTEXT +"/login/validate",
				data : $("form[name='loginForm']").serialize(),
				dataType : 'JSON',
				type:'POST',				
				success : function(data) {
					if (data.valid) {
						$("#login-container").dialog("close");
						loginObj.clearLogin();
						GLOBAL_HAS_USERSESSION = true;						
					}
					else{
						$("#login-message-container").html(data.message);						
					}
					console.log(data);
				},
				error : function(data,textStatus,error){
					
					console.log('error :' + data);
				}
			});
			
		}

	},
	
	signout : function(){
		$.ajax({
				url : GLOBAL_APP_CONTEXT +"/login/signout",
				dataType : 'JSON',
				success : function(data) {
					if (data.valid) {						
						$("#signout-tab").hide();
						$("#category-tab").hide();
						$("#login-tab").show();
						GLOBAL_HAS_USERSESSION = false;						
					}
					console.log(data);
				},
				error : function(data,textStatus,error){
					console.log('error :' + data);
				}
			});
	},
	showLogin : function(modal_id) {
		$("#login-container").dialog("open");
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
			});
			
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
var loginObj = new com.company.rssfiddle.js.login();