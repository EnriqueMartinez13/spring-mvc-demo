package com.mvc.spring;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// Agregar InitBinder para recortar una String
	// Procesa todo el string
	// Remover los espacios en blanco
	// Resolver el problema de validacion
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		// Remueve los espacios en blanco 
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model themodel) {
		
		themodel.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer theCustomer, 
			BindingResult theBindingResult) {
		
		System.out.println("Last Name: |" + theCustomer.getLastName() + "|");
		
		// Mostrando el error de distmatch del campo insertado en el formulario
		System.out.println("Binding result: " + theBindingResult);
		
		System.out.println("\n\n\n\n");
		
		if(theBindingResult.hasErrors()) {
			return "customer-form";
			// return "redirect:/customer/showForm";
		}else {
			return "customer-confirmation";
		}
	}
}
