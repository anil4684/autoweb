package com.automation.crmtest;

import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.utils.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

public class PreNPost {
	protected static ExtentReports exreport;
	protected static ExtentTest logger;
	
	@BeforeSuite 
	public void extentReport()
	{
		ExcelReader excel = new ExcelReader();
		String reportpath = excel.getReportPath()+"\\"+"AutomationReport.html";
		System.out.println("==== Report file Path is ===>"+reportpath);
		exreport = new ExtentReports(reportpath);
		exreport.addSystemInfo("OS", "WINDOWS 8");
	}
	
	@AfterClass
	public void afterClass()
	{
		exreport.endTest(logger);
	}
	
	@AfterSuite
	public void afterSuite()
	{
		exreport.flush();
	}

}
