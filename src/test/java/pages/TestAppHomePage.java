package pages;

import Core.MobileElement;

/**
 * Created by tescu on 2/9/16.
 */
public class TestAppHomePage {

    MobileElement urlField = new MobileElement(MobileElement.LocatorType.byId,"com.example.testapp:id/urlField","urlField");
    MobileElement goButton = new MobileElement(MobileElement.LocatorType.byId,"com.example.testapp:id/goButton","goButton");

    public TestAppHomePage() {

    }

    public void navigateToURL(String url) {
        urlField.waitToBeVisible(30);
        goButton.waitToBeVisible(30);
        urlField.sendKeys(url);
        goButton.click();
    }


    public void clearURLField() {
        urlField.clear();
    }
}
