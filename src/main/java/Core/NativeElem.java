package Core;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by tescu on 2/2/16.
 */
public class NativeElem extends Element {

    private WebElement element;
    private String logName;
    private List<WebElement> elements;

    public NativeElem(By locator, String logName) {
        this.element = getDriver().findElement(locator);
        this.logName = logName;
    }


    public NativeElem(String accessibilityId,String logName) {
        this.element = getDriver().findElementByAccessibilityId(accessibilityId);
        this.logName = logName;
    }


    @Override
    public WebElement element(By locator) {

        return getDriver().findElement(locator);
    }

    @Override
    public List<WebElement> elements(By locator) {

        return getDriver().findElements(locator);
    }

    @Override
    public void click() {
        try {
            logger.info("Execute: click("+logName+")");
            element.click();
        }catch (Exception ex){
            logger.info("Fail to execute click("+logName+")");
        }
    }

    @Override
    public String getText() {
        String elem = null;
        try {
            logger.info("Execute: getText("+logName+")");
            elem = element.getText();
        }catch (Exception ex){
            logger.info("Fail to execute: getText("+logName+")");
        }
        return elem;
    }


}
