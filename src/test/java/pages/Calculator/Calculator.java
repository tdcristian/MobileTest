package pages.Calculator;

import Core.Element;
import Core.NativeElem;
import org.openqa.selenium.By;

/**
 * Created by tescu on 2/3/16.
 */
public class Calculator {

    public NativeElem five = new NativeElem(By.name("5"),"five");
    public NativeElem plus = new NativeElem(By.name("+"),"plus");
    public NativeElem four = new NativeElem(By.name("4"),"four");
    public NativeElem equals = new NativeElem("equals","Equal");
    public NativeElem value = new NativeElem(By.id("com.android.calculator2:id/formula"),"value");

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
