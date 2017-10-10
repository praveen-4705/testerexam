package io.autotest.steps;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;

@Scope("test")
@ContextConfiguration("classpath:spring-context/test-context.xml")
public class GivenSteps {
	@Autowired
	private WebDriver webDriver;


    @Given("^I am on google calculator page$")
    public void iAmOnGoogleCalculatorPage() throws Throwable {
		webDriver.get("https://www.google.ie/search?q=calculator");
    }
}
