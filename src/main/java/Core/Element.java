package Core;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by tescu on 2/1/16.
 */
public abstract class Element extends Base {

    public abstract WebElement element(By locator);

    public abstract List<WebElement> elements(By locator);

    public abstract void click();

    public abstract String getText();

}