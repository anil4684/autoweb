package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automation.base.BaseClass;
import com.automation.utils.ExcelReader;
import com.relevantcodes.extentreports.LogStatus;

public class ContactsPage extends BaseClass{
	
	WebDriver driver;
	ExcelReader excel = new ExcelReader();
	String str;
	
	@FindBy(id="first_name")
	WebElement txt_firstName;
	
	@FindBy(name="category")
	WebElement drp_category;
	
	
     public ContactsPage(WebDriver driver)
     {
      this.driver = driver;
      PageFactory.initElements(driver, this);
     }
     
     public void enterFirstName(String firstname)
     {
    	 txt_firstName.sendKeys(excel.getTestData(firstname));
     }
     
     public void selectCategory(String category)
     {
    	 Select cat = new Select(drp_category);
    	 str = 	excel.getTestData(category);
    	 cat.selectByVisibleText(str);
    	 logger.log(LogStatus.PASS, "Selected Category is -> '"+str+"' ");
     }
}
