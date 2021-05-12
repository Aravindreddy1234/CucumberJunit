package StepDefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import Pages.MockValuesValidation;
import Util.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ValuesStedDef {
	
	private WebDriver driver;
	Properties prop;
	private MockValuesValidation mcv = new MockValuesValidation(driver);
	private ConfigReader configReader;
	int count;
	List<Double> allValues = new ArrayList<Double>();
	
	@Given("the user is on homepage")
	public void the_user_is_on_homepage() {
		configReader = new ConfigReader();
		prop = configReader.propInit();
		String baseURL = prop.getProperty("baseURL");
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@When("the user finds the count of the values")
	public void the_user_finds_the_count_of_the_values() {
	   count =  mcv.valuesCount();
	}

	@Then("the user validates the count as {string}")
	public void the_user_validates_the_count_as(int string) {
	   assertEquals(count, string);
	}
	
	@When("When the user fetches list of values")
	public void the_user_fetches_list_of_values() {
		allValues = mcv.allValues();
	}
	
	@Then("the user validates that all the values are greater than zero")
	public void validate_values_are_greterthan_zero() {
		for(int i=0;i<allValues.size();i++) {
			assertTrue(allValues.get(i) > 0);
		}
	}
	
	@Then("user validates that toatl sum value is equals to all values added")
	public void Sum_EqualTo_TotalBalance() {
		Double TotalBalance = mcv.valueWithOutDollar(mcv.getTotalBalance());
		assertTrue(TotalBalance == mcv.totalSumOfValues());
	}
	
	@When("user fetches all currencies")
	public void all_currencies_fetch() {
		mcv.allValuesWIthCurrecny();
	}
	
	@Then("the user validates that all the values are currency formatted")
	public void validate_all_Values_currecny_Formatted() {
		assertTrue(mcv.validateUSCurrencyFormat().equals(mcv.allValuesWIthCurrecny()));
	}
	

}
