package Core;

import java.io.IOException;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;

@org.junit.runner.RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/java/BDD/CalcFeatureFile",
                    format = { "pretty","html: cucumber-html-reports",
                               "json: cucumber-html-reports/cucumber.json" })
public class BDDRunner extends Base {

    @Before
    public void setUp() throws IOException, InterruptedException {
        super.setUp();
    }

    @After
    public void tearDown() {
        super.tearDown();
    }
 
}
