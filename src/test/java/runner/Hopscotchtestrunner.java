package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", glue = { "steps",
		"cucumber" }, tags = "@Jayti", plugin = { "pretty", "html:target/HtmlReports.html" }, monochrome = true, dryRun = false)

public class Hopscotchtestrunner {

}
