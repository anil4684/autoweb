package com.automation.crmtest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.crmpages.ContactsPage;
import com.automation.crmpages.HomePage;
import com.automation.crmpages.LoginPage;
import com.automation.utils.ConfigReader;

public class TC004_Contacts_Page_Test extends BaseClass {
	
	BaseClass base;
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactsPage;
	
	@Test (enabled=true)
	public void TC004_Contacts() 
	{
		homepage = new HomePage(driver);
		  homepage.clickNewContactlink();
		  contactsPage = new ContactsPage(driver);
		  contactsPage.enterFirstName("TC004_FirstName");
		  contactsPage.selectCategory("TC004_Category");
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
		 base.driverQuit();
	  }


}
