import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        plugin = {"pretty"},
        glue = {"stepDefinitions"},
        strict = true,
        tags = "@Getter")
public class CukesRunner {

}
