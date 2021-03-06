package AdvaceUserInteraction;

import Core.Base;
import Core.Listener;
import Core.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by tescu on 2/10/16.
 */
@Listeners(Listener.class)
public class LongPressTest extends Base {

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        super.setUp();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.0.1");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        caps.setCapability("avd","AVD_for_Nexus_5_API21");
        caps.setCapability(MobileCapabilityType.APP_PACKAGE,"com.android.dialer");
        caps.setCapability(MobileCapabilityType.APP_ACTIVITY,"com.android.dialer.DialtactsActivity");
        setDriver(caps);
        Base.implicitWait(30);
    }

    @AfterClass
    public void tearDown(){
        super.tearDown();
        getDriver().closeApp();
        getDriver().quit();
    }

    @Test
    public void testDial() {

        MobileElement dialPad = new MobileElement(MobileElement.LocatorType.byAccessibilityId,"dial pad","dialPad");
        dialPad.click();
        MobileElement zero = new MobileElement(MobileElement.LocatorType.byAccessibilityId,"0","zero");
        zero.waitToBeVisible(30);
        zero.longPress();
        MobileElement plus = new MobileElement(MobileElement.LocatorType.byClassName,"android.widget.EditText","plus");
        plus.waitToBeVisible(30);
        Assert.assertEquals(plus.getText(),"+");
    }
}
