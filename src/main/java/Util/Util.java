package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	
	private WebDriver driver;
	
	public void waitUntilElementIsVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void waitUntilElementIsVisible(By element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void waitUntilElementsAreVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfAllElements(element));	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void clickUsingJavascript(WebElement element) {
		waitUntilElementIsVisible(element);
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].click();",element);
	}

}
