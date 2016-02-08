package Core;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by tescu on 2/1/16.
 */
public abstract class Element extends Base {

    public  enum LocatorType {
        byId, byName, byCss, byAccessibilityId, byXPath, byLinkText, byPartialLinkText, byTagName;
    }

    public abstract void click();

    public abstract String getText();

    public abstract void sendKeys(String text);

    public abstract void sendKeys(Keys key);

    public abstract void waitToBeVisible(int timeout);

    public abstract void waitToBeInvisible(int timeout);


}