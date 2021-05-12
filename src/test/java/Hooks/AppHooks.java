package Hooks;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import Util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class AppHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order = 0)
	public void fetchProperty() {
		configReader = new ConfigReader();
		prop = configReader.propInit();
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.driversSetUp(browserName);
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

}
 