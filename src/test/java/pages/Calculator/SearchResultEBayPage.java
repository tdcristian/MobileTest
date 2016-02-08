package pages.Calculator;

import Core.Base;
import Core.Element;
import Core.WebElem;

/**
 * Created by tescu on 2/8/16.
 */
public class SearchResultEBayPage extends Base {

    WebElem homeButton = new WebElem(Element.LocatorType.byCss,"a.homeicon","homeButton");
    WebElem list = new WebElem(Element.LocatorType.byCSSList,"div.stpFxht a","numberOfResults");

    public SearchResultEBayPage() {
    }

    public void goToGomePage(){
        homeButton.click();
    }

    public int getNumberOfResults(){
        list.waitListToBeVisible(30);
        return list.size();
    }

}
