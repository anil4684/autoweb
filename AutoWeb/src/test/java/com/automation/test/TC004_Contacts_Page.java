package com.automation.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.pages.ContactsPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;

public class TC004_Contacts_Page extends BaseClass {
	
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
		  base.LaunchUrl(config.getUrl());
		  loginpage = new LoginPage(driver);
		  loginpage.login(config.getUserName(), config.getUserPassword());
	   }
	  
	  
	  @AfterMethod
	  public void afterMethod() 
	  {
		 base.driverQuit();
	  }


}
