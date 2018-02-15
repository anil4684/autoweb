package com.automation.crmpages;

import org.openqa.selenium.By;
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
    //	webdriverwait(submitbutton);
    	//submitbutton.click();
    	if(submitbutton.isDisplayed() && submitbutton.isEnabled())
    	{    	
    	js  =  (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();",submitbutton ); 
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[@title='Contacts']")).click();
		driver.findElement(By.xpath("//form[@id='vContactsForm']/table[@class='datacard']/descendant::tr/td/a[@_name='Bharath K']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
		driver.findElement(By.xpath(" //form[@id='vContactsForm']/table[@class='datacard']/descendant::tr/td/a[@_name='Bharath K']/parent::td/following-sibling::td/a/i[@title='Edit']")).click();
		driver.findElement(By.name("middle_initial")).sendKeys("Kumar");;
		driver.findElement(By.xpath("//input[@type='submit']")).click();
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
