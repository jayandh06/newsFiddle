com.company.rssfiddle.js.signup = {
		
		attachEvent : function(){
			
		},
		load: function(){
			$("#signup-submit-button").button();
			$("#signup-clear-button").button();
			
			$("#signup-container").dialog({
				autoOpen: false,
				title : 'RSSFiddle - New User Signup',
				width : 650,
				modal : true,
				close : function() {
					signupObj.closeSignup();
				}
			});
		},
		showSignup : function(){
			$("#login-container").dialog("close");
			$("#signup-container").dialog("open");
		},
		closeSignup : function(){
			$("#signup-container").dialog("close");
		},
		validateSignup : function() {
			//var signupForm = $('form[name="signupForm"]');

			var signupUsername = $("input[name='signupUsername']");
			var signupUsernameInfo = $("#signupUsernameInfo");
			var password1 = $("input[name='password1']");
			var password1Info = $("#password1Info");
			var password2 = $("input[name='password2']");
			var password2Info = $("#password2Info");

			var hasError = false;
			if (signupUsername.val().length <= 3) {
				signupUsernameInfo.addClass('errorText');
				signupUsername.addClass('inputError');
				hasError = true;
			} else {
				signupUsernameInfo.removeClass('errorText');
				signupUsername.removeClass('inputError');
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
				//signupForm.attr('action', GLOBAL_APP_CONTEXT + '/login/signup');
				$.ajax({
					url : GLOBAL_APP_CONTEXT +"/login/signup",
					data : $("form[name='signupForm']").serialize(),
					dataType : 'JSON',
					type:'POST',				
					success : function(data) {
						if (data.valid) {
							$("#signup-container").dialog("close");
							signupObj.clearSignup();
							GLOBAL_HAS_USERSESSION = true;						
						}
						else{
							$("#signup-message-container").html(data.message);
						}
						console.log(data);
					},
					error : function(data,textStatus,error){
						
						console.log('error :' + data);
					}
				});
				//signupForm.submit();
			}

		},
		clearSignup : function() {
			var signupUsername = $("input[name='signupUsername']");
			var signupUsernameInfo = $("#signupUsernameInfo");
			var password1 = $("input[name='password1']");
			var password1Info = $("#password1Info");
			var password2 = $("input[name='password2']");
			var password2Info = $("#password2Info");
			
			signupUsernameInfo.removeClass('errorText');
			signupUsername.removeClass('inputError');
			
			password1Info.removeClass('errorText');
			password1.removeClass('inputError');
			
			password2Info.removeClass('errorText');
			password2.removeClass('inputError');
			
			$("#signup-message-container").html("");
			signupUsername.val("");
			password1.val("");
			password2.val("");

		}
		
};
var signupObj = com.company.rssfiddle.js.signup;