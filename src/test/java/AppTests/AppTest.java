package AppTests;

import Core.Base;
import Core.Listener;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Calculator.Calculator;

import java.io.IOException;


/**
 * Created by tescu on 2/1/16.
 */

@Listeners({Listener.class})
public class AppTest extends Base {

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.1.1");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Android emulator");
        caps.setCapability("avd","AVD_for_Nexus_5_API22");
        caps.setCapability(MobileCapabilityType.APP_PACKAGE,"com.android.calculator2");
        caps.setCapability(MobileCapabilityType.APP_ACTIVITY,"com.android.calculator2.Calculator");
        setDriver(caps);

        Base.implicitWait(30);

    }

    @AfterClass
    public void tearDown(){
        super.tearDown();
        getDriver().closeApp();
    }

    @Test
    public void testApplication(){

        Calculator calculator = new Calculator();
        calculator.addNumbers(calculator.five,calculator.four);

        Assert.assertEquals(calculator.value.getText(),"9");
    }


}
