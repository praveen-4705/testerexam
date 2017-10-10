package io.autotest.steps;

import io.autotest.scope.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

@Scope("test")
@ContextConfiguration("classpath:spring-context/test-context.xml")
public class Hooks {
	@Autowired
	private WebDriver driver;
	@Autowired
	private ApplicationContext context;

	@Before
	public void beforeScenario(Scenario scenario) {
		driver.manage().window().maximize();
	}

	@After
	public void afterScenario(Scenario scenario) {
		driver.close();
		((ScenarioScope) context.getBean(ScenarioScope.class)).clear();
	}
}
