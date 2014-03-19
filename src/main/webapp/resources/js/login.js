com.jay.newsfiddle.login = {
	clearLogin : function() {
		var username = $("input[name='username']");
		var password = $("input[name='password']");

		username.val("");
		password.val("");

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
			console.log('Good to see you, ' + response.name
					+ '.');
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

var loginObj = com.jay.newsfiddle.login;
$(document).ready(function() {
	$.ajaxSetup({
		cache : true
	});
	$.getScript('//connect.facebook.net/en_UK/all.js', function() {
		FB.init({
			appId : '705901259456455',
		});
		$('#loginbutton,#feedbutton').removeAttr('disabled');
		
	});
});