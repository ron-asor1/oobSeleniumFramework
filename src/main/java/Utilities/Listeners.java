package Utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends Base implements ITestListener  {
    /*
        Listeners are functions which always react upon a given status of the test itself, this will allow us
        to take actions using code or extensions when a test has failed or passed or even when the test started or ended.
     */

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("------------------ Starting test: " + iTestResult.getName() + "------------------");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("------------------" + iTestResult.getName() + " Test Passed------------------");
        //Stop recording
        try {
            MonteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Delete recorded file
        File file = new File("./test-recordings/" + iTestResult.getName() + ".avi");
        if (file.delete()){
            System.out.println("File deleted successfully");
        }else{
            System.out.println("Failed to delete file");
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("------------------ " + iTestResult.getName() + " Test Failed------------------");
        //stop recording
        try {
            MonteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Screenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("------------------ Skipping test: " + iTestResult.getName() + "------------------");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        //TODO implemenet in future
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("-------------- Starting Execution ---------------");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("-------------- Ending Execution -----------------");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte [] Screenshot(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
