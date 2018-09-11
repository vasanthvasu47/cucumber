package org.maven.sample.cucumber;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.NameList;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDef2 {
	static WebDriver driver;
	
	@Given("^The user has to fill the DemoQA registration page$")
	public void the_user_has_to_fill_the_DemoQA_registration_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vasanth\\eclipse-workspace\\cucumber\\driver\\chromedriver.exe");
		 driver =new ChromeDriver();
		driver.get("https://demoqa.com/registration/");
	    
	}

	@When("^The user enter the first_name and last_name$")
	public void the_user_enter_the_firstname_and_lastname(DataTable name) {
	    
		/*List<String> namelist= name.asList(String.class);
		driver.findElement(By.id("name_3_firstname")).sendKeys(namelist.get(0));
		driver.findElement(By.id("name_3_lastname")).sendKeys(namelist.get(1));*/
		
		Map<String, String> nameMap = name.asMap(String.class, String.class);
		Object firstame = null;
		driver.findElement(By.id("name_3_firstname")).sendKeys(nameMap.get(firstame));
		Object lastname = null;
		driver.findElement(By.id("name_3_lastname")).sendKeys(nameMap.get(lastname));
		
	    
	}

	@Then("^The user need to verify the firstname and lastname$")
	public void the_user_need_to_verify_the_firstname_and_lastname() {
		Assert.assertEquals("vishal", driver.findElement(By.id("name_3_firstname")).getAttribute("value"));
		Assert.assertEquals("nagarajan",driver.findElement(By.id("name_3_lastname")).getAttribute("value") );
	    
	}


}
