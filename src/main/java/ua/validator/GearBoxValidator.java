package ua.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dto.form.GearBoxForm;
import ua.entity.GearBox;

public class GearBoxValidator implements Validator {
	private final static Pattern PATTERN = Pattern.compile("^([0-9]{1,18})$");
	@Override
	public boolean supports(Class<?> clazz) {
		return GearBoxForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		GearBoxForm gearBoxForm = (GearBoxForm)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "count", "", "Can`t be empty");
	}

}
