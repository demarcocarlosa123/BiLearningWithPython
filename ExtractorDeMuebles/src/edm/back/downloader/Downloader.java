package edm.back.downloader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Downloader {
	public static void downloadImage(String url, String imgSrc) throws IOException {
        BufferedImage image = null;
        try {
        	
            imgSrc = imgSrc.substring(imgSrc.lastIndexOf("/") + 1);
            System.out.println("Descargando...." +imgSrc );
            String imageFormat = null;
            imageFormat = imgSrc.substring(imgSrc.lastIndexOf(".") + 1);
            String imgPath = null;
            imgPath = "C:/Dropbox/proyectos/Clever furniture/Muebles/imagenes/livingRoom/tvAndMediaFurniture/Prueba/" + imgSrc + "";
            URL imageUrl = new URL(url);
            image = ImageIO.read(imageUrl);
            if (image != null) {
                File file = new File(imgPath);
                ImageIO.write(image, imageFormat, file);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
