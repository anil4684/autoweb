package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
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
	
	@FindBy(xpath="//form[@id='vContactsForm']/table[@class='datacard']/descendant::tr/td/a[@_name='Srinivas R']/parent::td/preceding-sibling::td/input[@type='checkbox']")
//	@FindBy(xpath="//form[@id='vContactsForm']/table[@class='datacard']")
	WebElement table_contactinfo;
	
	
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
     
     public void clickCheckboxContactTable()
     {
    //	WebElement chkbx_name = table_contactinfo.findElement(By.xpath("//a[@_name="+name+"]/parent::td/preceding-sibling::td/input[@type='checkbox']"));
    	 try
    	 {
    	// System.out.println("Switched to Frame");
    	//	switchtoframeByName("mainpanel");
    	//    table_contactinfo.click();
    	 //   driver.switchTo().defaultContent();
    	//    System.out.println("Switched OUT of to Frame");
    	    table_contactinfo.click();
    	//	 driver.findElement(By.xpath("//form[@id='vContactsForm']/table[@class='datacard']/descendant::tr/td/a[@_name='Srinivas R']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
    	//	driver.findElement(By.xpath(" //form[@id='vContactsForm']/table[@class='datacard']/descendant::tr/td/a[@_name='Srinivas R']/parent::td/following-sibling::td/a/i[@title='Edit']")).click();
    			
    	 }
    	 catch (Exception e)
    	 {
    		 e.printStackTrace();
    	 }
     }
}

