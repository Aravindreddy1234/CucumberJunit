package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	
	public Properties propInit() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src\\test\\resources\\config.properties");
			prop.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return prop;
	}
}
