package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(stepNotifications = true,
        features="features", glue="stepDefinition")
public class TestRunner {
}
