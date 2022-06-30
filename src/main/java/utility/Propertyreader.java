package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propertyreader {

	private Properties property;

	public Properties initProp() {

		property = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/hopscotch.properties");
			property.load(ip);

		} catch (IOException e) {
			Log.info(e.getMessage());
		}

		return property;
	}

}
