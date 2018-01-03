package com.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.BaseClass;


public class LoginPage extends BaseClass
{
WebDriver driver;
String str;

JavascriptExecutor js;
	HomePage HomePage;
	BaseClass base;
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement  password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitbutton;
	
	
	@FindBy(xpath="//img[@src='https://d19rqa8v8yb76c.cloudfront.net/img/freecrm.jpg'")
	WebElement logo;
	

    public  LoginPage(WebDriver driver)
    {
          this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    public Boolean verifyloginPage()
    {
    	return logo.isDisplayed();
    }
    
    public void readfromexcel(String data)
    {
    	
    	System.out.println(excel.getTestData(data));
    }
    
     
    
    public void login(String userid,String pwd)
    {
  try
  {
    	username.sendKeys(userid);
    	password.sendKeys(pwd);
    	wait(submitbutton);
    	//submitbutton.click();
    	if(submitbutton.isDisplayed() && submitbutton.isEnabled())
    	{    	
    	js  =  (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();",submitbutton );
    	}
    	else
    		System.out.println("Not able to click on Submit button");
  }
  catch (Exception e)
  {
	  e.printStackTrace();
  }
    	    	
    }
    
}
