com.jay.newsfiddle.profile = {
	validateProfile : function(action) {
		if (action == 'create' || action == 'update') {
			var profileForm = $("form[name='profileForm']");

			var firstName = $("input[name='firstName']");
			var firstNameInfo = $("#firstNameInfo");

			var lastName = $("input[name='lastName']");
			var lastNameInfo = $("#lastNameInfo");

			var primaryEmail = $("input[name='primaryEmail']");
			var primaryEmailInfo = $("#primaryEmailInfo");

			var zipCode = $("input[name='zipCode']");
			var zipCodeInfo = $("#zipCodeInfo");

			var hasError = false;

			if (firstName.val().length <= 0) {
				firstNameInfo.addClass('errorText');
				firstName.addClass('inputError');
				hasError = true;
			} else {
				firstNameInfo.removeClass('errorText');
				firstName.removeClass('inputError');
			}

			if (lastName.val().length <= 0) {
				lastNameInfo.addClass('errorText');
				lastName.addClass('inputError');
				hasError = true;
			} else {
				lastNameInfo.removeClass('errorText');
				lastName.removeClass('inputError');
			}

			if (primaryEmail.val().length <= 0) {
				primaryEmailInfo.addClass('errorText');
				primaryEmail.addClass('inputError');
				hasError = true;
			} else {
				primaryEmailInfo.removeClass('errorText');
				primaryEmail.removeClass('inputError');
			}

			if (zipCode.val().length <= 0) {
				zipCodeInfo.addClass('errorText');
				zipCode.addClass('inputError');
				hasError = true;
			} else {
				zipCodeInfo.removeClass('errorText');
				zipCode.removeClass('inputError');
			}

			if (!hasError) {
				
				profileForm.attr('action', GLOBAL_APP_CONTEXT
						+ '/user/'+action+'Profile');
				profileForm.submit();
			}
		}

	},
	retrieveProfile : function() {

		$.when($.getJSON(GLOBAL_APP_CONTEXT + '/user/countryList'), $.getJSON(GLOBAL_APP_CONTEXT + '/user/retrieveProfile')).then(function(data1,data2){
				//Populate profile details
				var countrySelect = $("select[name='countryId']");
				var firstName = $("input[name='firstName']");
				var middleName = $("input[name='middleName']");
				var lastName = $("input[name='lastName']");
				var primaryEmail = $("input[name='primaryEmail']");
				var zipCode = $("input[name='zipCode']");

				$.each(data1[0], function(cnt, item) {
					countrySelect.append("<option value='" + item.countryId + "'>"
							+ item.countryName + "</option>");
				});
				
				//Reload select
				countrySelect = $("select[name='countryId'] option");
				if (data2[0] !== "") {					
					//set the right country
					countrySelect.filter(function() {
						return $(this).val() == data2[0].countryId;
					}).attr('selected', true);
			
					firstName.val(data2[0].firstName);
					middleName.val(data2[0].middleName);
					lastName.val(data2[0].lastName);
					primaryEmail.val(data2[0].emailId);
					zipCode.val(data2[0].zipCode);
				}
		});
			
		}
};

var profileObj = com.jay.newsfiddle.profile;
$(document).ready(profileObj.retrieveProfile());