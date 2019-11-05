package org.facundo.foro.estructuradedatos;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
public class ListaPosts<Elemento> implements Iterable<Elemento>, List<Elemento>{
	public boolean tieneRaiz;
	public Eslabon<Elemento> eslabon;

	public ListaPosts(){
		this.tieneRaiz = false;
		this.eslabon = null;
	}

	public boolean add(Elemento elemento) {
		this.add(this.size(), elemento);
		return true;
	}


	public Elemento get(int posicion) {
		int largo = this.size();
		if (posicion < 0) {
			throw new RuntimeException("Valores negativos no validos");
		}
		if (posicion <= largo) {
			Eslabon<Elemento> eslabonActual = this.eslabon;
			for (int contador = 0; contador < posicion; contador++) {
				eslabonActual = eslabonActual.siguienteEslabon;
			}
			return eslabonActual.elemento;
		} else {
			throw new RuntimeException("El eslabon seleccionado excede el largo de la lista");
		}
	}


	public void add(int lugar, Elemento elemento) {
		if (lugar > this.size()) {
			throw new RuntimeException("El eslabon seleccionado excede el largo de la lista");

		} else if (lugar < 0) {
			throw new RuntimeException("La lista no contiente elementos guardados en valores negativos");
		}
		Eslabon<Elemento> newEslabon = new Eslabon<Elemento>(elemento);
		if (this.tieneRaiz) {
			Eslabon<Elemento> eslabonActual = this.eslabon;
			for (int r = 0; r < lugar - 1; r++) {
				eslabonActual = eslabonActual.siguienteEslabon;
			}
			if (eslabonActual.tieneSiguiente == true) {
				Eslabon<Elemento> eslabonSiguiente = eslabonActual.siguienteEslabon;
				newEslabon.siguienteEslabon = eslabonSiguiente;
				newEslabon.tieneSiguiente = true;
			}
			eslabonActual.siguienteEslabon = newEslabon;
			eslabonActual.tieneSiguiente = true;
		} else {
			this.eslabon = newEslabon;
			this.tieneRaiz = true;
		}
	}

