package org.facundo.foro;

public class ListaPosts{
	boolean tieneRaiz;
	Eslabon eslabon;

 	public void agregar(Post post){
		Eslabon newEslabon = new Eslabon();
		newEslabon.tieneSiguiente = false;
		newEslabon.post = post;
		if(this.tieneRaiz){
			Eslabon eslabonActual = this.eslabon;
			while(eslabonActual.tieneSiguiente == true){
				eslabonActual = eslabonActual.siguienteEslabon;

			}
			eslabonActual.siguienteEslabon = newEslabon;
			eslabonActual.tieneSiguiente = true;
		}
		else{
			this.eslabon = newEslabon;
			this.tieneRaiz =true;
		}
	}
	public int mostrarLargo(){
		if(this.tieneRaiz){
			Eslabon eslabonActual = this.eslabon;
			int contador = 1;
			while(eslabonActual.tieneSiguiente ==true){
				contador+=1;
				eslabonActual = eslabonActual.siguienteEslabon;
			}
			return contador;
		}
		else{
			return 0;
		}
	}

}