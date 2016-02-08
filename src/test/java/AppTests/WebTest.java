package AppTests;

import Core.Base;
import Core.Listener;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Calculator.EBayHomePage;
import pages.Calculator.SearchResultEBayPage;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by tescu on 2/8/16.
 */
@Listeners(Listener.class)
public class WebTest extends Base {

    AndroidDriver driver;

    @BeforeClass
    public  void setUp() throws IOException {
        super.setUp();

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.1.1");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Android emulator");
        caps.setCapability("avd","AVD_for_Nexus_5_API22");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
        setDriver(caps);
        driver = getDriver();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Base.implicitWait(30);

    }

    @AfterClass
    public  void tearDown(){
        driver.quit();
    }

    @Test
    public void testEBayPage() throws MalformedURLException, InterruptedException {

        driver.get("http://m.ebay.de");
        Base.implicitWait(15);
        EBayHomePage homePage = new EBayHomePage();
        homePage.searchFor("Nexus 5");
        SearchResultEBayPage resultEBayPage = new SearchResultEBayPage();
        resultEBayPage.goToGomePage();

    }

}
