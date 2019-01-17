package com.mvc.spring.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD }) // Se puede aplicar en Metodos y campos
@Retention(RetentionPolicy.RUNTIME) // Por cuanto tiempo estará existiendo la anotacion, ----> Lo que dure la ejecucion
public @interface CourseCode {
	
	// Define default course code
	public String[] value() default {"LUV"};
	
	// Define default error message
	public String message() default "Debe de comenzar con LUV";
	// Define default groups
	public Class<?>[] groups() default {};
	// Define default payloads
	public Class<? extends Payload>[] payload() default {};
	
}
