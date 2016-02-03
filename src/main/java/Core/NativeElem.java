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

    /**
     * wait for the element to be visible
     * @param timeout - seconds
     */
    @Override
    public void waitToBeVisible(int timeout) {
        try {
            logger.info("Execute: waitToBeVisible("+logName+")");
            new WebDriverWait(getDriver(),timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (Exception ex){
            logger.info("Fail to execute: waitToBeVisible("+logName+")");
        }
    }

    /**
     * wait for the element to be invisible
     * @param timeout - seconds
     */
    @Override
    public void waitToBeInvisible(int timeout) {
        try {
            logger.info("Execute: waitToBeInvisible("+logName+")");
            new WebDriverWait(getDriver(),timeout).until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }catch (Exception ex){
            logger.info("Fail to execute: waitToBeInvisible("+logName+")");
        }
    }

}
