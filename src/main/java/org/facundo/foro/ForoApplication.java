package org.facundo.foro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForoApplication {

	public static void main(String[] args) {
		try{
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver cargado con exito");
		}
		catch(ClassNotFoundException e){
			System.out.println("We dont can belive in god");
		}
		SpringApplication.run(ForoApplication.class, args);

	}

}
