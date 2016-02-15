package Core;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tescu on 2/1/16.
 */
public class Listener extends Base implements ITestListener {



    public void onTestStart(ITestResult iTestResult) {
        try {
            logger.info("Test started on "+getMachineName()+" machine");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        logger.info(">Start test method: "+iTestResult.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        logger.info(">Success testing method: "+iTestResult.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult iTestResult) {
        logger.info(">TestFail: "+iTestResult.getMethod().getMethodName()+" on "+iTestResult.getTestClass().getName()+" class ");

        Base.switchContentToNative();
        AppiumDriver driver = Base.getDriver();
        File location = new File("Screenshots");
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date date = new Date();
        String formatedDate = dateFormat.format(date).replace(' ','_');
        String packageClassName = iTestResult.getTestClass().getName();
        String methodName = iTestResult.getMethod().getMethodName();
        String screenShotName = location.getAbsoluteFile()+File.separator+packageClassName+"_"+methodName+"_"+formatedDate+".png";
        File screenShot = driver.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenShot,new File(screenShotName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }

}
