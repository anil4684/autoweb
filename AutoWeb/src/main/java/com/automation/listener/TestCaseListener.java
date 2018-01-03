package com.automation.listener;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

import com.automation.base.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestCaseListener  extends BaseClass implements ITestListener

{
	BaseClass base;
	
	
	private static  String testcase;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("YES ITS STARTED");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
	System.out.println("Test Case FAILED--> "+testcase);
	logger.log(LogStatus.FAIL, "Test Case Failed is -->  '"+testcase+"'  ");
	
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("-------------- ON TEST START -----------------");
	    testcase = 	result.getName();
	   System.out.println("Starting the TestCase ==> "+testcase);
	   logger = exreport.startTest(testcase,"Test Started");
	   logger.log(LogStatus.INFO, "Test Case  Started is --> '"+testcase+"' ");
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
	System.out.println("Test Case Completed-->"+testcase);
	logger.log(LogStatus.PASS, "Test Case  Passed is --> '"+testcase+"' ");
	
	}
	
	public String  getTestcaseName()
	{
		return testcase;
	}
	
	public void setTestcaseName(String testcase)
	{
		this.testcase = testcase;
	}
	
	
	

}
