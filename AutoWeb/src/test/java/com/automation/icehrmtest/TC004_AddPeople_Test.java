package com.automation.icehrmtest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.icehrmpages.IcehrmHomePage;
import com.automation.icehrmpages.IcehrmLoginPage;
import com.automation.icehrmpages.IcehrmPeoplePage;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExcelReader;

public class TC004_AddPeople_Test extends BaseClass{
	
	@Test(enabled=false)
	public void TC004_AddEmployee()  {
		System.out.println("==> TC004_AddEmployee  <==  Thread ID :" + Thread.currentThread().getId());
	
	ExcelReader excel = new ExcelReader();
	  IcehrmHomePage homepage = new IcehrmHomePage(getDriver());
	  IcehrmPeoplePage peoplepage = new IcehrmPeoplePage(getDriver());
	  	  homepage.clickOnPeopleLink();
	  	peoplepage.clickOnAddNewButton();
	  	peoplepage.enterEmployeeNumber(excel.getTestData("TC001_var_empname"));
	  
	  
	  
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
