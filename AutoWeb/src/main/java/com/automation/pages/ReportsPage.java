package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automation.base.BaseClass;
import com.automation.utils.ExcelReader;
import com.relevantcodes.extentreports.LogStatus;

public class ReportsPage extends BaseClass{
	
WebDriver driver;
String str;
ExcelReader excel = new ExcelReader();

	@FindBy(linkText="Call Statistics") 
	WebElement lnk_callStatics;
	
	@FindBy(name="graph")
	WebElement drp_graph;
	
	
	public ReportsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

	
	public void clickCallStatics()
	{
		lnk_callStatics.click();
	}
	
	public void selectGraphType(String type)
	{
		
		Select grap = new Select(drp_graph);
		str = 	excel.getTestData(type);
		grap.selectByVisibleText(str);
		 logger.log(LogStatus.PASS, "Selected Graph Type is -> '"+str+"' ");
		
	}
	
}
