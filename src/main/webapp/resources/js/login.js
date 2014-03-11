com.jay.newsfiddle.login = {
	validateSignup : function() {
		var categoryForm = $('form[name="categoryForm"]');

		var username = $("input[name='username']");
		var password1 = $("input[name='password1']");
		var password2 = $("input[name='password2']");

		var hasError = true;
		if (username.val().length <= 3) {
			username.addClass('errorText');
			username.addClass('inputError');
			hasError = true;
		} else {
			username.removeClass('errorText');
			username.removeClass('inputError');
		}

		if (password1.val().length <= 7) {
			password1.addClass('errorText');
			password1.addClass('inputError');
			hasError = true;
		} else {
			password1.removeClass('errorText');
			password1.removeClass('inputError');
		}
		
		if(password2.val().length<=7 || password2 !== password1){
			password2.addClass('errorText');
			password2.addClass('inputError');
			hasError = true;
		}
		else{
			password2.removeClass('errorText');
			password2.removeClass('inputError');
		}
		
		if(!hasError){
			signupForm.attr('action', GLOBAL_APP_CONTEXT + '/login/signup');
			singupForm.submit();
		}

	}
};

loginObj = com.jay.newsfiddle.login;