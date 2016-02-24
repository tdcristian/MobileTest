package AppTests;

import Core.Base;
import Core.Element;
import Core.Listener;
import Core.WebElem;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.TestAppHomePage;

import java.io.File;
import java.io.IOException;

/**
 * Created by tescu on 2/9/16.
 */
@Listeners(Listener.class)
public class HybridTest extends Base {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        super.setUp();

        File app = new File("src//main//resources//Apps//testApp.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.APP,app);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.1.1");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5556");
        caps.setCapability("avd","AVD_for_Nexus_5_API22");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
        caps.setCapability(MobileCapabilityType.APP_PACKAGE,"com.example.testapp");
        caps.setCapability(MobileCapabilityType.APP_ACTIVITY,"com.example.testapp.MainActivity");
        setDriver(caps);
        driver = getDriver();
        Base.implicitWait(30);
    }

    @AfterClass
    public void tearDown(){
        super.tearDown();
        getDriver().closeApp();
        getDriver().quit();
    }

    @Test
    public void testHybridApp() {
        TestAppHomePage testAppHomePage = new TestAppHomePage();
        testAppHomePage.navigateToURL("http://www.google.com");
        Base.implicitWait(30);
        Base.switchContentToWeb();
        Base.hideKeyboard();

        WebElem searchFieldGoogle = new WebElem(Element.LocatorType.byName,"q","searchField");
        searchFieldGoogle.waitToBeVisible(30);
        searchFieldGoogle.sendKeys("selenium");
        searchFieldGoogle.sendKeys(Keys.ENTER);

        Base.switchContentToNative();
        testAppHomePage.clearURLField();
        testAppHomePage.navigateToURL("http://www.bing.com");
        Base.switchContentToWeb();

        WebElem searchFieldBing = new WebElem(Element.LocatorType.byName,"q","searchField");
        searchFieldBing.waitToBeVisible(30);
        searchFieldBing.sendKeys("selenium");
        searchFieldBing.sendKeys(Keys.ENTER);
    }

}
