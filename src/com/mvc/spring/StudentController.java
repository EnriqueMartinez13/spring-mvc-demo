package com.mvc.spring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/student")
public class StudentController {
	
	// Hacemos referencia al archivo de configuracion precargado
	@Value("#{countryOptions}") 
	private Map<String, String> countryOptions;
	
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		// Crear objeto Student
		Student theStudent = new Student();
		
		// Agregar el objeto student al model
		model.addAttribute("student", theStudent);
		
		// Agregar los paises a modelo
	    model.addAttribute("theCountryOptions", countryOptions); 
	    
		
		return "student-form";
	}
	
	
	@RequestMapping("/processForm") // Action del Form y aqui recivimos el objeto student
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		// log the input data
		System.out.println("Student: " + theStudent.getFirstName()
				+ " " + theStudent.getLastName());
		
		return "student-confirmation";
	}
	
	
	// Podemos usar accesos directos a nuestras clases de entidades, en el ejercicio de arriba
	// no usamos el objeto theStudent, si no el objeto que apunta a la clase Student y al metodo get
	// https://www.udemy.com/spring-hibernate-tutorial/learn/v4/questions/4064252
}
