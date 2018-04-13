package com.automation.listener;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

import com.automation.base.BaseClass;
import com.automation.extentreport.ExtentManager;
import com.automation.extentreport.ExtentTestManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestCaseListener  extends BaseClass implements ITestListener

{
	BaseClass base;
	
	
	private   static  String testcase;

	private static String getTestMethodName(ITestResult iTestResult)
	{
        return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	public void onFinish(ITestContext iTestContext) {
		System.out.println("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
		
	}

	
	public void onStart(ITestContext iTestContext) {
		System.out.println("I am in onStart method " + iTestContext.getName());
     //   iTestContext.setAttribute("WebDriver", this.driver);
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));

		
	}

    
	public void onTestFailure(ITestResult iTestResult) {
	System.out.println("Test Case FAILED--> "+testcase);
	 
	//  logger.log(LogStatus.FAIL, "Test Case Failed is -->  '"+testcase+"'  ");
	
    ExtentTestManager.getTest().log(LogStatus.PASS, "Test Failed");
  //Get driver from BaseTest and assign to local webdriver variable.
    Object testClass = iTestResult.getInstance();
    WebDriver webDriver = ((BaseClass) testClass).getDriver();

    //Take base64Screenshot screenshot.
    String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
            getScreenshotAs(OutputType.BASE64);

    //Extentreports log and screenshot operations for failed tests.
    ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
    ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
}

	
     
	
	

	
	public void onTestSkipped(ITestResult iTestResult) {
		 System.out.println("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
	        //Extentreports log operation for skipped tests.
	        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
		
	}

	
	public void onTestStart(ITestResult iTestResult)  {
		System.out.println("-------------- ON TEST START -----------------");
	    testcase = 	iTestResult.getName();
	   System.out.println("Starting the TestCase ==> "+testcase);
	//   ExtentTestManager.startTest(testcase, "Test Started");
	 //  logger = exreport.startTest(testcase,"Test Started"); 
	//   logger.log(LogStatus.INFO, "Test Case  Started is --> '"+testcase+"' ");
	   
	   
	   ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");
	}

	
	public void onTestSuccess(ITestResult arg0) {
	System.out.println("Test Case Completed-->"+testcase);
	// logger.log(LogStatus.PASS, "Test Case  Passed is --> '"+testcase+"' ");
	ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
	
	}
	
	public String getTestcase() {
		return testcase;
	}

	public void setTestcase(String testcase) {
		this.testcase = testcase;
	}

}
