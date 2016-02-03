package Core;

import org.openqa.selenium.By;

import java.util.List;

/**
 * Created by tescu on 2/2/16.
 */
public class WebElem extends Element {


    @Override
    public org.openqa.selenium.WebElement element(By locator) {
        return null;
    }

    @Override
    public List<org.openqa.selenium.WebElement> elements(By locator) {
        return null;
    }

    @Override
    public void click() {

    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public void toBeVisible(int timeout) {

    }

    @Override
    public void toBeInvisible(int timeout) {

    }
}
