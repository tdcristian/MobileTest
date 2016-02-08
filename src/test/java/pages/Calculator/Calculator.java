package pages.Calculator;

import Core.Element;
import Core.NativeElem;

/**
 * Created by tescu on 2/3/16.
 */
public class Calculator {

    public NativeElem five = new NativeElem(Element.LocatorType.byName,"5","five");
    public NativeElem plus = new NativeElem(Element.LocatorType.byName,"+","plus");
    public NativeElem four = new NativeElem(Element.LocatorType.byName,"4","four");
    public NativeElem equals = new NativeElem(Element.LocatorType.byAccessibilityId,"equals","Equal");
    public NativeElem value = new NativeElem(Element.LocatorType.byId,"com.android.calculator2:id/formula","value");

    public Calculator() {
    }

    public void addNumbers(Element five, Element four) {
        this.five.waitToBeVisible(10);
        this.five.click();
        this.plus.click();
        this.four.click();
        this.equals.click();

    }
}
