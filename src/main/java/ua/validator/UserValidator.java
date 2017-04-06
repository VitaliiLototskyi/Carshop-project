package ua.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.User;
import ua.service.UserService;

public class UserValidator implements Validator {
	private final UserService userService;
	 private static final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			 + "+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private final Pattern pattern = Pattern
			.compile(emailPattern);

	public UserValidator(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "",
				"Name can`t be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "",
				"Password can`t be empty");
		if (userService.findByName(user.getUsername()) != null) {
			errors.rejectValue("username", "", "Name already exist");
		}
		if ( !pattern.matcher(user.getEmail()).matches()){
			errors.rejectValue("email", "", "Email is not valid");
		}
		
	}

}
