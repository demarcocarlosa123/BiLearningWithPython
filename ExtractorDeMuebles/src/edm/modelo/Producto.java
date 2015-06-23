package edm.modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import edm.back.downloader.Downloader;

public class Producto {
	private String nombre;
	private String linea;
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
		Imagen nuevaImagen = new Imagen(color, vista, link, linea + "-" + nombre);
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
	public void descargarInfo() throws IOException {
		Iterator<Imagen> itImagenes = imagenes.iterator();
		while (itImagenes.hasNext()) {
			Imagen imagen = itImagenes.next();
			Downloader.downloadImage(imagen.getUrl(), imagen.getNombre());		
		}
		System.out.println("Fin desgargas");
		
	}
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	public String getLineaNombre (){
		String lineaNombre; 
		lineaNombre = this.getLinea() + "-";
		lineaNombre = lineaNombre + this.getNombre();
		return lineaNombre;
	}


	
}
