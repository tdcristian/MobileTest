package pages;

import Core.MobileElement;

/**
 * Created by tescu on 2/3/16.
 */
public class Calculator {

    public MobileElement five = new MobileElement(MobileElement.LocatorType.byName,"5","five");
    public MobileElement plus = new MobileElement(MobileElement.LocatorType.byName,"+","plus");
    public MobileElement four = new MobileElement(MobileElement.LocatorType.byName,"4","four");
    public MobileElement equals = new MobileElement(MobileElement.LocatorType.byAccessibilityId,"equals","Equal");
    public MobileElement value = new MobileElement(MobileElement.LocatorType.byId,"com.android.calculator2:id/formula","value");

    public Calculator() {
    }

    public void addNumbers(MobileElement five, MobileElement four) {
        this.five.waitToBeVisible(10);
        this.five.click();
        this.plus.click();
        this.four.click();
        this.equals.click();

    }
}
