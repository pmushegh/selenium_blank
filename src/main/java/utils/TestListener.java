package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info("## " + getTestMethodName(iTestResult) + " test method started.");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info("## " + getTestMethodName(iTestResult) + " test method succeed.");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.info("## " + getTestMethodName(iTestResult) + " test method failed.");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.info("## " + getTestMethodName(iTestResult) + " test method skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.info("## " + getTestMethodName(iTestResult) + " test method failed within success %.");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Log.info("#### " + iTestContext.getName() + " test classes started.");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.info("#### " + iTestContext.getName() + " test test classes finished.");
    }

    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }
}
