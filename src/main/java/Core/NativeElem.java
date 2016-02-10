package Core;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

/**
 * Created by tescu on 2/2/16.
 */
public class NativeElem extends Element {

    private WebElement element;
    private String logName;
    private String  locator;

    public NativeElem(LocatorType locatorType,String locator, String logName) {

        switch (locatorType) {

            case byId:
                try {
                    logger.info("Execute: findElement(By.id("+locator+")");
                    this.element = getDriver().findElement(By.id(locator));
                }catch (Exception ex){
                    logger.info("Fail to execute: findElement(By.id("+locator+")");
                }
                this.logName = logName;
                this.locator = locator;
                break;
            case byCss:
                try {
                    logger.info("Execute: findElement(By.cssSelector("+locator+")");
                    this.element = getDriver().findElement(By.cssSelector(locator));
                }catch (Exception ex){
                    logger.info("Fail to execute: findElement(By.cssSelector("+locator+")");
                }
                this.logName = logName;
                this.locator = locator;
                break;
            case byName:
                try {
                    logger.info("Execute: findElement(By.name("+locator+")");
                    this.element = getDriver().findElement(By.name(locator));
                }catch (Exception ex){
                    logger.info("Fail to execute: findElement(By.name("+locator+")");
                }
                this.logName = logName;
                this.locator = locator;
                break;
            case byAccessibilityId:
                try {
                    logger.info("Execute: findElementByAccessibilityId("+locator+")");
                    this.element = getDriver().findElementByAccessibilityId(locator);
                }catch (Exception ex){
                    logger.info("Fail to execute: findElementByAccessibilityId("+locator+")");
                }
                this.logName = logName;
                this.locator = locator;
                break;
        }

    }


    @Override
    public void click() {
        try {
            logger.info("Execute: click("+logName+")");
            element.click();
        }catch (Exception ex){
            logger.info("Fail to execute click("+logName+")");
            Assert.fail("Action failed!");
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
            Assert.fail("Action failed!");
        }
        return elem;
    }

    @Override
    public void sendKeys(String text) {
        try {
            logger.info("Execute: sendKeys( "+logName+")");
            element.sendKeys(text);
        }catch (Exception ex){
            logger.info("Fail to execute: sendKeys("+logName+")");
            Assert.fail("Action failed!");
        }
    }

    @Override
    public void sendKeys(Keys key) {
        try {
            logger.info("Execute: sendKeys( "+logName+" )");
            element.sendKeys(key);
        }catch (Exception ex){
            logger.info("Fail to execute: sendKeys("+logName+")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * wait for the element to be visible
     * @param timeout - seconds
     */
    @Override
    public void waitToBeVisible(int timeout) {
        try {
            logger.info("Execute: waitToBeVisible("+logName+")");
            new WebDriverWait(getDriver(),timeout).until(ExpectedConditions.visibilityOf(element));
        }catch (Exception ex){
            logger.info("Fail to execute: waitToBeVisible("+logName+")");
            Assert.fail("Action failed!");
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
            new WebDriverWait(getDriver(),timeout).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
        }catch (Exception ex){
            logger.info("Fail to execute: waitToBeInvisible("+logName+")");
            Assert.fail("Action failed!");
        }
    }

    @Override
    public void clear() {
        try {
            logger.info("Execute: clear("+logName+")");
            element.clear();
        }catch (Exception ex){
            logger.info("Fail to execute: clear("+logName+")");
            Assert.fail("Action failed!");
        }

    }
}
