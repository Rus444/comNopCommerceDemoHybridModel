package NopCommercePOMHybrid;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".",tags="@register, @currency",
        format = {"pretty","html:target/cucumber-reports"})
public class RunTest {

}