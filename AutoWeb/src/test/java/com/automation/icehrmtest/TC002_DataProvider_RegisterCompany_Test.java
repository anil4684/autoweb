package com.automation.icehrmtest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.icehrmpages.IcehrmCompanyPage;
import com.automation.icehrmpages.IcehrmHomePage;
import com.automation.icehrmpages.IcehrmLoginPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExcelReader;

public class TC002_DataProvider_RegisterCompany_Test extends BaseClass{
	
	
	
  @Test(dataProvider = "createcompany",enabled=false)
  public void  TC002_DataProvider_RegisterCompany(String companyname,String details,String address,String type,String country,String timezone,String parentstructure,String heads) {

	  IcehrmHomePage homepage = new IcehrmHomePage(driver);
	  homepage.clickOnCompanyLink();
	  IcehrmCompanyPage companypage = new IcehrmCompanyPage(driver);
	  companypage.clickOnAddNewButton();
	  companypage.registerCompany(companyname,details,address,type,country,timezone,parentstructure,heads);
	   homepage.backTohomePage();
	  
	  
  }
  
  
	@DataProvider(name="createcompany")
	 public Object[][] registercompanydata() {
	  ExcelReader excel = new ExcelReader();
		Object[][] arrayObject = excel.getIceHrmTestData();
		return arrayObject;
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
