package com.automation.pages;



import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class CompanyPage extends BaseClass{
	WebDriver driver;
	JavascriptExecutor js ;
	String str;
	
	
	
	@FindBy(id="company_name")
	WebElement txt_companyName;
	
	@FindBy(name="industry")
	WebElement txt_industryName;
	
	@FindBy(id="phone")
	WebElement txt_phoneNumber;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btn_savebutton;
	
	@FindBy(xpath="//td[text()='Company: Rashmi'")
	WebElement verifyCompanyName;
	
	@FindBy(linkText="Full Search Form")
	WebElement lnk_companies_NewSearchForm;
	
    
	
	
	public CompanyPage(WebDriver driver)
	{
	
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void enterIndustryName(String industryname)
	{	str = 	excel.getTestData(industryname);
		txt_industryName.sendKeys(str);
	    logger.log(LogStatus.PASS, "Entered Industry Name as -> '"+str+"' ");
	}
	

	public void enterPhoneNumber(String phonenumber)
	{
		str = 	excel.getTestData(phonenumber);
	         txt_phoneNumber.sendKeys(str);
	         logger.log(LogStatus.PASS, "Entered Phone Number as -> '"+str+"' ");
	}
	

	public void enterCompanyName(String companyname)
	{
		
		str = 	excel.getTestData(companyname);
			
		webdriverwait(txt_companyName); 
		try
		{
		txt_companyName.sendKeys(str);
		}
		catch(ElementNotVisibleException e)
		{
			logger.log(LogStatus.FATAL, "Test Data file not found");
		}
		
		System.out.println("!!!!  ENDED to  ENTER the Company NAME ====");
		 logger.log(LogStatus.PASS, "Entered Company Name as -> '"+str+"' ");
		
	}
	
	public void clickSaveButton()
	{
	
		js =  (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", btn_savebutton);
		btn_savebutton.click();
		 logger.log(LogStatus.PASS, "Clicked on Save Button ");
	}

}
