package org.maven.sample.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDefinition {
	static WebDriver driver;
	
	@Given("^The user has to fill the registration page$")
	public void the_user_has_to_fill_the_registration_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vasanth\\eclipse-workspace\\cucumber\\driver\\chromedriver.exe");
		 driver =new ChromeDriver();
		driver.get("https://demoqa.com/registration/");
		
	}

	@When("^The user enter the fname and lname$")
	public void the_user_enter_the_fname_and_lname() {
		driver.findElement(By.id("name_3_firstname")).sendKeys("vasanth");
		driver.findElement(By.id("name_3_lastname")).sendKeys("vasu");
		
	}

	@Then("^The user need to verify the fname and lname$")
	public void the_user_need_to_verify_the_fname_and_lname() {
		Assert.assertEquals("vasanth", driver.findElement(By.id("name_3_firstname")).getAttribute("value"));
		Assert.assertEquals("vasu",driver.findElement(By.id("name_3_lastname")).getAttribute("value") );
		
	}

}
