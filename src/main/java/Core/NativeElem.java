package Core;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by tescu on 2/2/16.
 */
public class NativeElem extends Element {

    private WebElement element;
    private String logName;
    private List<WebElement> elements;
    private By locator;

    public NativeElem(By locator, String logName) {
        this.element = getDriver().findElement(locator);
        this.logName = logName;
        this.locator = locator;
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

    @Override
    public void toBeVisible(int timeout) {
        try {
            logger.info("Execute: toBeVisible("+logName+")");
            new WebDriverWait(getDriver(),timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (Exception ex){
            logger.info("Fail to execute: toBeVisible("+logName+")");
        }
    }

    @Override
    public void toBeInvisible(int timeout) {
        try {
            logger.info("Execute: toBeInvisible("+logName+")");
            new WebDriverWait(getDriver(),timeout).until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }catch (Exception ex){
            logger.info("Fail to execute: toBeInvisible("+logName+")");
        }
    }

}
