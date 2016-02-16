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

import java.io.IOException;

/**
 * Created by tescu on 2/11/16.
 */
@Listeners(Listener.class)
public class PressMoveTest extends Base {

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        super.setUp();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.0.1");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        caps.setCapability("avd","AVD_for_Nexus_5_API21");
        caps.setCapability(MobileCapabilityType.APP_PACKAGE,"com.android.calculator2");
        caps.setCapability(MobileCapabilityType.APP_ACTIVITY,"com.android.calculator2.Calculator");
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
    public void testPressMove(){

        NativeElem delButton = new NativeElem(Element.LocatorType.byName,"del","delButton");
        NativeElem digitSeven = new NativeElem(Element.LocatorType.byId,"com.android.calculator2:id/digit_7","digitSeven");

        NativeElem.pressOnAndMoveTo(delButton,digitSeven);
    }

}
