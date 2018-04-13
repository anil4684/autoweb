package com.automation.icehrmpages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automation.base.BaseClass;
import com.automation.extentreport.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class IcehrmUsersPage extends BaseClass {
	
	
WebDriver driver;

@FindBy(xpath="//button[contains(text(),'Add New')]")
WebElement btn_AddNew;

@FindBy(id="username")
WebElement txt_username;

@FindBy(id="email")
WebElement txt_email;

@FindBy(id="user_level")
WebElement drp_userlevel;

@FindBy(id="user_roles")
WebElement drp_userroles;

@FindBy(name="employee")
WebElement drp_employee;

@FindBy(xpath="//button[text()='Save']")
WebElement btn_Save;

@FindBy(xpath="//button[text()='Ok']")
WebElement btn_ok;


public IcehrmUsersPage(WebDriver driver)
{
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public void clickOnAddNewButton()
{
	btn_AddNew.click();
//	logger.log(LogStatus.PASS, "Clicked on Add NEw Button");
//	ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked on Add NEw Button");

}

public void enterUsername(String name)
{
	txt_username.sendKeys(name);
//	logger.log(LogStatus.PASS, "Entered the UserName");
//	ExtentTestManager.getTest().log(LogStatus.PASS, "Entered User Name");

}

public void registeruser(String name,String email,String employee,String userlevel,String userroles)
{
	txt_username.sendKeys(name);
	txt_email.sendKeys(email);
	Select employeedrp = new Select(drp_employee);
	employeedrp.selectByVisibleText(employee);
	Select userleveldrp = new Select(drp_userlevel);
	userleveldrp.selectByVisibleText(userlevel);
	Select userrolesdrp = new Select(drp_userroles);
	userrolesdrp.selectByVisibleText(userroles);
	
}

public void clickOnSaveButton()
{
	btn_Save.click();
//	logger.log(LogStatus.PASS, "Clicked on Add NEw Button");
//	ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked on Add NEw Button");

}

public void clickOnOkButton()
{
	BaseClass base = new BaseClass();
	base.webDriverWaitUntilClickable(btn_ok);
		btn_ok.click();
	
}

//	logger.log(LogStatus.PASS, "Clicked on Add NEw Button");
//	ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked on Add NEw Button");





}
