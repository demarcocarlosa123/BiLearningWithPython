package edm.exec;

import java.io.IOException;

import edm.back.extractor.Extractor;
import edm.back.extractor.ExtractorIkea;

public class Main {

	public static void main(String[] args) throws IOException {
		Extractor extractor = new ExtractorIkea();
		extractor.extract("http://www.ikea.com/us/en/catalog/products/10265146/#/10265146");

	}

}
