package com.automation.icehrmpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automation.base.BaseClass;
import com.automation.extentreport.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class IcehrmProjectPage extends BaseClass{
	
	WebDriver driver;

	@FindBy(xpath="//button[contains(text(),'Add New')]")
	WebElement btn_AddNew;
		

	@FindBy(id="name")
	WebElement txt_projectname;
	
	@FindBy(id="status")
	WebElement drp_status;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement btn_save;
	

	public IcehrmProjectPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddNewButton()
	{
		btn_AddNew.click();
	//	logger.log(LogStatus.PASS, "Clicked on Add NEw Button");
	//	ExtentTestManager.getTest().log(LogStatus.PASS, "Click on Add New Button");

		
	}

	public void enterUsername(String name)
	{
		txt_projectname.sendKeys(name);
//		logger.log(LogStatus.PASS, "Entered the Project Name");
	//	ExtentTestManager.getTest().log(LogStatus.PASS, "Entered the Project Name");

	}
	
	public void registerProject(String name,String status)
	{
		txt_projectname.sendKeys(name);
		Select statusdrp = new Select(drp_status);
		statusdrp.selectByVisibleText(status);
		
	}
	
	public void clickOnSavebutton()
	{
		btn_save.click();
	}

	

}
