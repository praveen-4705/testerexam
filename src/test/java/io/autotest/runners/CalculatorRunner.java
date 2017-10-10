package io.autotest.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:cucumber-feature/google-calc.feature",
        glue = "io.autotest.steps",
        plugin = "json:target/calc.json")
public class CalculatorRunner {

}
