package BDD.CalcStepDefinition;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import Core.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.remote.MobileCapabilityType;
import pages.Calculator;

public class CalcStepDefinition extends Base {

    private Calculator calculator;

    @Given("^I select the correct capabilities$")
    public void iSelectTheCorrectCapabilities() throws Throwable {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556");
        caps.setCapability("avd", "AVD_for_Nexus_5_API22");
        caps.setCapability(MobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
        caps.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        setDriver(caps);

    }

    @And("^Open the calculator$")
    public void openTheCalculator() throws Throwable {
        calculator = new Calculator();
    }

    @When("^I add (.*) and (.*)$")
    public void iAddAAndB(String number1, String number2) throws Throwable {

        calculator.addTheFollowingNumbers(number1, number2);
    }

    @Then("^the result is (.*)$")
    public void theResultIsC(String result) throws Throwable {

        Assert.assertEquals(calculator.value.getText(), result);

    }

    @And("^close the calculator$")
    public void closeTheCalculator() throws Throwable {

        getDriver().closeApp();
        getDriver().quit();

    }
}
