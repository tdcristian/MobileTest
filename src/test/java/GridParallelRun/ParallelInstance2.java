package GridParallelRun;

import Core.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by tescu on 2/16/16.
 */
public class ParallelInstance2 extends Base {

    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws IOException, InterruptedException {
        super.setUp();
    }

    @Test
    public void testInstance1() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.1.1");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"ANDROID");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5556");
        caps.setCapability("avd","AVD_for_Nexus_5_API22");
        caps.setCapability(MobileCapabilityType.APP_PACKAGE,"com.android.calculator2");
        caps.setCapability(MobileCapabilityType.APP_ACTIVITY,"com.android.calculator2.Calculator");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"),caps); // For Grid

        WebElement five = driver.findElementByName("5");
        WebElement plus = driver.findElementByName("+");
        WebElement four = driver.findElementByName("4");
        WebElement equals = driver.findElementByAccessibilityId("equals");

        five.click();
        plus.click();
        four.click();
        equals.click();

    }
}
