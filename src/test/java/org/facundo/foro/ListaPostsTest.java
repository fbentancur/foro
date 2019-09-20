package org.facundo.foro;
import org.junit.Test;
public class ListaPostsTest{

 	@Test
	public void agregarYBuscar(){
		Post post = new Post();
		post.titulo ="Holamundo";
		post.cuerpo = "Hello ma negga";
		ListaPosts lista = new ListaPosts();
		lista.agregar(post);
		int largo = lista.mostrarLargo();
		System.out.println(largo);
	}
}
