package com.automation.icehrmpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import com.automation.base.BaseClass;
import com.automation.extentreport.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class IcehrmPeoplePage extends BaseClass{
	
	
	WebDriver driver;
	
	@FindBy (id="employee_id")
	WebElement txt_empnum;
	
	@FindBy(xpath ="//button[contains(text(),'Add New')]")
	WebElement btn_addNew;
	
	public IcehrmPeoplePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmployeeNumber(String number){
		txt_empnum.sendKeys(number);
	//	logger.log(LogStatus.PASS, "Enter the Employee Number");
	//	ExtentTestManager.getTest().log(LogStatus.PASS, "Enter the Employee Number");
	}
	
	public void clickOnAddNewButton()
	{
		btn_addNew.click();
//		logger.log(LogStatus.PASS, "Click on Add New Button");
	//	ExtentTestManager.getTest().log(LogStatus.PASS, "Click on Add New Button");
	}
	

}
