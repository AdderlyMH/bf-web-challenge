package components;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.ExtReport;

public class Listeners extends TestBase implements ITestListener {

    ExtentTest test;
    ExtentReports reports = ExtReport.reportSettings();
    ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = reports.createTest(result.getMethod().getMethodName());
        threadLocal.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        threadLocal.get().log(Status.PASS, "Successful Test");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        threadLocal.get().fail(result.getThrowable());

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        String screenshotPath = null;
        try {
            screenshotPath = getTestScreenshot(result.getMethod().getMethodName(), driver);
        } catch (Exception e2) {
            e2.printStackTrace();
        }

        threadLocal.get().addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());

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
        reports.flush();
    }

}
