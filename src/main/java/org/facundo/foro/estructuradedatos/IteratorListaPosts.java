package org.facundo.foro.estructuradedatos;
import java.util.Iterator;

public class IteratorListaPosts<Elemento> implements Iterator<Elemento>{
	ListaPosts<Elemento> lista;
	Eslabon<Elemento> eslabon;

	public IteratorListaPosts(ListaPosts<Elemento> lista){
		this.lista = lista;
		if(lista.tieneRaiz){
			this.eslabon = lista.eslabon;
		}
	}

	public boolean hasNext(){
		if(lista.tieneRaiz == false){
			return false;
		}
		else if(!(this.eslabon == null)){
			return true;
		}
		else{
			return false;
		}
	}

	public Elemento next(){
		Elemento elementoActual = this.eslabon.elemento;
		this.eslabon = this.eslabon.siguienteEslabon;
		return elementoActual;
	}

}
