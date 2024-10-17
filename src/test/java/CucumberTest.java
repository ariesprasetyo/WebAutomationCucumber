import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepDefinition"},
        plugin = {"html:build/cucumber-report/index.html",
                "json:build/cucumber-report/index.json",
                "pretty"}
)
public class CucumberTest {
}
