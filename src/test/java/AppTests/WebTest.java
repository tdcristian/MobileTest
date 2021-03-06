package AppTests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Core.Base;
import Core.Listener;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import pages.EBayHomePage;
import pages.SearchResultEBayPage;

/**
 * Created by tescu on 2/8/16.
 */
@Listeners(Listener.class)
public class WebTest extends Base {

    AndroidDriver driver;

    @BeforeSuite
    public  void setUp() throws IOException, InterruptedException {
        super.setUp();

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.1.1");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5556");
        caps.setCapability("avd","AVD_for_Nexus_5_API22");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
        setDriver(caps);
        driver = getDriver();
    }

    @AfterSuite
    public  void tearDown(){
        super.tearDown();
        driver.quit();
    }

    @Test
    public void testEBayPage() throws MalformedURLException, InterruptedException {

        driver.get("http://m.ebay.de");
        EBayHomePage homePage = new EBayHomePage();
        homePage.searchFor("Nexus 5");
        SearchResultEBayPage resultEBayPage = new SearchResultEBayPage();
        Assert.assertEquals(resultEBayPage.getNumberOfResults(),26);
        resultEBayPage.goToHomePage();

    }

}
