package Core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by tescu on 2/2/16.
 */
public class WebElem extends Element {


    public WebElement element(By locator) {

        return getDriver().findElement(locator);
    }

    public List<WebElement> elements(By locator) {

        return getDriver().findElements(locator);
    }

    @Override
    public void click() {

    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public void waitToBeVisible(int timeout) {

    }

    @Override
    public void waitToBeInvisible(int timeout) {

    }
}
