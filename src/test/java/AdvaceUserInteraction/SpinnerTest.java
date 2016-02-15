package AdvaceUserInteraction;

import Core.Base;
import Core.Element;
import Core.Listener;
import Core.NativeElem;
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
public class SpinnerTest extends Base {

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        super.setUp();

        File app = new File("src//main//resources//Apps//AndroidUI.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.APP,app);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.0.1");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Android emulator");
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
    public void testSpinner(){

        NativeElem spinner = new NativeElem(Element.LocatorType.byId,"android:id/text1","spinnerElement");
        spinner.scrollToExact("India");
        NativeElem option = new NativeElem(Element.LocatorType.byName,"India","option");
        option.click();
    }
}

