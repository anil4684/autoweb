package com.automation.icehrmpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automation.base.BaseClass;
import com.automation.extentreport.ExtentTestManager;
import com.automation.listener.TestCaseListener;
import com.automation.utils.ExcelReader;
import com.relevantcodes.extentreports.LogStatus;

public class IcehrmCompanyPage extends TestCaseListener{
	
	
WebDriver driver;
	
	@FindBy(xpath="//button[contains(text(),'Add New')]")
	WebElement btnAddNew;
	
	@FindBy(id="title")
	WebElement txtName;
	
	@FindBy(id="description")
	WebElement txtDetails;
	
	@FindBy(id="address")
	WebElement txtAddress;

	@FindBy(xpath="//select[@id='type']")
	WebElement drpType;
	
	@FindBy(xpath="//Select[@id='country']")
	WebElement drpCountry;
	
	@FindBy(xpath="//select[@id='timezone']")
	WebElement drptimezone;
	

	@FindBy(xpath="//select[@id='parent']")
	WebElement drpParentStructure;
	

	@FindBy(xpath="//select[@id='heads']")
	WebElement drpHead;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement btnSave;
	
	@FindBy(xpath="//button[contains(text(),'Save')]/following-sibling::button[contains((@class),'cancelBtn') and contains(text(),'Cancel')]")
	WebElement btnCanacel;
	
	
	
  public  IcehrmCompanyPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
  
  public void registerCompany(String companyname,String details,String address,String type,String country,String timezone,String parentstructure,String heads)
  
  {
	  try
	  {
		 
	  
	  txtName.sendKeys(companyname);
//	  logger.log(LogStatus.PASS, "Filled Company Name");
//	  ExtentTestManager.getTest().log(LogStatus.PASS, "Filled Company Name");
	  
	  
	  txtDetails.sendKeys(details);
//	  logger.log(LogStatus.PASS, "Filled Details ");
	  
	  txtAddress.sendKeys(address);
//	  logger.log(LogStatus.PASS, "Filled Address");
	  
	  Select typedrp = new Select(drpType);
	  typedrp.selectByVisibleText(type);
//	  logger.log(LogStatus.PASS, "Selected Type Dropdown");
	  
	  Select countrydrp = new Select(drpCountry);
	  countrydrp.selectByVisibleText(country);
//	  logger.log(LogStatus.PASS, "Selected Country Dropdown");
	  
	  Select timezonedrp = new Select(drptimezone);
	  timezonedrp.selectByVisibleText(timezone);
//	  logger.log(LogStatus.PASS, "Selected TimeZone Dropdown");
	  
	  Select ParentStructuredrp = new Select(drpParentStructure);
	  ParentStructuredrp.selectByVisibleText(parentstructure);
//	  logger.log(LogStatus.PASS, "Selected Parent Structure Dropdown");
	  
	  Select headdrp = new Select(drpHead);
	  headdrp.selectByVisibleText(heads);
//	  logger.log(LogStatus.PASS, "Selected Head Dropdown");
	  
	
	  
	//  btnSave.click();
//	  logger.log(LogStatus.PASS, "Clicked on Save Button");
	
	 // btnCanacel.click();
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  
	 	  
  }
  
  public void setCompanyName(String companyname)
  {
	  txtName.sendKeys(companyname);
  }
  
  public void clickOnAddNewButton()
  {
	  btnAddNew.click();
  }
  
  public void clickOnSaveButton()
  {
	  btnSave.click();
  }
  

}
