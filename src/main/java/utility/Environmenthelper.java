package utility;

import java.util.Properties;

public class Environmenthelper {

	static Propertyreader propertyreader = new Propertyreader();
	static Properties prop = propertyreader.init_prop();

	public static String setUrl(String Env) {
		String url = null;

		switch (Env) {
		case "dev":
			url = prop.getProperty("dev");
			break;
		case "qat":
			url = prop.getProperty("qat");
			break;
		case "uat":
			url = prop.getProperty("uat");
			break;
		}
		return url;

	}

}
