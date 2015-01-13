package edm.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Producto {
	private String nombre;
	private ArrayList<Imagen> imagenes = new ArrayList<Imagen>();
	public ArrayList<Imagen> getImagen() {
		return imagenes;
	}
	public void setImagen(ArrayList<Imagen> imagen) {
		this.imagenes = imagen;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void agregarImagen(int color, int vista, String link) {
		Imagen nuevaImagen = new Imagen(color, vista, link);
		this.getImagen().add(nuevaImagen);
		
	}
	public void print() {
		System.out.println("Nombre: " + this.getNombre());
		Iterator<Imagen> itImagenes = imagenes.iterator();
		while (itImagenes.hasNext()) {
			Imagen imagen = itImagenes.next();
			imagen.print();
			
		}
		
		
	}

	
}
