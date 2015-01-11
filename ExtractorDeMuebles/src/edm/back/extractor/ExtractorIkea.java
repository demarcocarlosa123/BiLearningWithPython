package edm.back.extractor;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edm.back.downloader.Downloader;

public class ExtractorIkea extends Extractor{
	
	public void extract(String url) throws IOException{
		Document doc = Jsoup.connect(url).get();
		String title = doc.title();
		System.out.println(title);
		
		Elements tagsImg = doc.getElementsByClass("tNail");
		for (Element tagImg : tagsImg) {
			  //Element tagParentDiv = tagImg.parent();
			  //System.out.println("ID vista: " +tagParentDiv.attr("id").substring(4));
			  String linkImg = tagImg.attr("abs:src");
			  String linkImgGrande = linkImg.replace("S1", "S5");
			  System.out.println("URLextraida...." + linkImgGrande);
			  Downloader.downloadImage(linkImgGrande, linkImgGrande);
			  
			}

	}
	
	private ArrayList getListaDeColores (Document doc){
		return null;
		
	}
}
