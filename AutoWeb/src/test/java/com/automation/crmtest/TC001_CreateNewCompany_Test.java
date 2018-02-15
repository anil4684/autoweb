package com.automation.crmtest;

import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.crmpages.CompanyPage;
import com.automation.crmpages.HomePage;
import com.automation.crmpages.LoginPage;
import com.automation.utils.ConfigReader;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TC001_CreateNewCompany_Test extends BaseClass
{
BaseClass base; 
LoginPage loginpage;
HomePage homepage;
CompanyPage companypage;

 
  @Test (enabled=true)
  public void TC001_CreateNewCompany() 
  {
	  homepage = new HomePage(driver);
	   homepage.clickNewCompanylink();
      companypage = new CompanyPage(driver);
      companypage.enterCompanyName("TC001_CompanyName");
	  companypage.enterIndustryName("TC001_Industry");
	  companypage.enterPhoneNumber("TC001_PhoneNumber");
//	  companypage.clickSaveButton();
	  
	
	
	
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
