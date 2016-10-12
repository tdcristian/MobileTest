package pages;

import Core.MobileElement;

/**
 * Created by tescu on 2/8/16.
 */
public class SearchResultEBayPage {

    MobileElement homeButton = new MobileElement(MobileElement.LocatorType.byCss,"a.homeicon","homeButton");
//    MobileElement list = new MobileElement(MobileElement.LocatorType.byCSSList,"div.stpFxht a","numberOfResults");
    MobileElement list = new MobileElement(MobileElement.LocatorType.byCSSList,"div#itemDiv a","numberOfResults");

    public SearchResultEBayPage() {
    }

    public void goToHomePage(){
        homeButton.click();
    }

    public int getNumberOfResults(){
        list.waitListToBeVisibleByCss(30);
        return list.size();
    }

}
