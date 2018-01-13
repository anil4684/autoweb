package com.automation.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.pages.DealsPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;

public class TC002_Deals_Test extends BaseClass{
	
	BaseClass base; 
	LoginPage loginpage;
	HomePage homepage;
	DealsPage dealspage;
	
  @Test(enabled=true)
  public void TC002_Deals() {
	  base =new BaseClass();
	  homepage = new HomePage(driver);
	  homepage.clickDealsNewDeal();
	  dealspage= new DealsPage(driver);
	  dealspage.enterCompany("TC002_CompanyName");
	  dealspage.enterTittle("TC002_Title");
	  
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
