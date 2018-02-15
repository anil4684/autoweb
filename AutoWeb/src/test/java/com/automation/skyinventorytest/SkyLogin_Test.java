package com.automation.skyinventorytest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.skyinventorypages.SkyLoginPage;
import com.automation.utils.ConfigReader;

public class SkyLogin_Test extends BaseClass {
  @Test(enabled=true)
  public void SkyLogin() {
	  
	  System.out.println("Logged into Sky Inventory");
  }
  
  
  
  @BeforeClass
  public void beforeClass() {
	
  BaseClass base = new BaseClass();
  ConfigReader config = new ConfigReader();
  base.SetupBrowser();
  base.LaunchUrl(config.getSkyUrl());
  SkyLoginPage login = new SkyLoginPage(driver);
  login.loginSkyInventory();
  	  
  }
  @AfterClass
  public void afterClass() {
  }

}
