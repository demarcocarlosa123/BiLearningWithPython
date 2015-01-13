package edm.back.extractor;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edm.back.downloader.Downloader;
import edm.modelo.Imagen;
import edm.modelo.Producto;

public class ExtractorIkea extends Extractor{
	
	public void extract(String url) throws IOException{
		Producto unProducto = new Producto();
		
		Document doc = Jsoup.connect(url).get();
		this.extraerNombre(doc, unProducto);
		this.extraerImagenes(doc, unProducto);
	}
	
	private void extraerImagenes(Document doc, Producto unProducto) {
		String script = doc.data();
		int color = 1; 
		script = script.substring(script.indexOf("\"normal\":[\"") + 10);
	    while (script != "-1") {
			String linkImg = "\"," + script.substring(0, script.indexOf("],\"zoom\":")) ;
			
			String linkVista = linkImg.substring(linkImg.indexOf("\",\"") + 3);
			int vista = 1; 
			while (linkVista != "-1") {
				String link = "www.ikea.com" + linkVista.substring(0, linkVista.indexOf(".JPG") + 4);
				link = link.replace("S3", "S5");
				unProducto.agregarImagen(color, vista, link);
			
				if (linkVista.indexOf("\",\"") == -1){
					linkVista = "-1";
				}else{
					linkVista = linkVista.substring(linkVista.indexOf("\",\"") + 3);
					vista ++;
				}
				
			}
			  
			if(script.indexOf("\"normal\":[\"") == -1){
				script = "-1";
				unProducto.print();
			}else{
				script = script.substring(script.indexOf("\"normal\":[\"") + 10); 
				color = color + 1;
			}
			  
		}
		
		
	}

	private ArrayList getListaDeColores (Document doc, Producto unProducto, String url) throws IOException{
		/*for (Element tagImg : tagsImg) {
			  //Element tagParentDiv = tagImg.parent();
			  //System.out.println("ID vista: " +tagParentDiv.attr("id").substring(4));
			  String linkImg = tagImg.attr("abs:src");
			  String linkImgGrande = linkImg.replace("S1", "S5");
			  System.out.println("URLextraida...." + linkImgGrande);
			  Downloader.downloadImage(linkImgGrande, linkImgGrande);
			  
			}*/
		ArrayList<Imagen> imagenes = new ArrayList<Imagen>();	
		Elements tagsImg = doc.getElementsByClass("tNail");		
		int numeroImagen = 0;
		for (Element tagImg : tagsImg) {
			  Element tagParentDiv = tagImg.parent();
			  String idColor = tagParentDiv.attr("id").substring(4);
			  String urlColor = url + "#" + idColor;
			  Document docColor = Jsoup.connect(urlColor).get();
			  String script = doc.data();
			  
			  script = script.substring(script.indexOf("thumb") + 9);
			  while (script != "-1") {
				  String linkImg = script.substring(0, script.indexOf(".JPG") + 4);
				  System.out.println(linkImg);
				  
				  if(script.indexOf("thumb") == -1){
					  script = "-1";
				  }else{
					  script = script.substring(script.indexOf("thumb") + 9); 
				  }
				  
			  }
			  
			  

			  numeroImagen ++;
			}
		return imagenes;
		
	}
	
	private void extraerNombre (Document doc, Producto unProducto){
		String title = doc.title();
		System.out.println(title);
		unProducto.setNombre(title);
		
	}
}
