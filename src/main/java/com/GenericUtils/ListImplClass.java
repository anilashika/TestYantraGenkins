package com.GenericUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListImplClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		
		test=report.createTest(methodname);
		Reporter.log(methodname+"--->Execution starts");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		test.log(Status.PASS,methodname+"---->Passed");
		Reporter.log(methodname+"---Testscript executed sucessfully");+
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try
		{
    String methodname=result.getMethod().getMethodName();
    String screenshot=WebDriverUtils.getScreenShot(BaseClass.driver, methodname);
    test.log(Status.FAIL, methodname+"--->Testscript failed");
    test.log(Status.FAIL, result.getThrowable());
    Reporter.log(methodname+"--->failed");
    test.addScreenCaptureFromPath(screenshot);
    
	
}
catch (Throwable e)
{
	e.printStackTrace();
}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
	    test.log(Status.SKIP, methodname+"--->skipped");
	    test.log(Status.SKIP, result.getThrowable());
	    Reporter.log(methodname+"--->Skipped");
	 
	    

	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
	htmlreport.config().setDocumentTitle("onlineshoppingapplication");
	htmlreport.config().setTheme(Theme.STANDARD);
	htmlreport.config().setReportName("Berluti");
	 report =new ExtentReports();
	report.attachReporter(htmlreport);
	report.setSystemInfo("Base platform","windows 10");
	report.setSystemInfo("Base Browser","chrome");
	report.setSystemInfo("Base URL","http://rmgtestingserver/domain/online_shopping_Application/login.php");
	report.setSystemInfo("Reporter Name","Anitha");
	}

	@Override
	public void onFinish(ITestContext context) {
    report.flush();
	}

}
