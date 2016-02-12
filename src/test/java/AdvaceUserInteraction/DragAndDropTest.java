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
 * Created by tescu on 2/12/16.
 */
@Listeners(Listener.class)
public class DragAndDropTest extends Base {

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        super.setUp();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.0.1");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Android emulator");
        caps.setCapability("avd","AVD_for_Nexus_5_API21");
        caps.setCapability(MobileCapabilityType.APP_PACKAGE,"com.android.launcher");
        caps.setCapability(MobileCapabilityType.APP_ACTIVITY,"com.android.launcher2.Launcher");

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
    public void testDragAndDrop()
    {
        NativeElem appIcon = new NativeElem(Element.LocatorType.byName,"Calculator","appIcon");

        String locatorElement = "Remove";
        Element.LocatorType type = Element.LocatorType.byName;
        NativeElem.pressOnAndMoveToNotVisibleElement(appIcon,type,locatorElement);
    }


}
