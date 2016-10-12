package Core;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by tescu on 2/24/16.
 */
public class MobileElement extends Base {

    public enum LocatorType {
        byId, byName, byCss, byAccessibilityId, byXPath, byLinkText, byPartialLinkText, byTagName, byClassName,
        byCSSList;
    }

    private WebElement element;

    private List<MobileElement> elemList;

    private String logName;

    private String locator;

    public MobileElement(LocatorType locatorType, String locator, String logName) {

        switch (locatorType) {
            case byId:
                try {
                    logger.info("Execute: findElement(By.id(" + locator + ")");
                    this.element = getDriver().findElement(By.id(locator));
                } catch (Exception ex) {
                    logger.info("Fail to execute: findElement(By.id(" + locator + ")");
                }
                this.logName = logName;
                this.locator = locator;
                break;
            case byName:
                try {
                    logger.info("Execute: findElement(By.name(" + locator + ")");
                    this.element = getDriver().findElement(By.name(locator));
                } catch (Exception ex) {
                    logger.info("Fail to execute: findElement(By.name(" + locator + ")");
                }
                this.logName = logName;
                this.locator = locator;
                break;
            case byCss:
                try {
                    logger.info("Execute: findElement(By.cssSelector(" + locator + ")");
                    this.element = getDriver().findElement(By.cssSelector(locator));
                } catch (Exception ex) {
                    logger.info("Fail to execute: findElement(By.cssSelector(" + locator + ")");
                }
                this.logName = logName;
                this.locator = locator;
                break;
            case byLinkText:
                try {
                    logger.info("Execute: findElement(By.linkText(" + locator + ")");
                    this.element = getDriver().findElement(By.linkText(locator));
                } catch (Exception ex) {
                    logger.info("Fail to execute: findElement(By.linkText(" + locator + ")");
                }
                this.logName = logName;
                this.locator = locator;
                break;
            case byPartialLinkText:
                try {
                    logger.info("Execute: findElement(By.partialLinkText(" + locator + ")");
                    this.element = getDriver().findElement(By.partialLinkText(locator));
                } catch (Exception ex) {
                    logger.info("Fail to execute: findElement(By.partialLinkText(" + locator + ")");
                }
                this.logName = logName;
                this.locator = locator;
                break;
            case byTagName:
                try {
                    logger.info("Execute: findElement(By.tagName(" + locator + ")");
                    this.element = getDriver().findElement(By.tagName(locator));
                } catch (Exception ex) {
                    logger.info("Fail to execute: findElement(By.tagName(" + locator + ")");
                }
                this.logName = logName;
                this.locator = locator;
                break;
            case byClassName:
                try {
                    logger.info("Execute: findElement(By.className(" + locator + ")");
                    this.element = getDriver().findElement(By.className(locator));
                } catch (Exception ex) {
                    logger.info("Fail to execute: findElement(By.className(" + locator + ")");
                }
                this.logName = logName;
                this.locator = locator;
                break;
            case byXPath:
                try {
                    logger.info("Execute: findElement(By.xpath(" + locator + ")");
                    this.element = getDriver().findElement(By.xpath(locator));
                } catch (Exception ex) {
                    logger.info("Fail to execute: findElement(By.xpath(" + locator + ")");
                }
                this.logName = logName;
                this.locator = locator;
                break;
            case byAccessibilityId:
                try {
                    logger.info("Execute: findElementByAccessibilityId(" + locator + ")");
                    this.element = getDriver().findElementByAccessibilityId(locator);
                } catch (Exception ex) {
                    logger.info("Fail to execute: findElementByAccessibilityId(" + locator + ")");
                }
                this.logName = logName;
                this.locator = locator;
                break;
            case byCSSList:
                try {
                    logger.info("Execute: findElements(By.cssSelector(" + locator + ")");
                    this.elemList = getDriver().findElements(By.cssSelector(locator));
                } catch (Exception ex) {
                    logger.info("Fail to execute: findElements(By.cssSelector(" + locator + ")");
                }
                this.logName = logName;
                this.locator = locator;
                break;
        }
    }

    /**
     * Return WebElement set by constructor
     *
     * @return WebElement
     */
    public WebElement getElement() {
        return element;
    }

    /**
     * Return logName set by constructor
     *
     * @return logName
     */
    public String getLogName() {
        return logName;
    }

    /**
     * Return locator set by constructor
     *
     * @return locator
     */
    public String getLocator() {
        return locator;
    }

