package Core;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by tescu on 2/1/16.
 */
public abstract class Base {

    protected static AndroidDriver driver;

    protected static org.apache.log4j.Logger logger;

    private static String environmentToRun;

    public static AndroidDriver setDriver(DesiredCapabilities caps) throws IOException, InterruptedException {

        Properties chooseEnvironment = new Properties();
        InputStream inputStream = Base.class.getClassLoader().getResourceAsStream("automation.properties");
        chooseEnvironment.load(inputStream);
        environmentToRun = chooseEnvironment.getProperty("environmentToRun");

        if (environmentToRun.equals("Local")) {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps); // For local server
            Base.implicitWait(45);
        } else if (environmentToRun.equals("Grid")) {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), caps); // For Grid
        }
        return driver;
    }

    /**
     * @return driver - return android driver
     */
    public static AndroidDriver getDriver() {
        return driver;
    }

    /**
     * @return machine name
     * @throws UnknownHostException
     */
    protected static String getMachineName() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }

    /**
     * @param dateF date format
     * @return date according to the chosen format
     */
    public static String getCurrentDateInSpecifiedFormat(String dateF) {
        DateFormat dateFormat = new SimpleDateFormat(dateF);
        java.util.Date date = new java.util.Date();
        String dateStr = dateFormat.format(date);
        return dateStr;
    }

    /**
     * Set implicit wait
     *
     * @param seconds number of seconds set for implicit wait
     */
    protected static void implicitWait(int seconds) {
        getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {

        System.setProperty("log4j.defaultInitOverride", "true");
        logger = Logger.getLogger("MobileTesting");
        Properties logConfiProps = new Properties();
        InputStream inputStream = Base.class.getClassLoader().getResourceAsStream("log4j.properties");
        logConfiProps.load(inputStream);
        Enumeration<?> enumProps = logConfiProps.propertyNames();

        String key;
        String relativePath = logConfiProps.getProperty("log4j.appender.R.File");
        while (enumProps.hasMoreElements()) {
            key = (String) enumProps.nextElement();
            if (key.equals("log4j.appender.R.File")) {
                logConfiProps.setProperty(key,
                        System.getProperty("user.dir") + relativePath + Base.getCurrentDateInSpecifiedFormat(
                                "_yyyy_MMM_dd_") + "MyTestSuite" + ".csv");
                break;
            }
        }

        PropertyConfigurator.configure(logConfiProps);
        logger.info("----------------------------------------------------------------------------");
        logger.info("$$$$ Test started! $$$$");
        logger.info("----------------------------------------------------------------------------");
        System.out.println("Logs saved in: " + logConfiProps.getProperty("log4j.appender.R.File"));

    }

    @AfterClass
    public void tearDown() {
        logger.info("----------------------------------------------------------------------------");
        logger.info("$$$$ Test ended! $$$$");
        logger.info("----------------------------------------------------------------------------");
    }

    /**
     * Hide keyboard
     */
    public static void hideKeyboard() {

        try {
            logger.info("Execute: hideKeyboard()");
            Thread.sleep(1000);
            getDriver().hideKeyboard();
        } catch (Exception ex) {
            logger.info("Fail to execute: hideKeyboard()");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Switch to web content
     */
    public static void switchContentToWeb() {

        String contentName = null;
        try {
            Set<String> contents = getDriver().getContextHandles();
            for (String context : contents) {
                logger.info("context = " + context);
            }
            getDriver().context((String) contents.toArray()[1]);
            contentName = (String) contents.toArray()[1];
            logger.info("Execute: switchContentToWeb(" + contents.toArray()[1] + ")");
        } catch (Exception ex) {
            logger.info("Fail to execute: switchContentToWeb(" + contentName + ")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Switch to native content
     */
    public static void switchContentToNative() {

        String contentName = null;
        try {
            Set<String> contents = getDriver().getContextHandles();
            for (String context : contents) {
                logger.info("context = " + context);
            }
            getDriver().context((String) contents.toArray()[0]);
            contentName = (String) contents.toArray()[0];
            logger.info("Execute: switchContentToNative(" + contents.toArray()[0] + ")");
        } catch (Exception ex) {
            logger.info("Fail to execute: switchContentToNative(" + contentName + ")");
            Assert.fail("Action failed!");
        }
    }

    /**
     * Enter keyCode from mobile keyboard
     *
     * @param keyCode AndroidKeyCode code (Ex AndroidKeyCode.HOME)
     */
    public static void pressKeyCode(int keyCode) {

        try {
            logger.info("Execute: pressKeyCode(" + keyCode + ")");
            getDriver().pressKeyCode(keyCode);
        } catch (Exception ex) {
            logger.info("Fail to execute: pressKeyCode(" + keyCode + ")");
            Assert.fail("Action failed!");
        }

    }
}
