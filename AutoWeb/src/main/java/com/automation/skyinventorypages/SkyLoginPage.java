package com.automation.skyinventorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.BaseClass;
import com.automation.utils.ConfigReader;

public class SkyLoginPage {
	
	
WebDriver driver;
ConfigReader config = new ConfigReader();
BaseClass base =new BaseClass();
	
@FindBy(id="username")
WebElement txtUsername;

@FindBy(id="password")
WebElement txtPassword;


@FindBy(xpath="//input[@type='submit' and @value='Log in']")
WebElement btnLogIn;

public SkyLoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
	
}
public void loginSkyInventory()
{

	txtUsername.sendKeys(config.getSkyUserName());
	txtPassword.sendKeys(config.getSkyUserPassword());
	btnLogIn.click();
}


}
