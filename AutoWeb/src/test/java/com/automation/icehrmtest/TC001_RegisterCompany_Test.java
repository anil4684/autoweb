package com.automation.icehrmtest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.icehrmpages.IcehrmCompanyPage;
import com.automation.icehrmpages.IcehrmHomePage;
import com.automation.icehrmpages.IcehrmLoginPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExcelReader;

public class TC001_RegisterCompany_Test extends BaseClass{
  @Test(enabled=true)
  public void  TC001_RegisterCompany() {
	  System.out.println("==> TC001_RegisterCompany <==  Thread ID : " + Thread.currentThread().getId());
	   ExcelReader excel = new ExcelReader();
	  IcehrmHomePage homepage = new IcehrmHomePage(getDriver());
	  homepage.clickOnCompanyLink();
	  IcehrmCompanyPage companypage = new IcehrmCompanyPage(getDriver());
	  companypage.clickOnAddNewButton();
	  companypage.registerCompany(
			  excel.getTestData("TC001_var_company"),
			  excel.getTestData("TC001_var_details"), 
			  excel.getTestData("TC001_var_address"), 
			  excel.getTestData("TC001_var_type"), 
			  excel.getTestData("TC001_var_country"), 
			  excel.getTestData("TC001_var_timezone"), 
			  excel.getTestData("TC001_var_parentstructure"), 
			  excel.getTestData("TC001_var_heads"));
	//  companypage.clickOnSaveButton();
	  
	  
	  
  }
  
  
  
  
  @BeforeMethod (alwaysRun=true)
  public void beforeClass() {
	  String testcase = 	this.getClass().getSimpleName();
      System.out.println("Starting the TestCase ==> "+testcase);
	  BaseClass base = new BaseClass();
	  ConfigReader config = new ConfigReader();
	  base.SetupBrowser();
	  base.LaunchUrl(config.getIcehrmUrl());
	  IcehrmLoginPage login = new IcehrmLoginPage(getDriver());
	  login.loginIcehrm();
  }



}
