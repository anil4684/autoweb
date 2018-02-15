package com.automation.icehrmtest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.icehrmpages.IcehrmLoginPage;
import com.automation.utils.ConfigReader;

public class IcehrmLogin_Test extends BaseClass {
	
  @Test(enabled=true)
  public void IcehrmLogin() {
	  System.out.println("Logged into ICE HRM Home");
	  
	  
  }
  @BeforeClass
  public void beforeClass() {
	
  BaseClass base = new BaseClass();
  ConfigReader config = new ConfigReader();
  base.SetupBrowser();
  base.LaunchUrl(config.getIcehrmUrl());
  IcehrmLoginPage login = new IcehrmLoginPage(driver);
  login.loginIcehrm();
  	  
  }

  @AfterClass
  public void afterClass() {
  }

}
