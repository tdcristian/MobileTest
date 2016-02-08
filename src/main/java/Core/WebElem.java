package Core;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by tescu on 2/2/16.
 */
public class WebElem extends Element {

    private WebElement element;
    private List<WebElem> elemList;
    private String logName;
    private String locator;

    public WebElem(LocatorType locatorType, String locator, String logName) {

        switch (locatorType){
            case byId:
                this.element = getDriver().findElement(By.id(locator));
                this.logName = logName;
                this.locator = locator;
                break;
            case byName:
                this.element = getDriver().findElement(By.name(locator));
                this.logName = logName;
                this.locator = locator;
                break;
            case byCss:
                this.element = getDriver().findElement(By.cssSelector(locator));
                this.logName = logName;
                this.locator = locator;
                break;
            case byLinkText:
                this.element = getDriver().findElement(By.linkText(locator));
                this.logName = logName;
                this.locator = locator;
                break;
            case byPartialLinkText:
                this.element = getDriver().findElement(By.partialLinkText(locator));
                this.logName = logName;
                this.locator = locator;
                break;
            case byTagName:
                this.element = getDriver().findElement(By.tagName(locator));
                this.logName = logName;
                this.locator = locator;
                break;
            case byXPath:
                this.element = getDriver().findElement(By.xpath(locator));
                this.logName = logName;
                this.locator = locator;
                break;
            case byCSSList:
                this.elemList = getDriver().findElements(By.cssSelector(locator));
                this.logName = logName;
                this.locator = locator;
        }
    }

    public int size(){
        int number = 0;
        try {
            logger.info("Execute: size("+logName+")");
            number = elemList.size();
        }catch (Exception ex){
            logger.info("Fail to execute: size("+logName+")");
        }
        return number;
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
    public void sendKeys(String text) {
        try {
            logger.info("Execute: sendKeys("+logName+")");
            element.sendKeys(text);
        }catch (Exception ex){
            logger.info("Fail to execute: sendKeys("+logName+")");
        }
    }

    @Override
    public void sendKeys(Keys key) {
        try {
            logger.info("Execute: sendKeys("+logName+")");
            element.sendKeys(key);
        }catch (Exception ex){
            logger.info("Fail to execute: sendKeys("+logName+")");
        }
    }


    @Override
    public void waitToBeVisible(int timeout) {
        try {
            logger.info("Execute: waitToBeVisible("+logName+")");
            new WebDriverWait(getDriver(),timeout).until(ExpectedConditions.visibilityOf(element));
        }catch (Exception ex){
            logger.info("Fail to execute: waitToBeVisible("+logName+")");
        }
    }

    @Override
    public void waitToBeInvisible(int timeout) {
        try {
            logger.info("Execute: waitToBeInvisible("+logName+")");
            new WebDriverWait(getDriver(),timeout).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
        }catch (Exception ex){
            logger.info("Fail to execute: waitToBeInvisible("+logName+")");
        }
    }

    public void submit() {
        try {
            logger.info("Execute: submit("+logName+")");
            element.submit();
        }catch (Exception ex){
            logger.info("Fail to execute: submit("+logName+")");
        }
    }

    public void waitListToBeVisible(int timeout) {
        try {
            logger.info("Execute: waitListToBeVisible("+logName+")");
            new WebDriverWait(getDriver(),timeout).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(locator)));
        }catch (Exception ex){
            logger.info("Fail to execute: waitListToBeVisible("+logName+")");
        }
    }
}
