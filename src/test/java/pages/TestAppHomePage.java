package pages;

import Core.Base;
import Core.Element;
import Core.NativeElem;

/**
 * Created by tescu on 2/9/16.
 */
public class TestAppHomePage extends Base {

    NativeElem urlField = new NativeElem(Element.LocatorType.byId,"com.example.testapp:id/urlField","urlField");
    NativeElem goButton = new NativeElem(Element.LocatorType.byId,"com.example.testapp:id/goButton","goButton");

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
