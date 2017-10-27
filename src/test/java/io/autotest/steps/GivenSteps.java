package io.autotest.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.autotest.pages.GoogleCalcPage;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;

@Scope("test")
@ContextConfiguration("classpath:spring-context/test-context.xml")
public class GivenSteps {
	@Autowired
	private WebDriver webDriver;

	@Autowired
	private GoogleCalcPage googleCalcPage;
	
	@Given("^I am on google calculator page$")
	public void iAmOnGoogleCalculatorPage() throws Throwable {
		webDriver.get("https://www.google.ie/search?q=calculator");
		Thread.sleep(3000);
	}

	@When("^I add number \"([^\"]*)\" to number \"([^\"]*)\"$")
	public void i_add_number_to_number(String arg1, String arg2) {
		googleCalcPage.clickOnGivenButton(webDriver, arg1);
		googleCalcPage.clickOnGivenButton(webDriver, "+");
		googleCalcPage.clickOnGivenButton(webDriver, arg2);
		googleCalcPage.clickOnGivenButton(webDriver, "=");
	}
	
	@When("^I subtract number \"([^\"]*)\" to number \"([^\"]*)\"$")
	public void i_subtract_number_to_number(String arg1, String arg2) {
		googleCalcPage.clickOnGivenButton(webDriver, arg1);
		googleCalcPage.clickOnGivenButton(webDriver, "−");
		googleCalcPage.clickOnGivenButton(webDriver, arg2);
		googleCalcPage.clickOnGivenButton(webDriver, "=");
	}

	@Then("^I should get an answer of \"([^\"]*)\"$")
	public void i_should_get_an_answer_of(String arg1) {
		
		Assert.assertEquals(arg1, googleCalcPage.getResult());

	}
}
