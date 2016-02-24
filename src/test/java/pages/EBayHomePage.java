package pages;

import Core.MobileElement;

/**
 * Created by tescu on 2/8/16.
 */
public class EBayHomePage {

    MobileElement searchBox = new MobileElement(MobileElement.LocatorType.byId,"kw","searchBox");

    public EBayHomePage() {
    }

    public void searchFor(String text) {
        searchBox.waitToBeVisible(30);
        searchBox.sendKeys(text);
        searchBox.submit();
    }


}
