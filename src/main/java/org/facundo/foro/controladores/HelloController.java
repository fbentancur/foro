package org.facundo.foro.controladores;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController{
	@GetMapping("/serverbienverga")
	public String stringa(){
		String Holamundo = "<h1>Holiwis</h1>";
		return Holamundo;
	}
	@GetMapping("/")
	public String devolverInicio(){
		String inicio = "<h1>Holiwis2</h1>";
		return inicio;
	}
}
