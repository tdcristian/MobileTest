package pages.Calculator;

import Core.Base;
import Core.Element;
import Core.WebElem;

/**
 * Created by tescu on 2/8/16.
 */
public class SearchResultEBayPage extends Base {

    WebElem homeButton = new WebElem(Element.LocatorType.byCss,"a.homeicon","homeButton");

    public SearchResultEBayPage() {
    }

    public void goToGomePage(){
        homeButton.click();
    }

}
