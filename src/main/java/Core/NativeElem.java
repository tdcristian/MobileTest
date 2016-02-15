package Core;

import io.appium.java_client.TouchAction;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
            case byClassName:
                try {
                    logger.info("Execute: findElementByClassName("+locator+")");
                    this.element = getDriver().findElementByClassName(locator);
                }catch (Exception ex){
                    logger.info("Fail to execute: findElementByClassName("+locator+")");
                }
                this.logName = logName;
                this.locator = locator;
                break;
        }

    }

    /**
     * Return WebElement set by constructor
     * @return WebElement
     */
    public WebElement getElement() {
        return element;
    }

    /**
     * Return logName set by constructor
     * @return logName
     */
    public String getLogName() {
        return logName;
    }

    /**
     * Return locator set by constructor
     * @return locator
     */
    public String getLocator() {
        return locator;
    }

    /**
     * Click on element
     */
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

    /**
     * Return the text contain by element
     * @return text
     */
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

    /**
     * Send text to element
     * @param text
     */
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

    /**
     * Send key to element
     * @param key
     */
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

    /**
     * Clear the field
     */
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

    /**
     * Long press an element
     */
    public void longPress() {

        try {
            logger.info("Execute: longPress("+logName+")");
            TouchAction touchAction = new TouchAction(getDriver());
            touchAction.longPress(element).perform();
        }catch (Exception ex){
            logger.info("Fail to execute: longPress("+logName+")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Scroll to text list element
     * @param text
     */
    public static void scrollTo(String text){
        try {
            logger.info("Execute: scrollTo("+text+")");
            getDriver().scrollTo(text);
        }catch (Exception ex){
            logger.info("Fail to execute: longPress("+text+")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Press on sourceElement and release it on targetElement. Both element should exist in page
     * @param sourceElement
     * @param targetElement
     */
    public static void pressOnAndMoveTo(NativeElem sourceElement, NativeElem targetElement) {

        try {
            WebElement source = sourceElement.getElement();
            WebElement target = targetElement.getElement();
            logger.info("Execute: pressOnAndMoveTo("+sourceElement.getLogName()+","+targetElement.getLogName()+")");
            TouchAction touchAction = new TouchAction(getDriver());
            touchAction.press(source).moveTo(target).release().perform();
        }catch (Exception ex){
            logger.info("Fail to execute: pressOnAndMoveTo("+sourceElement.getLogName()+","+targetElement.getLogName()+")");
            Assert.fail("Action failed!");
        }

    }

    /**
     * Press on sourceElement and release it on element which is not displayed yet
     * @param sourceElement
     * @param type
     * @param locator
     */
    public static void pressOnAndMoveToNotVisibleElement(NativeElem sourceElement, LocatorType type, String locator) {

        try{
            logger.info("Execute: pressOnAndMoveToNotVisibleElement("+sourceElement.getLogName()+","+locator+")");
            TouchAction touchAction = new TouchAction(getDriver());
            touchAction.press(sourceElement.getElement()).perform();
            NativeElem targetElement = new NativeElem(type,locator,locator);
            touchAction.moveTo(targetElement.getElement()).release().perform();
        }catch (Exception ex){
            logger.info("Fail to execute: pressOnAndMoveToNotVisibleElement("+sourceElement.getLogName()+","+locator+")");
            Assert.fail("Action failed!");
        }

    }

    /**
     * Accept alert
     */
    public void acceptAlert() {

        try {
            logger.info("Execute: acceptAlert("+logName+")");
            NativeElem yes = new NativeElem(LocatorType.byName,"Yes","Yes");
            yes.click();
        }catch (Exception ex){
            logger.info("Fail to execute: acceptAlert("+logName+")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Close alert
     */
    public void closeAlert() {
        try {
            logger.info("Execute: closeAlert("+logName+")");
            NativeElem no = new NativeElem(LocatorType.byName,"No","No");
            no.click();
        }catch (Exception ex){
            logger.info("Fail to execute: closeAlert("+logName+")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Scroll to text in the spinner
     * @param text
     */
    public void scrollToExact(String text) {
        try {
            logger.info("Execute: scrollToExact("+text+")");
            getDriver().scrollToExact(text);
        }catch (Exception ex){
            logger.info("Fail to execute: scrollToExact("+text+")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Move slider to percent %
     * @param percent
     */
    public void moveSliderTo(double percent) {

        int xAxisStartPoint = getElement().getLocation().getX();
        int xAxisEndPoint = xAxisStartPoint + getElement().getSize().getWidth();
        int yAxis = getElement().getLocation().getY();
        TouchAction act = new TouchAction(getDriver());
        act.press(xAxisStartPoint,yAxis).moveTo((int) (xAxisEndPoint*percent),yAxis).release().perform();

    }
}
