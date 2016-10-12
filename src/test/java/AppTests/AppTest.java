package AppTests;

import java.io.IOException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Core.Base;
import Core.Listener;
import io.appium.java_client.remote.MobileCapabilityType;
import pages.Calculator;


/**
 * Created by tescu on 2/1/16.
 */

@Listeners({Listener.class})
public class AppTest extends Base {

    @BeforeSuite
    public void setUp() throws IOException, InterruptedException {
        super.setUp();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.1.1");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"ANDROID");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5556");
        caps.setCapability("avd","AVD_for_Nexus_5_API22");
        caps.setCapability(MobileCapabilityType.APP_PACKAGE,"com.android.calculator2");
        caps.setCapability(MobileCapabilityType.APP_ACTIVITY,"com.android.calculator2.Calculator");
        setDriver(caps);
        
    }

    @AfterSuite
    public void tearDown(){
        super.tearDown();
        getDriver().closeApp();
        getDriver().quit();
    }

    @Test
    public void testApplication(){

        Calculator calculator = new Calculator();
        calculator.addNumbers(calculator.four,calculator.five);
        Assert.assertEquals(calculator.value.getText(),"9");
    }


    @Test
    public void testApplication1(){
        Calculator calculator = new Calculator();
        calculator.addNumbers(calculator.five,calculator.four);
        Assert.assertEquals(calculator.value.getText(),"9");
    }



}
