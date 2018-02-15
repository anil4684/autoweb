package com.automation.myhrtest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.myhrpages.MyhrLoginPage;
import com.automation.utils.ConfigReader;

public class MyhrLogin_Test extends BaseClass{
	  @Test (enabled=false)
	  public void MyhrLogin() {
		  System.out.println("Logged into My HR Home");
		  
		  
	  }
	  @BeforeClass
	  public void beforeClass() {
		
	  BaseClass base = new BaseClass();
	  ConfigReader config = new ConfigReader();
	  base.SetupBrowser();
	  base.LaunchUrl(config.getMyhrUrl());
	  MyhrLoginPage login = new MyhrLoginPage(driver);
	  login.loginMyhrm();
	  	  
	  }

	  @AfterClass
	  public void afterClass() {
	  }


}
