package utility;

import java.util.Properties;

public class Environmenthelper {

	static Propertyreader propertyreader = new Propertyreader();
	static Properties property = propertyreader.init_prop();

	public static String setUrl(String Env) {
		String url = null;

		if (Env == null) {
			Env = "qat";
		}

		switch (Env) {
		case "dev":
			url = property.getProperty("dev");
			break;
		case "qat":
			url = property.getProperty("qat");
			break;
		case "uat":
			url = property.getProperty("uat");
			break;
		default:
			url = property.getProperty("qat");
		}
		return url;

	}

}
