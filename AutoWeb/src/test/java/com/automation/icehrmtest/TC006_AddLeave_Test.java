package com.automation.icehrmtest;

import org.sikuli.script.FindFailed;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.icehrmpages.IcehrmHomePage;
import com.automation.icehrmpages.IcehrmLeaveManagementPage;
import com.automation.icehrmpages.IcehrmLoginPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExcelReader;

public class TC006_AddLeave_Test extends BaseClass{
  
	@Test(enabled=false)
  public void TC006_AddLeave() {
		ExcelReader excel = new ExcelReader();
	  IcehrmHomePage homepage = new IcehrmHomePage(getDriver());
	  IcehrmLeaveManagementPage leavepage = new IcehrmLeaveManagementPage(getDriver());
	  try {
		homepage.clickOnLeaveManagement();
	
	  leavepage.clickOnAddNewButton();
	  leavepage.enterCode(excel.getTestData("TC001_var_code"));
	  } catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
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
 
 
 @AfterClass
 public void afterClass() {
	  BaseClass base = new BaseClass();
	  base.driverClose();
 }
}
