package com.automation.icehrmtest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.icehrmpages.IcehrmHomePage;
import com.automation.icehrmpages.IcehrmLoginPage;
import com.automation.icehrmpages.IcehrmProjectPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExcelReader;

public class TC005_RegisterProject_Test extends BaseClass{
	
  @Test(enabled = true)
    public void TC005_RegisterProject()
  {
		System.out.println("==> TC005_RegisterProject  <==  Thread ID :" + Thread.currentThread().getId());

	ExcelReader excel = new ExcelReader();
  IcehrmHomePage homepage = new IcehrmHomePage(getDriver());
  IcehrmProjectPage projectpage = new IcehrmProjectPage(getDriver());
  homepage.clickOnProjectLink();
  projectpage.clickOnAddNewButton();
  projectpage.enterUsername(excel.getTestData("TC001_var_Projectname"));
    
  }
  @BeforeClass
  
  public void beforeClass() {
	  BaseClass base = new BaseClass();
	  ConfigReader config = new ConfigReader();
	  base.SetupBrowser();
	  base.LaunchUrl(config.getIcehrmUrl());
	  IcehrmLoginPage login = new IcehrmLoginPage(getDriver());
	  login.loginIcehrm();
  }



}