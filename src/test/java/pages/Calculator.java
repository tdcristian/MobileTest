package pages;

import Core.MobileElement;

/**
 * Created by tescu on 2/3/16.
 */
public class Calculator {

    public MobileElement five = new MobileElement(MobileElement.LocatorType.byId,"com.android.calculator2:id/digit_5","five");
    public MobileElement plus = new MobileElement(MobileElement.LocatorType.byId,"com.android.calculator2:id/op_add","plus");
    public MobileElement four = new MobileElement(MobileElement.LocatorType.byId,"com.android.calculator2:id/digit_4","four");
    public MobileElement equals = new MobileElement(MobileElement.LocatorType.byAccessibilityId,"equals","Equal");
    public MobileElement value = new MobileElement(MobileElement.LocatorType.byId,"com.android.calculator2:id/formula","value");

    public Calculator() {
    }

    public void addNumbers(MobileElement element1, MobileElement element2) {
        System.out.println("element1.getLocator() = " + element1.getLocator());
        System.out.println("element2.getLocator() = " + element2.getLocator());

        MobileElement.wait.until(element1.isFoundById);
        MobileElement.wait.until(equals.isFoundByAccesibilityId);
        
        element1.waitToBeVisible(15);
        equals.waitToBeVisible(15);
        
        element1.click();
        this.plus.click();
        element2.click();
        this.equals.click();
        
        
    }
}
