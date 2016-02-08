package pages.Calculator;

import Core.Base;
import Core.Element;
import Core.WebElem;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by tescu on 2/8/16.
 */
public class EBayHomePage extends Base {

    WebElem searchBox = new WebElem(Element.LocatorType.byId,"kw","searchBox");


    public EBayHomePage() {
    }

    public void searchFor(String text) {
        searchBox.waitToBeVisible(30);
        searchBox.sendKeys(text);
        searchBox.submit();
    }


}
