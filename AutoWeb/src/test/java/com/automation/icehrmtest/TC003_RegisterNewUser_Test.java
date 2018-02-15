package com.automation.icehrmtest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.icehrmpages.IcehrmHomePage;
import com.automation.icehrmpages.IcehrmLoginPage;
import com.automation.icehrmpages.IcehrmUsersPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExcelReader;

public class TC003_RegisterNewUser_Test extends BaseClass {

	  @Test(enabled=false)
	  public void  TC003_RegisterNewUser() {
		  System.out.println("==> TC003_RegisterNewUser  <==  Thread ID :" + Thread.currentThread().getId());
	ExcelReader excel = new ExcelReader();
	  IcehrmHomePage homepage = new IcehrmHomePage(driver);
	  IcehrmUsersPage userpage = new IcehrmUsersPage(driver);
	  homepage.clickOnUserLink();
	  userpage.clickOnAddNewButton();
	  userpage.enterUsername(excel.getTestData("TC001_var_username"));
	  	 
	  }
	
	@BeforeClass
	public void beforeClass() {
		  BaseClass base = new BaseClass();
		  ConfigReader config = new ConfigReader();
		  base.SetupBrowser();
		  base.LaunchUrl(config.getIcehrmUrl());
		  IcehrmLoginPage login = new IcehrmLoginPage(driver);
		  login.loginIcehrm();
	}

	@AfterClass
	public void afterClass() {
	}

}

