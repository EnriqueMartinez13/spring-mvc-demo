package com.mvc.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{
	
	private String[] coursePrefix;
	

	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, 
			ConstraintValidatorContext theConstraintValidatorContext) {
		
		boolean result = false;
		
		if(theCode != null) {
			// En caso de tener un solo prefijo
			// result = theCode.toUpperCase().startsWith(coursePrefix.toUpperCase());
			
			// En caso de tener varios Prefijos
			for(String tempPrefix: coursePrefix) {
				result = theCode.toUpperCase().startsWith(tempPrefix.toUpperCase());
				
				if(result) {
					break;
				}
			}
		}else {
			result = true;
		}
		
		return result;
	}

}
