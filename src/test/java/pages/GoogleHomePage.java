package pages;

import Core.Base;
import Core.Element;
import Core.WebElem;

/**
 * Created by tescu on 2/9/16.
 */
public class GoogleHomePage extends Base {

    WebElem elem = new WebElem(Element.LocatorType.byName,"q","elem");

    public GoogleHomePage() {
    }


    public void navigateToTutorialsPage() {

        elem.waitListToBeVisible(30);
        elem.sendKeys("selenium");

    }
}
