package com.automation.myhrpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.BaseClass;
import com.automation.utils.ConfigReader;

public class MyhrLoginPage {
	
	
WebDriver driver;
ConfigReader config = new ConfigReader();
BaseClass base =new BaseClass();
	
@FindBy(id="textfield-1011-inputEl")
WebElement txtUsername;

@FindBy(id="textfield-1012-inputEl")
WebElement txtPassword;

@FindBy(xpath="//a[text()='Login']")
WebElement lnkLogin;



@FindBy(xpath="//a[@data-componentid='button-1015']")
WebElement btnSignIn;

public MyhrLoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
	
}
public void loginMyhrm()
{
	base.webdriverwait(lnkLogin);
	lnkLogin.click();
	txtUsername.sendKeys(config.getMyhrUserName());
	txtPassword.sendKeys(config.getMyhrUserPassword());
	btnSignIn.click();
}

}
