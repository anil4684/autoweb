package com.automation.crmtest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.crmpages.CompanyPage;
import com.automation.crmpages.HomePage;
import com.automation.crmpages.LoginPage;
import com.automation.utils.ConfigReader;

public class TC006_Login_Test extends BaseClass{

	BaseClass base; 
	LoginPage loginpage;
	HomePage homepage;
	CompanyPage companypage;

	 
	  @Test (enabled=false)
	  public void TC006_Login() 
	  {
		  System.out.println("Logged into CRM");
	
		
	  }
	  
	  
	  @BeforeClass
	  public void beforeClass() 
	  {
		  base = new BaseClass();
		  config = new ConfigReader();
		  base.SetupBrowser();
		  base.LaunchUrl(config.getCrmUrl());
		  loginpage = new LoginPage(driver);
		  loginpage.login(config.getCrmUserName(), config.getCrmUserPassword());
	   }

	  @AfterClass
	  public void afterClass() 
	  {
		 
	  }
}
