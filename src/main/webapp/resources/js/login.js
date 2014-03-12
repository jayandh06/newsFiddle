com.jay.newsfiddle.login = {
	validateSignup : function() {
		var signupForm = $('form[name="signupForm"]');

		var username = $("input[name='username']");
		var usernameInfo = $("#usernameInfo");
		var password1 = $("input[name='password1']");
		var password1Info = $("#password1Info")
		var password2 = $("input[name='password2']");
		var password2Info = $("#password2Info");

		var hasError = true;
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
			singupForm.submit();
		}

	}
};

loginObj = com.jay.newsfiddle.login;