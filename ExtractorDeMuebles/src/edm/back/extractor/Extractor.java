package edm.back.extractor;

import java.io.IOException;

public abstract class Extractor {
	public abstract void extract(String url) throws IOException;
}
