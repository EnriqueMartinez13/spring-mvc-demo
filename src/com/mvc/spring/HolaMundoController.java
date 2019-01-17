package com.mvc.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello") // Mapeo padre
public class HolaMundoController {
	
	// Metodo para mostrar el formulario
	@RequestMapping("/showForm")  // Mapeo hijo o submapeo
	public String showForm() {
		return "helloworld-form"; // vista
	}
	
	// Metodo para mostrar los escrito en el formulario
	@RequestMapping("/processForm") // processForm es procesar los datos del form
	public String processForm() {
		return "helloworld"; // vista
	}
	
	// Leer datos del formulario y
	// agregarlos al modelo las veces que sean
	@RequestMapping("/processFormVersionTwo") 
	public String AgregarAlModelo2(HttpServletRequest request, Model model) {
		
		// Leer los datos del request form
		String nombre = request.getParameter("studentName");
		
		// Convertir el nombre a Mayusculas
		nombre = nombre.toUpperCase();
		
		// Crear un mensaje
		String result = "Hola " + nombre;
		
		// Agregar mensaje al Modelo
		model.addAttribute("message", result);
		return "helloworld";
	}
	
	// Usando Request Params en vez de getParameter
	// https://www.udemy.com/spring-hibernate-tutorial/learn/v4/questions/3987880
	@RequestMapping("/processFormVersionThree") 
	public String AgregarAlModelo3(@RequestParam("studentName") String nombre, Model model) {
		
		// Convertir el nombre a Mayusculas
		nombre = nombre.toUpperCase();
		
		// Crear un mensaje
		String result = "Hey! bro from v3 " + nombre;
		
		// Agregar mensaje al Modelo
		model.addAttribute("message", result);
		return "helloworld";
	}
	
	
	// Posibles problemas y soluciones
	
	// Regresar a la pagina home
	// https://www.udemy.com/spring-hibernate-tutorial/learn/v4/t/lecture/7218630?start=0
	
	// La url cambia de jsp a un form action
	// https://www.udemy.com/spring-hibernate-tutorial/learn/v4/t/lecture/7218630?start=0
	
	// Agregar mensajes de log
	// https://www.udemy.com/spring-hibernate-tutorial/learn/v4/t/lecture/12128430?start=0
	
}
