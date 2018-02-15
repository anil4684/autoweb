package com.automation.icehrmpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class IcehrmProjectPage extends BaseClass{
	
	WebDriver driver;

	@FindBy(xpath="//button[contains(text(),'Add New')]")
	WebElement btn_AddNew;
		

	@FindBy(id="name")
	WebElement txt_projectname;

	public IcehrmProjectPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddNewButton()
	{
		btn_AddNew.click();
		logger.log(LogStatus.PASS, "Clicked on Add NEw Button");
	}

	public void enterUsername(String name)
	{
		txt_projectname.sendKeys(name);
		logger.log(LogStatus.PASS, "Entered the Project Name");
	}

	

}