    /**
     * Return number of elements pointed by css locator
     *
     * @return number
     */
    public int size() {
        int number = 0;
        try {
            logger.info("Execute: size(" + logName + ")");
            number = elemList.size();
        } catch (Exception ex) {
            logger.info("Fail to execute: size(" + logName + ")");
            Assert.fail("Action failed!");
        }
        return number;
    }

    /**
     * Click on element
     */
    public void click() {
        try {
            logger.info("Execute: click(" + logName + ")");
            element.click();
        } catch (Exception ex) {
            logger.info("Fail to execute click(" + logName + ")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Return text on element
     *
     * @return text
     */
    public String getText() {
        String elem = null;
        try {
            logger.info("Execute: getText(" + logName + ")");
            elem = element.getText();
        } catch (Exception ex) {
            logger.info("Fail to execute: getText(" + logName + ")");
            Assert.fail("Action failed!");
        }
        return elem;
    }

    /**
     * Send text to element
     *
     * @param text
     */
    public void sendKeys(String text) {
        try {
            logger.info("Execute: sendKeys(" + logName + ")");
            element.sendKeys(text);
        } catch (Exception ex) {
            logger.info("Fail to execute: sendKeys(" + logName + ")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Sent key to element
     *
     * @param key
     */
    public void sendKeys(Keys key) {
        try {
            logger.info("Execute: sendKeys( " + logName + ")");
            element.sendKeys(key);
        } catch (Exception ex) {
            logger.info("Fail to execute: sendKeys(" + logName + ")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Wait element to be visible in <b>timeout</b> milliseconds
     *
     * @param timeout
     */
    public void waitToBeVisible(int timeout) {
        try {
            logger.info("Execute: waitToBeVisible(" + logName + ")");
            new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception ex) {
            logger.info("Fail to execute: waitToBeVisible( " + logName + ")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Wait element for <b>timeout</b> millisecond to be invisible
     *
     * @param timeout
     */
    public void waitToBeInvisible(int timeout) {
        try {
            logger.info("Execute: waitToBeInvisible(" + logName + ")");
            new WebDriverWait(getDriver(), timeout).until(
                    ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
        } catch (Exception ex) {
            logger.info("Fail to execute: waitToBeInvisible( " + logName + ")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Wait for element for <b>timeout</b> milliseconds to became staleness
     *
     * @param timeout milliseconds
     */

    public void waitForStalenessOfElement(int timeout) {
        try {
            logger.info("Execute: waitForStalenessOfElement(" + logName + ")");
            new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.stalenessOf(element));
        } catch (Exception ex) {
            logger.info("Fail to execute: waitForStalenessOfElement(" + logName + ")");
        }
    }

    /**
     * Wait for element located by <b>css locator</b> for <b>timeout</b> milliseconds for be visible
     *
     * @param timeout - milliseconds
     */

    public void visibilityOfElementLocatedByCss(int timeout) {
        try {
            logger.info("Execute: visibilityOfElementLocatedByCss(" + logName + ")");
            new WebDriverWait(getDriver(), timeout).until(
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
        } catch (Exception ex) {
            logger.info("Fail to execute: visibilityOfElementLocatedByCss(" + logName + ")");
        }
    }

    /**
     * Wait for element for <b>15 seconds</b> pooling every <b>500 milliseconds</b>
     */
    public static Wait wait = new FluentWait<AndroidDriver>(getDriver())
            .withTimeout(15, TimeUnit.SECONDS)
            .pollingEvery(500, TimeUnit.MILLISECONDS)
            .ignoring(NoSuchElementException.class)
            .withMessage("Element not displayed on page");

    /**
     * Find element by ID providing locator
     */
    public Function<AndroidDriver, WebElement> elementIsFoundById = new Function<AndroidDriver, WebElement>() {
        public WebElement apply(AndroidDriver input) {
            return input.findElementById(locator);
        }
    };

    /**
     * Find element by Accessibility Id providing locator 
     */
    public Function<AndroidDriver, WebElement> elementIsFoundByAccesibilityId = new Function<AndroidDriver, 
            WebElement>() {
        public WebElement apply(AndroidDriver input) {
            return input.findElementByAccessibilityId(locator);
        }
    };

    /**
     * Clear the field
     */
    public void clear() {
        try {
            logger.info("Execute: clear( " + logName + ")");
            element.clear();
        } catch (Exception ex) {
            logger.info("Fail to execute: clear(" + logName + ")");
            Assert.fail("Action failed!");
        }

    }

    /**
     * Submit the form
     */
    public void submit() {
        try {
            logger.info("Execute: submit(" + logName + ")");
            element.submit();
        } catch (Exception ex) {
            logger.info("Fail to execute: submit(" + logName + ")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Wait <b>timeout</b> milliseconds for the element to be visible
     *
     * @param timeout
     */
    public void waitListToBeVisibleByCss(int timeout) {
        try {
            logger.info("Execute: waitListToBeVisibleByCss(" + logName + ")");
            new WebDriverWait(getDriver(), timeout).until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(locator)));
        } catch (Exception ex) {
            logger.info("Fail to execute: waitListToBeVisibleByCss(" + logName + ")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Long press an element
     */
    public void longPress() {

        try {
            logger.info("Execute: longPress(" + logName + ")");
            TouchAction touchAction = new TouchAction(getDriver());
            touchAction.longPress(element).perform();
        } catch (Exception ex) {
            logger.info("Fail to execute: longPress(" + logName + ")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Scroll to text list element
     *
     * @param text
     */
    public static void scrollTo(String text) {
        try {
            logger.info("Execute: scrollTo(" + text + ")");
            getDriver().scrollTo(text);
        } catch (Exception ex) {
            logger.info("Fail to execute: longPress(" + text + ")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Press on sourceElement and release it on targetElement. Both element should exist in page
     *
     * @param sourceElement
     * @param targetElement
     */
    public static void pressOnAndMoveTo(MobileElement sourceElement, MobileElement targetElement) {

        try {
            WebElement source = sourceElement.getElement();
            WebElement target = targetElement.getElement();
            logger.info(
                    "Execute: pressOnAndMoveTo(" + sourceElement.getLogName() + "," + targetElement.getLogName() + ")");
            TouchAction touchAction = new TouchAction(getDriver());
            touchAction.press(source).moveTo(target).release().perform();
        } catch (Exception ex) {
            logger.info(
                    "Fail to execute: pressOnAndMoveTo(" + sourceElement.getLogName() + "," + targetElement
                            .getLogName() + ")");
            Assert.fail("Action failed!");
        }

    }

    /**
     * Press on sourceElement and release it on element which is not displayed yet
     *
     * @param sourceElement
     * @param type
     * @param locator
     */
    public static void pressOnAndMoveToNotVisibleElement(MobileElement sourceElement, MobileElement.LocatorType type,
                                                         String locator) {

        try {
            logger.info(
                    "Execute: pressOnAndMoveToNotVisibleElement(" + sourceElement.getLogName() + "," + locator + ")");
            TouchAction touchAction = new TouchAction(getDriver());
            touchAction.press(sourceElement.getElement()).perform();
            MobileElement targetElement = new MobileElement(type, locator, locator);
            touchAction.moveTo(targetElement.getElement()).release().perform();
        } catch (Exception ex) {
            logger.info(
                    "Fail to execute: pressOnAndMoveToNotVisibleElement(" + sourceElement.getLogName() + "," +
                            locator + ")");
            Assert.fail("Action failed!");
        }

    }

    /**
     * Accept alert
     */
    public void acceptAlert() {

        try {
            logger.info("Execute: acceptAlert(" + logName + ")");
            MobileElement yes = new MobileElement(MobileElement.LocatorType.byName, "Yes", "Yes");
            yes.click();
        } catch (Exception ex) {
            logger.info("Fail to execute: acceptAlert(" + logName + ")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Close alert
     */
    public void closeAlert() {
        try {
            logger.info("Execute: closeAlert(" + logName + ")");
            MobileElement no = new MobileElement(MobileElement.LocatorType.byName, "No", "No");
            no.click();
        } catch (Exception ex) {
            logger.info("Fail to execute: closeAlert(" + logName + ")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Scroll to text in the spinner
     *
     * @param text
     */
    public void scrollToExact(String text) {
        try {
            logger.info("Execute: scrollToExact(" + text + ")");
            getDriver().scrollToExact(text);
        } catch (Exception ex) {
            logger.info("Fail to execute: scrollToExact(" + text + ")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Move slider to percent %
     *
     * @param percent
     */
    public void moveSliderTo(double percent) {

        int xAxisStartPoint = getElement().getLocation().getX();
        int xAxisEndPoint = xAxisStartPoint + getElement().getSize().getWidth();
        int yAxis = getElement().getLocation().getY();
        TouchAction act = new TouchAction(getDriver());
        act.press(xAxisStartPoint, yAxis).moveTo((int) (xAxisEndPoint * percent), yAxis).release().perform();

    }
}
