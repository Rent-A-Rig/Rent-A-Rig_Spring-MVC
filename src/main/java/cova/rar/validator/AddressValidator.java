package cova.rar.validator;

import javax.validation.ConstraintViolation;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import cova.fss.entities.Address;
import cova.rar.entities.User;

import org.springframework.validation.Validator;

public class AddressValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return Address.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors err) {
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "line1", "err.line1", "Line 1 is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "line2", "err.line2", "Line 2 (city) is required");

		ValidationUtils.rejectIfEmptyOrWhitespace(err, "state", "error.state", "State is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "zip", "error.xip", "Zipcode is required.");
		
		Address add = (Address) obj;

		Pattern lineOnePattern = Pattern.compile("^[0-9]");
		if (!(lineOnePattern.matcher(add.getLine1()).matches())) {
			err.rejectValue("line1", "Address.getLine1.invalid",
					"Invalid format! Please enter format like #### street name");
		}
		
		Pattern statePattern = Pattern.compile("(^[A-Za-z]{2}$)");
		if (!(statePattern.matcher(add.getState()).matches())) {
			err.rejectValue("state", "Address.getState.invalid", "Invalid State format!");
		}

		Pattern zipPattern = Pattern.compile("^(?!0{5})(?!0{4})[0-9]{5}$");
		if (!(zipPattern.matcher(add.getZip()).matches())) {
			err.rejectValue("zip", "Address.getZip.invalid",
					"Invalid zip format! Please enter format like 00000");
		}
	}

}
