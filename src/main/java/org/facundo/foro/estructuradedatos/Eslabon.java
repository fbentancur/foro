package org.facundo.foro.estructuradedatos;

public class Eslabon<Elemento>{
	Elemento elemento;
	boolean tieneSiguiente;
	Eslabon<Elemento> siguienteEslabon;

	public Eslabon(
		Elemento elemento
	){
		this.elemento = elemento;
		this.tieneSiguiente = false;
		this. siguienteEslabon = null;
	}

	public boolean esEquivalente(Eslabon<Elemento> otro){
		if(this.elemento.equals(otro.elemento)){
			return true;
		}
		else{
			return false;
		}
	}

}
