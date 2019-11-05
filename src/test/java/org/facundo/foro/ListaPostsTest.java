package org.facundo.foro;
import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;
import org.facundo.foro.modelos.Post;
import org.facundo.foro.estructuradedatos.ListaPosts;
public class ListaPostsTest{

 	@Test
	public void agregarYChequearLargo(){
		Post post = new Post("Holamundo", "Hello ma negga",2);
		ListaPosts<Post> lista = new ListaPosts<Post>();
		lista.add(post);
		int largo = lista.size();
		Assert.assertEquals(1, largo);
	}
	@Test
	public void agregaryBuscar(){
		Post post = new Post("Holiwis", "Holiwis2",1);
		ListaPosts<Post> lista = new ListaPosts<Post>();
		lista.add(post);
		Post resultado = lista.get(0);
		Assert.assertEquals(post, resultado);

	}
	@Test(expected = RuntimeException.class)
	public void agregaryBuscarInvalido(){
		String coso = "pete";
		ListaPosts<String> lista = new ListaPosts<String>();
		lista.add(coso);
		lista.get(-5);

	}
	@Test
	public void agregarEnElMedio(){
		ListaPosts<String> lista = new ListaPosts<String>();
		String entrada = "puto";
		String entrada2 = "sos vos";
		String entrada3 = "a kien le deci?";
		String entrada4 = "a vo gato";
		String entrada5 = "caiate bro";
		lista.add(entrada);
		lista.add(entrada2);
		lista.add(entrada3);
		lista.add(entrada4);
		lista.add(entrada5);
		lista.add(3, "Hola, vengo a cagar la alfombra");
		String valor1 = lista.get(0);
		String valor2 = lista.get(1);
		String valor3 = lista.get(2);
		String valor4 = lista.get(3);
		String valor5 = lista.get(4);
		String valor6 = lista.get(5);
		Assert.assertEquals(entrada, valor1);
		Assert.assertEquals(entrada2, valor2);
		Assert.assertEquals(entrada3, valor3);
		Assert.assertEquals("Hola, vengo a cagar la alfombra", valor4);
		Assert.assertEquals(entrada4, valor5);
		Assert.assertEquals(entrada5, valor6);

	}
	@Test
	public void addAll(){
		ArrayList<String> coleccion = new ArrayList<String>();
		coleccion.add("Holiwis");
		coleccion.add("Holiwis2");
		coleccion.add("Holiwis3");
		coleccion.add("Holiwis4");
		ListaPosts<String> lista = new ListaPosts<String>();
		lista.addAll(coleccion);
		String comparar = lista.get(0);
		String comparar2 = lista.get(1);
		String comparar3 = lista.get(2);
		String comparar4= lista.get(3);
		Assert.assertEquals("Holiwis", comparar);
		Assert.assertEquals("Holiwis2", comparar2);
		Assert.assertEquals("Holiwis3", comparar3);
		Assert.assertEquals("Holiwis4", comparar4);
	}
	@Test
	public void clear(){
		ArrayList<String> coleccion = new ArrayList<String>();
		coleccion.add("Holiwis");
		coleccion.add("Holiwis2");
		coleccion.add("Holiwis3");
		coleccion.add("Holiwis4");
		ListaPosts<String> lista = new ListaPosts<String>();
		lista.addAll(coleccion);
		lista.clear();
		int largo = lista.size();
		Assert.assertEquals(0, largo);


	}
	@Test
	public void contains(){
		ArrayList<String> coleccion = new ArrayList<String>();
		coleccion.add("Holiwis");
		coleccion.add("Holiwis2");
		coleccion.add("Holiwis3");
		coleccion.add("Holiwis4");
		ListaPosts<String> lista = new ListaPosts<String>();
		lista.addAll(coleccion);
		Assert.assertEquals(true,lista.contains("Holiwis"));
		Assert.assertEquals(false, lista.contains("puto"));
		Assert.assertEquals(true, lista.contains("Holiwis3"));
		Assert.assertEquals(true,lista.contains("Holiwis4"));
	}
	@Test
	public void containsAll(){
		Collection<String> coleccion = Arrays.asList("Holiwis", "Holiwis2", "Holiwis3", "Holiwis4");
		Collection<String> coleccion2 =Arrays.asList("Perra", "Peeerraaa");
		Collection<String> coleccion3= Arrays.asList("Holiwis", "perra");
		Collection<String> coleccion4 = Arrays.asList("Holiwis2", "Holiwis", "Holiwis4", "Holiwis3");
		ListaPosts<String> lista = new ListaPosts<String>();
		lista.addAll(coleccion);
		Assert.assertEquals(true, lista.containsAll(coleccion));
		Assert.assertEquals(false, lista.containsAll(coleccion2));
		Assert.assertEquals(false, lista.containsAll(coleccion3));
		Assert.assertEquals(true, lista.containsAll(coleccion4));
	}
	@Test
	public void addAllputo(){
		ArrayList<String> coleccion = new ArrayList<String>();
		ArrayList<String> coleccion2 = new ArrayList<String>();
		coleccion2.add("Hellowda");
		coleccion2.add("Hao");
		coleccion.add("Holiwis");
		coleccion.add("Holiwis2");
		coleccion.add("Holiwis3");
		coleccion.add("Holiwis4");
		ListaPosts<String> lista = new ListaPosts<String>();
		lista.addAll(coleccion);
		lista.addAll(2, coleccion2);
		Assert.assertEquals("Holiwis", lista.get(0));
		Assert.assertEquals("Holiwis2",lista.get(1));
		Assert.assertEquals("Hellowda", lista.get(2));
		Assert.assertEquals("Hao", lista.get(3));
		Assert.assertEquals("Holiwis3", lista.get(4));
		Assert.assertEquals("Holiwis4", lista.get(5));
	}
	@Test
	public void isEmpty(){
		ListaPosts<String> lista = new ListaPosts<String>();
		lista.add("Holis");
		Assert.assertEquals(false, lista.isEmpty());
		lista.clear();
		Assert.assertEquals(true,lista.isEmpty());
	}
	@Test
	public void size(){
		ListaPosts<String> lista = new ListaPosts<String>();
		Collection<String> coleccion = Arrays.asList("Holiwis", "Holiwis2", "Holiwis3", "Holiwis4");
		lista.addAll(coleccion);
		Assert.assertEquals(4, lista.size());
		lista.clear();
		Assert.assertEquals(0, lista.size());

	}
	@Test
	public void equals(){
		ListaPosts<String> lista = new ListaPosts<String>();
		ListaPosts<String> lista2= new ListaPosts<String>();
		lista.add("Holiwis");
		lista.add("Holiwis2");
		lista.add("Holiwis3");
		lista.add("Holiwis4");
		lista2.add("Holiwis");
		lista2.add("Holiwis2");
		lista2.add("Holiwis3");
		lista2.add("Holiwis4");
		Assert.assertEquals(true, lista.equals(lista2));
		lista2.clear();
		Assert.assertEquals(false,lista.equals(lista2));
		lista2.add("Holis");
		Assert.assertEquals(false, lista.equals(lista2));
	}
	@Test
	public void indexOf(){
		ListaPosts<String> lista = new ListaPosts<String>();
		lista.add("Holiwis");
		lista.add("Holiwis2");
		lista.add("Holiwis3");
		lista.add("Holiwis4");
		lista.add("Holiwis3");
		Assert.assertEquals(1, lista.indexOf("Holiwis2"));
		Assert.assertEquals(0, lista.indexOf("Holiwis"));
		Assert.assertEquals(3, lista.indexOf("Holiwis4"));
		Assert.assertEquals(-1, lista.indexOf("Shou"));
		Assert.assertEquals(2, lista.indexOf("Holiwis3"));
	}
	@Test
	public void lastIndexOf(){
		ListaPosts<String> lista = new ListaPosts<String>();
		lista.add("Holiwis");
		lista.add("Holiwis2");
		lista.add("Holiwis3");
		lista.add("Holiwis4");
		lista.add("Holiwis3");
		Assert.assertEquals(1, lista.lastIndexOf("Holiwis2"));
		Assert.assertEquals(0, lista.lastIndexOf("Holiwis"));
		Assert.assertEquals(3, lista.lastIndexOf("Holiwis4"));
		Assert.assertEquals(-1, lista.lastIndexOf("Shou"));
		Assert.assertEquals(4, lista.lastIndexOf("Holiwis3"));
	}
	@Test
	public void subList(){
		ListaPosts<String> lista = new ListaPosts<String>();
		lista.add("Holiwis");
		lista.add("Holiwis2");
		lista.add("Holiwis3");
		lista.add("Holiwis4");
		lista.add("Holiwis5");
		ListaPosts<String> sublista = lista.subList(1, 3);
		Assert.assertEquals("Holiwis2", sublista.get(0));
		Assert.assertEquals("Holiwis3", sublista.get(1));
		Assert.assertEquals(2, sublista.size());

	}
	@Test(expected = RuntimeException.class)
	public void sublistError(){
		ListaPosts<String> lista = new ListaPosts<String>();
		lista.add("Holiwis");
		lista.add("Holiwis2");
		lista.add("Holiwis3");
		lista.add("Holiwis4");
		lista.add("Holiwis5");
	 	lista.subList(-1, 152);

	}
	@Test
	public void toArray(){
		ListaPosts<String> lista = new ListaPosts<String>();
		lista.add("Holiwis");
		lista.add("Holiwis2");
		lista.add("Holiwis3");
		Object[] listaArray = new Object[lista.size()];
		Object[] listaToArray = lista.toArray();
		listaArray[0] ="Holiwis";
		listaArray[1] ="Holiwis2";
		listaArray[2] ="Holiwis3";
		Assert.assertEquals((Object)listaArray[0],(Object)listaToArray[0]);
		Assert.assertEquals((Object)listaArray[1],(Object)listaToArray[1]);
		Assert.assertEquals((Object)listaArray[2],(Object)listaToArray[2]);
	}
	@Test
	public void remove(){
		ListaPosts<String> lista = new ListaPosts<String>();
		lista.add("Holiwis");
		lista.add("Holiwis2");
		lista.add("Holiwis3");
		Assert.assertEquals("Holiwis2", lista.remove(1));
		Assert.assertEquals("Holiwis",lista.get(0));
		Assert.assertEquals("Holiwis3",lista.get(1));
	}
	@Test
	public void set(){
		ListaPosts<String> lista = new ListaPosts<String>();
		lista.add("Holiwis");
		lista.add("Holiwis2");
		lista.add("Holiwis3");
		Assert.assertEquals("Holiwis2", lista.set(1, "holanda") );
		Assert.assertEquals("holanda", lista.get(1));
	}
}
