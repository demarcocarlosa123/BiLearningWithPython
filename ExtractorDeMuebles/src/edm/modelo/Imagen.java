package edm.modelo;

public class Imagen {
	private String url;
	private int color;
	private int vista;
	public Imagen(int color2, int vista2, String link) {
		url = link;
		color = color2;
		vista = vista2;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getVista() {
		return vista;
	}
	public void setVista(int vista) {
		this.vista = vista;
	}
	public void print() {
		System.out.print("Color" + color);
		System.out.print("Vista" + vista); 
		System.out.println(": " + url);
		
		
	}

}
