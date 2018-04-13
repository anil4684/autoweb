package com.automation.icehrmpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.BaseClass;
import com.automation.extentreport.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class IceHrmLeavePage extends BaseClass{
	
	WebDriver driver;
	
	@FindBy(xpath="//button[contains(text(),'Add New')]")
	WebElement btn_AddNew;
	
	@FindBy(id="name")
	WebElement txt_leaveName;
	
	public IceHrmLeavePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void ClickonAddNewButton()
	{
		btn_AddNew.click();
	//	logger.log(LogStatus.PASS, "Clicked on Add NEw Button");
	//	ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked on Add NEw Button");
	}
	
	public void enterLeaveName(String leavename)
	{
		txt_leaveName.sendKeys(leavename);
	//	logger.log(LogStatus.PASS, "Entered the Leave Name");
	//	ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Leave Name");
	}

}
