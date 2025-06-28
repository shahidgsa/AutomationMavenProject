package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties readconfig;

	String path = "config.Properties";

	public ReadConfig() throws IOException {

		readconfig = new Properties();
		FileInputStream file = new FileInputStream(path);
		readconfig.load(file);

	}

	public String getBrowser() {
		String value = readconfig.getProperty("browser");
		if (value != null)
			return value;
		else
			throw new RuntimeException("url not specified in config");

	}

}
