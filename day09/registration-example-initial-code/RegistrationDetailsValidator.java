package com.cdac.validator;

import java.util.ArrayList;
import java.util.List;

import com.cdac.model.RegistrationDetails;

public class RegistrationDetailsValidator {

	public List<String> validate(RegistrationDetails registrationForm) {
		List<String> errors = new ArrayList<>();
		
		
		//TODO : Use regexp for validation
		if(registrationForm.getName().length() < 2)
			errors.add("Name should contain atleast 2 characters");
		if(registrationForm.getPassword().length() < 8)
			errors.add("Password should contain atleast 8 characters");
		
		return errors;
	}

}
