package com.datadriven.listeners;


import com.datadriven.base.TestBase;
import com.datadriven.utilities.TestUtil;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;

public class CustomListeners extends TestBase implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        test = rep.startTest(result.getName().toUpperCase());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
       /*** System.setProperty("org.uncommons.reportng.escape-output","false");
        Reporter.log("Login successfully executed!!");
        Reporter.log("<a target =\"_blank\" href=\"D:\\Screenshot\\Buddha.jpg\">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<a target =\"_blank\" href=\"D:\\Screenshot\\Buddha.jpg\"><img src=\"D:\\Screenshot\\Buddha.jpg\" height=200 width=200></img></a>");
    ***/
       test.log(LogStatus.PASS,result.getName().toUpperCase(),"Pass");
       rep.endTest(test);
       rep.flush();
        }

    @Override
    public void onTestFailure(ITestResult result) {
        System.setProperty("org.uncommons.reportng.escape-output","false");
        try {
            TestUtil.captureScreenshot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        Reporter.log("Capturing ScreenShot");
//        Reporter.log("<a target =\"_blank\" href="+TestUtil.scrnShotName+">Screenshot</a>");
//        Reporter.log("<br>");
//        Reporter.log("<a target =\"_blank\" href="+TestUtil.scrnShotName+"><img src="+TestUtil.scrnShotName+" height=200 width=200></img></a>");

        //EXtent Report
        test.log(LogStatus.FAIL,result.getName().toUpperCase(),"Fail with the exception: "+result.getThrowable());
        test.log(LogStatus.FAIL,test.addScreenCapture(TestUtil.scrnShotName));

        rep.endTest(test);
        rep.flush();

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
