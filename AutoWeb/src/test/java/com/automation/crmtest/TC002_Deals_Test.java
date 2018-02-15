package com.automation.crmtest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.crmpages.DealsPage;
import com.automation.crmpages.HomePage;
import com.automation.crmpages.LoginPage;
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
