package org.facundo.foro.modelos;

public class Post{
	public String titulo;
	public String cuerpo;
	public int    codigo;

	public Post(String titulo,String cuerpo,int codigo){
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.codigo = codigo;
	}
}
