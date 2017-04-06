package ua.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dto.form.ModelForm;

public class ModelValidator implements Validator{
	private final static Pattern PATTERN = Pattern.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2})$");
	@Override
	public boolean supports(Class<?> clazz) {
		return ModelForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ModelForm modelForm = (ModelForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
//		if(modelService.findOne(model.getName())!=null){
//			errors.rejectValue("name", "", "Already exist");
//		}
	}

}
