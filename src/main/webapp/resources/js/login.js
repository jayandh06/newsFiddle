com.jay.newsfiddle.login = {
	clearLogin : function(){
		var username = $("input[name='username']");
		var password = $("input[name='password']");
		
		username.val("");
		password.val("");
		
	},	
	validateLogin : function(){
		var loginForm = $('form[name="loginForm"]');

		var username = $("input[name='username']");
		var usernameInfo = $("#usernameInfo");
		
		
		var password = $("input[name='password']");
		var passwordInfo = $("#passwordInfo");
		
		var hasError = false;
		if(username.val().length <= 5){
			usernameInfo.text("Invalid Username");
			usernameInfo.addClass("errorText");
			hasError = true;
		}
		else{
			usernameInfo.text("");
			usernameInfo.removeClass("errorText");
		}
		
		if(password.val().length <= 7){
			passwordInfo.text("Invalid Password");
			passwordInfo.addClass("errorText");
			hasError = true;
		}
		else{
			passwordInfo.text("");
			passwordInfo.removeClass("errorText");
		}
		
		if(!hasError){
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
		
		if(password2.val().length<=7 || password2.val() !== password1.val()){
			password2Info.addClass('errorText');
			password2.addClass('inputError');
			hasError = true;
		}
		else{
			password2Info.removeClass('errorText');
			password2.removeClass('inputError');
		}
		
		if(!hasError){
			signupForm.attr('action', GLOBAL_APP_CONTEXT + '/login/signup');
			signupForm.submit();
		}

	}
};

var loginObj = com.jay.newsfiddle.login;