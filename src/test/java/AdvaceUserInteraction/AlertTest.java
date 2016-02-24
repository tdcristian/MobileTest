package AdvaceUserInteraction;

import Core.Base;
import Core.Listener;
import Core.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by tescu on 2/12/16.
 */
@Listeners(Listener.class)
public class AlertTest extends Base {

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        super.setUp();

        File app = new File("src//main//resources//Apps//AndroidUI.apk");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.APP,app);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.0.1");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        caps.setCapability("avd","AVD_for_Nexus_5_API21");
        caps.setCapability("appPackage","com.android.androidui");
        caps.setCapability("appActivity","com.android.androidui.MainActivity");

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
    public void testAlert(){

        MobileElement alert = new MobileElement(MobileElement.LocatorType.byName,"Show Alert","alertElement");
        alert.click();
        alert.closeAlert();

        Base.pressKeyCode(AndroidKeyCode.HOME);
    }
}
