package utility;

import java.util.Properties;

public class Environmenthelper {

	static Propertyreader propertyreader = new Propertyreader();
	static Properties property = propertyreader.initProp();

	public static String setUrl(String env) {
		String url = null;

		if (env == null) {
			env = "qat";
		}

		switch (env) {
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
