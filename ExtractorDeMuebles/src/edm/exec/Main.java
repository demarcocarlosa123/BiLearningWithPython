package edm.exec;

import java.io.IOException;

import edm.back.extractor.Extractor;
import edm.back.extractor.ExtractorIkea;

public class Main {

	public static void main(String[] args) throws IOException {
		Extractor extractor = new ExtractorIkea();
		extractor.extract("http://www.ikea.com/us/en/catalog/products/50243299/");
		//extractor.extract("http://www.ikea.com/us/en/catalog/products/00105323/");
		//extractor.extract("http://www.ikea.com/us/en/catalog/products/10065958/");
		//extractor.extract("http://www.ikea.com/us/en/catalog/products/00095036/");

	}

}
