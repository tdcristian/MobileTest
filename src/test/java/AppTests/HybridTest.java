package AppTests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Core.Base;
import Core.Listener;
import Core.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import pages.HybridAppHomePage;

/**
 * Created by tescu on 2/9/16.
 */
@Listeners(Listener.class)
public class HybridTest extends Base {

    AndroidDriver driver;

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                new Object[]{ "appium" },
                new Object[]{ "cucumber" }
        };
    }

    @BeforeSuite
    public void setUp() throws IOException, InterruptedException {
        super.setUp();

        File app = new File("src//main//resources//Apps//testApp.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.APP, app);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556");
        caps.setCapability("avd", "AVD_for_Nexus_5_API22");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        caps.setCapability(MobileCapabilityType.APP_PACKAGE, "com.example.testapp");
        caps.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.example.testapp.MainActivity");
        setDriver(caps);
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown();
        getDriver().closeApp();
        getDriver().quit();
    }
    
    @Test
    public void testHybridApp() {
        HybridAppHomePage hybridAppHomePage = new HybridAppHomePage();
        hybridAppHomePage.navigateToURL("http://www.google.com");
        Base.switchContentToWeb();
        Base.hideKeyboard();

        MobileElement searchFieldGoogle = new MobileElement(MobileElement.LocatorType.byName, "q", "searchField");
        searchFieldGoogle.waitToBeVisible(30);
        searchFieldGoogle.sendKeys("selenium");
        searchFieldGoogle.sendKeys(Keys.ENTER);

        Base.switchContentToNative();
        hybridAppHomePage.clearURLField();
        hybridAppHomePage.navigateToURL("http://www.bing.com");
        Base.switchContentToWeb();

        MobileElement searchFieldBing = new MobileElement(MobileElement.LocatorType.byName, "q", "searchField");
        searchFieldBing.waitToBeVisible(30);
        searchFieldBing.sendKeys("selenium");
        searchFieldBing.sendKeys(Keys.ENTER);
    }

    @Test(dataProvider = "testData")
    public void googleSearchDataDriven(String searchField) {
        HybridAppHomePage hybridAppHomePage = new HybridAppHomePage();
        hybridAppHomePage.navigateToURL("http://www.bing.com");
        Base.switchContentToWeb();
        Base.hideKeyboard();

        MobileElement searchFieldGoogle = new MobileElement(MobileElement.LocatorType.byName, "q", "searchField");
        searchFieldGoogle.waitToBeVisible(30);
        searchFieldGoogle.sendKeys(searchField);
        searchFieldGoogle.sendKeys(Keys.ENTER);
        
        Base.switchContentToNative();
    }

}
