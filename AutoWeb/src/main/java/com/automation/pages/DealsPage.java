package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.BaseClass;
import com.automation.utils.ExcelReader;
import com.relevantcodes.extentreports.LogStatus;

public class DealsPage extends BaseClass{
	WebDriver driver;
	ExcelReader excel = new ExcelReader();
	String str;
	
	@FindBy(id="title") 
	WebElement txt_title;
	
	@FindBy(name="client_lookup")
	 WebElement txt_company;
	
	public DealsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterTittle(String title)
	{
		str = 	excel.getTestData(title);
		txt_title.sendKeys(str);
	}
	
	public void enterCompany(String company)
	{
		str = 	excel.getTestData(company);
		txt_company.sendKeys(str);
		 logger.log(LogStatus.PASS, "Entered Company is -> '"+str+"' ");
		
	}


}
