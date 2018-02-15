package com.automation.crmtest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.crmpages.CompanyPage;
import com.automation.crmpages.ContactsPage;
import com.automation.crmpages.HomePage;
import com.automation.crmpages.LoginPage;
import com.automation.utils.ConfigReader;

public class TC005_EditContactInfo_Test  extends BaseClass{
	
	BaseClass base; 
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactsPage;
	
	@Test (enabled=true)
  public void TC005_EditContactInfo() {
		homepage = new HomePage(driver);
		  homepage.clickContactlink();
		  contactsPage = new ContactsPage(driver);
		  contactsPage.clickCheckboxContactTable();
	  
  }
	
	  @BeforeMethod
	  public void beforeMethod() 
	  {
		  base = new BaseClass();
		  config = new ConfigReader();
		  base.SetupBrowser();
		  base.LaunchUrl(config.getCrmUrl());
		  loginpage = new LoginPage(driver);
		  loginpage.login(config.getCrmUserName(), config.getCrmUserPassword());
	   }

	  @AfterMethod
	  public void afterMethod() 
	  {
		// base.driverQuit();
	  }
}
