package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dto.form.CarForm;

public class CarValidator implements Validator {
	

	@Override
	public boolean supports(Class<?> clazz) {
		return CarForm.class.equals(clazz);
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		CarForm carForm = (CarForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		
	}

}
