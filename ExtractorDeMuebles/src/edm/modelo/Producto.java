package edm.modelo;

import java.util.ArrayList;

public class Producto {
	private String nombre;
	private ArrayList<Imagen> imagen;
	public ArrayList<Imagen> getImagen() {
		return imagen;
	}
	public void setImagen(ArrayList<Imagen> imagen) {
		this.imagen = imagen;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
