package Pages;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Util.Util;

public class MockValuesValidation {
	
	private WebDriver driver;
	private Util util;
	//Locators
	private By value1 = By.id("txt_val_1");
	private By value2 = By.id("txt_val_2");
	private By value4 = By.id("txt_val_4");
	private By value5 = By.id("txt_val_5");
	private By value6 = By.id("txt_val_6");
	private By totalBalance = By.id("txt_ttl_va");
	private By allTextValues = By.xpath("//*[contains(@id,'txt_val')]");
	
	
	List<Double> allValues = new ArrayList<Double>();
	List<String> allValuesWithCurrency = new ArrayList<String>();
	List<String> allCurrencyFormattedValues = new ArrayList<String>();
	
	//Constructor
	public MockValuesValidation(WebDriver driver) {
		this.driver = driver;
	}
	
	//Functions
	
	public String value(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public double valueWithOutDollar(By locator) {
		return Double.parseDouble(driver.findElement(locator).getText().trim().substring(1));
	}
	
	public List<Double> allValues(){
		util.waitUntilElementIsVisible(totalBalance);
		driver.findElements(allTextValues).stream().forEach(value -> allValues.add(Double.parseDouble(value.getText().substring(1))));
		return allValues;
		
	}
	
	public List<String> allValuesWIthCurrecny(){
		util.waitUntilElementIsVisible(totalBalance);
		driver.findElements(allTextValues).stream().forEach(value -> allValuesWithCurrency.add(value.getText()));
		return allValuesWithCurrency;
		
	}
	
	public int valuesCount() {
		return allValues.size();
	}
	
	public double totalSumOfValues() {
		return valueWithOutDollar(value1) + valueWithOutDollar(value2) + valueWithOutDollar(value4) + valueWithOutDollar(value5) + valueWithOutDollar(value6);
	}

	public By getTotalBalance() {
		return totalBalance;
	}
	
	public List<String> validateUSCurrencyFormat() {
		for(int i=0;i<allValues.size();i++) {
			double db = allValues.get(i);
			Locale usa = new Locale("en", "US");
			Currency dollars = Currency.getInstance(usa);
			NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(usa);
			allCurrencyFormattedValues.add(dollarFormat.format(db));
		}
		return allCurrencyFormattedValues;
		
	}


}