	public boolean addAll(Collection<? extends Elemento> coleccion){
		if(coleccion.size() >0){
			for (Elemento elemento : coleccion ) {
				this.add(elemento);
			}
			return true;
		}
		return false;
	}
	public void clear(){
		this.tieneRaiz = false;
		this.eslabon = null;

	}
	public boolean addAll(int lugar, Collection<? extends Elemento> coleccion){
		if(lugar > this.size()){
			throw new RuntimeException("El lugar en el que deseas agregar los valores excede el largo de la lista");
		}
		else if(lugar <0){
			throw new RuntimeException("La lista no tiene datos guardados en lugares con valor negativo");
		}
		else if(coleccion.size() == 0){
			return false;
		}

		else{
			for(Elemento elemento : coleccion){
				this.add(lugar, elemento);
				lugar += 1;
			}
			return true;
		}

	}
	public boolean contains(Object elemento){
		if(this.tieneRaiz){
			Eslabon<Elemento> eslabonActual = this.eslabon;
			if(eslabonActual.elemento.equals(elemento)){
				return true;
			}
			else{
				while(eslabonActual.tieneSiguiente == true){
					eslabonActual =	eslabonActual.siguienteEslabon;
					if(eslabonActual.elemento.equals(elemento)){
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean containsAll(Collection<?> coleccion){
		if(this.tieneRaiz){
			for(Object r : coleccion){
				if(!this.contains(r)){

					return false;
				}

			}
			return true;
		}
		else{
			return false;
		}
	}

	public boolean isEmpty(){
		if(this.tieneRaiz){
			return false;
		}
		else{
			return true;
		}
	}
	public int size(){
		if(this.tieneRaiz){
			int contador = 1;
			Eslabon<Elemento> eslabonActual = this.eslabon;
			while(eslabonActual.tieneSiguiente == true){
				contador += 1;
				eslabonActual = eslabonActual.siguienteEslabon;
			}
			return contador;
		}
		else{
			return 0;
		}
	}

	public boolean equals(ListaPosts<Elemento> otro){
		int thisTamaño = this.size();
		int otroTamaño = otro.size();
		if(thisTamaño < otroTamaño){
			return false;
		}
		else if(thisTamaño > otroTamaño){
			return false;
		}
		else{
			Eslabon<Elemento> eslabonActualThis = this.eslabon;
			Eslabon<Elemento> eslabonActualOtro = otro.eslabon;
			while(eslabonActualThis.tieneSiguiente){
				if(eslabonActualThis.esEquivalente(eslabonActualOtro)){
					eslabonActualThis= eslabonActualThis.siguienteEslabon;
					eslabonActualOtro= eslabonActualOtro.siguienteEslabon;
				}
				else{
					return false;
				}

			}
			return true;
		}


	}
	public Iterator<Elemento> iterator(){
		IteratorListaPosts<Elemento> iterator = new IteratorListaPosts<Elemento>(this);
		return iterator;
	}
	public int hashCode(){
		int primo = 113;
		int resultado= 1;
		for(Elemento r : this){
			if(!(r ==null)){
				resultado *= r.hashCode()*primo;
			}
			else{
				resultado +=1;
			}
		}
		return resultado;
	}
	public int indexOf(Object elemento){
		int posicion = 0;
		for(Elemento r : this){
			if(elemento.equals(r)){
				return posicion;
			}
			else{
				posicion +=1;
			}
		}
		return -1;

	}
	public int lastIndexOf(Object elemento){
		int posicion = 0;
		int resultado = -1;
		for(Elemento r : this){
			if(elemento.equals(r)){
				resultado = posicion;
			}
			posicion +=1;
		}
		return resultado;

	}
	public ListaPosts<Elemento> subList(int comienzo, int fin){
		if(comienzo <0 || comienzo > this.size()|| fin < comienzo){
			throw new RuntimeException("Porque bobeas? es una lista seria esta mierda(a menos que tengas un bug, en ese caso sorry not sorry)");
		}
		ListaPosts<Elemento> listacorta =new ListaPosts<Elemento>();
		Iterator<Elemento> iterator = this.iterator();
		//Este for salta todo lo anterior al comienzo
		for(int r = 0; r <= comienzo-1; r++){
			iterator.next();
		}
		int cantidadElementos = fin-comienzo;
		for(int r=0; r<cantidadElementos; r++){
			listacorta.add(iterator.next());
		}
		return listacorta;

	}
	public Object[] toArray(){
		Object[] arrayLista = new Object[this.size()];
		for(int r=0; r<arrayLista.length; r++){
			arrayLista[r] = this.get(r);
		}
		return arrayLista;

	}
	public <T> T[] toArray(T[] perra){
		return null;
	}
	public Elemento set(int h, Elemento e){
		Eslabon<Elemento> eslabonActual= this.eslabon;
		for (int r = 0; r <h; r++) {
			eslabonActual = eslabonActual.siguienteEslabon;
		}
		Elemento eslabonAntiguoElemento = eslabonActual.elemento;
		eslabonActual.elemento = e;

		return eslabonAntiguoElemento;
	}
	public boolean retainAll(Collection<?> h){
		return false;
	}
	public boolean removeAll(Collection<?> h){
		return false;
	}
	public boolean remove(Object o){
		return false;
	}
	public Elemento remove(int n){
		if(n <0){
			throw new RuntimeException("No se aceptan valores negativos");
		}
		if(n > this.size()){
			throw new RuntimeException("El valor excede el largo de la lista");
		}
		if(n == 0){
			Eslabon<Elemento> retorno = this.eslabon;
			this.eslabon = this.eslabon.siguienteEslabon;
			return retorno.elemento;
		}
		else{
			Eslabon<Elemento> eslabonActual = this.eslabon;
			for (int r = 0; r <n-1; r++) {
				eslabonActual = eslabonActual.siguienteEslabon;
			}
			Eslabon<Elemento> retorno = eslabonActual.siguienteEslabon;
			if(eslabonActual.siguienteEslabon.tieneSiguiente == false){
				eslabonActual.siguienteEslabon = null;
				eslabonActual.tieneSiguiente = false;
			}
			else{
				eslabonActual.siguienteEslabon = eslabonActual.siguienteEslabon.siguienteEslabon;
				eslabonActual.tieneSiguiente = true;
			}
			return retorno.elemento;
		}
	}
	public ListIterator<Elemento> listIterator(){
		return null;
	}
	public ListIterator<Elemento> listIterator(int hola){
		return null;
	}
}
