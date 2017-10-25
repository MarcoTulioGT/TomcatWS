package tigo.bsd.com;

import java.io.Serializable;

public class consulta  implements Serializable{
	private static final long serialVersionUID = -5577579081118070434L;
	
	private String nombre;
	private int valor1;
	private int valor2;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getValor1() {
		return valor1;
	}
	public void setValor1(int valor1) {
		this.valor1 = valor1;
	}
	public int getValor2() {
		return valor2;
	}
	public void setValor2(int valor2) {
		this.valor2 = valor2;
	}	
	
	@Override
	public String toString(){
		return nombre+"::"+valor1+"::"+valor2;
	}


}
