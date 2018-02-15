package com.automation.icehrmpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.BaseClass;
import com.automation.extentreport.ExtentTestManager;
import com.automation.listener.TestCaseListener;
import com.automation.utils.ConfigReader;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class IcehrmLoginPage   {
	
WebDriver driver;
ExtentTest log;
ConfigReader config = new ConfigReader();
	
@FindBy(id="username")
WebElement txtUsername;

@FindBy(id="password")
WebElement txtPassword;

@FindBy(xpath="//button[@type='button' and contains(text(),'Sign')]")
WebElement btnSignIn;

public IcehrmLoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);

			
}
public void loginIcehrm()
{

	
	txtUsername.sendKeys(config.getIcehrmUserName());
//	ExtentTestManager.getTest().log(LogStatus.PASS, "Filled User ID");
	txtPassword.sendKeys(config.getIcehrmUserPassword());
//	ExtentTestManager.getTest().log(LogStatus.PASS, "Filled User Password");
	btnSignIn.click();
//	ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked on Submit Button");
}

}
