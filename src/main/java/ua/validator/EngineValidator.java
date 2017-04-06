package ua.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dto.form.EngineForm;
import ua.service.EngineService;

public class EngineValidator implements Validator {
	private final static Pattern PATTERN = Pattern.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2})$");


	@Override
	public boolean supports(Class<?> clazz) {
		return EngineForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		EngineForm engineForm = (EngineForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sweptVolume", "", "Can`t be empty");
		
	}

}
