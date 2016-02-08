package Core;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by tescu on 2/1/16.
 */
public abstract class Base {

    protected static AndroidDriver driver;
    public static org.apache.log4j.Logger logger;

    public static AndroidDriver setDriver(DesiredCapabilities caps) throws MalformedURLException {
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        return driver;
    }

    public static AndroidDriver getDriver(){
        return driver;
    }

    protected static String getMachineName() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }

    public static String getCurrentDateInSpecifiedFormat(String dateF)
    {
        DateFormat dateFormat = new SimpleDateFormat(dateF);
        java.util.Date date = new java.util.Date();
        String dateStr = dateFormat.format(date);
        return dateStr;
    }

    protected static void implicitWait(int seconds){
        getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    @BeforeClass
    public void setUp() throws IOException {

        System.setProperty("log4j.defaultInitOverride","true");
        logger = Logger.getLogger("MobileTesting");
        Properties logConfiProps = new Properties();
        InputStream inputStream = Base.class.getClassLoader().getResourceAsStream("log4j.properties");
        logConfiProps.load(inputStream);
        Enumeration<?> enumProps = logConfiProps.propertyNames();

        String key;
        String relativePath = logConfiProps.getProperty("log4j.appender.R.File");
        while (enumProps.hasMoreElements()){
            key = (String) enumProps.nextElement();
            if (key.equals("log4j.appender.R.File")){
                logConfiProps.setProperty(key,System.getProperty("user.dir")+relativePath+Base.getCurrentDateInSpecifiedFormat("_yyyy_MMM_dd_")+"MyTestSuite"+".csv");
                break;
            }
        }

        PropertyConfigurator.configure(logConfiProps);
        logger.info("----------------------------------------------------------------------------");
        System.out.println("Logs saved in: "+logConfiProps.getProperty("log4j.appender.R.File"));

    }

    @AfterClass
    public void tearDown(){

        logger.info("$$$$ Test ended! $$$$");
        logger.info("----------------------------------------------------------------------------");
    }


}
