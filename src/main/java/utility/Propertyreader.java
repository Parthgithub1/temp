package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertyreader {

	private Properties property;

	public Properties init_prop() {

		property = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/hopscotch.properties");
			property.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return property;

	}

}
