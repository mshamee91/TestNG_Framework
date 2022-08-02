package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	Properties prop;

	public void initProperty() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")+"/src/test/resources/com/qa/config/config.properties");
		prop.load(fis);

	}

	public String getProperty(String key) throws IOException {
		String value = prop.getProperty(key);
		return value;
	}
}
