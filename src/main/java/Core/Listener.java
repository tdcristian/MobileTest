package Core;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tescu on 2/1/16.
 */
public class Listener extends TestListenerAdapter {

    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Start test method: "+iTestResult.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Success testing method: "+iTestResult.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("TestFail: "+iTestResult.getMethod().getMethodName());
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

}
