package com.automation.crmtest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.crmpages.HomePage;
import com.automation.crmpages.LoginPage;
import com.automation.crmpages.ReportsPage;
import com.automation.utils.ConfigReader;

public class TC003_Report_Test extends BaseClass{
	
	BaseClass base;
	LoginPage loginpage; 
	HomePage homepage;
	ReportsPage reportspage;
	
	 @Test(enabled=true)
	public void TC003_Report(){
		 
		 homepage = new HomePage(driver);
		 homepage.clickReportlink();
		 reportspage = new ReportsPage(driver);
		  reportspage.clickCallStatics();
		  reportspage.selectGraphType("TC004_GraphType");
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
