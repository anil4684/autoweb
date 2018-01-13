package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.BaseClass;
import com.relevantcodes.extentreports.LogStatus;


public class HomePage extends BaseClass
{
	
	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor)driver;
	Actions action;

	
	@FindBy(xpath="//td[contains(text(),'User: Anil Kumar']")
	WebElement loginName;
	
			
	@FindBy(xpath="//a[@class='topnavlink']")
	WebElement logout;
	
	@FindBy(xpath="//a[@title='New Deal']")
	WebElement lnk_newDeals;
	
	@FindBy(name="mainpanel")
	WebElement iFramemainpanel;
	
	@FindBy(linkText="Home")
	WebElement lnk_home;
	
	@FindBy(xpath="//a[@title='Home']")
	WebElement HomeTitle;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement lnk_deals;
	
	@FindBy(xpath="//a[@title='New Company']")
	WebElement lnk_company_newCompany;
	
	@FindBy(xpath="//a[@title='Companies']")
	WebElement lnk_companies;
	
	
	@FindBy(linkText="Full Search Form")
	WebElement lnk_companies_FullSearchForm;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement lnk_contacts;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement lnk_Contacts_NewContact;
	
	@FindBy(xpath="//a[@title='Reports']")
	WebElement lnk_Reports;
	
	
	

	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	
	}
	

	public void frameList()
	{
		List<WebElement> iframes =driver.findElements(By.tagName("frame")) ;
		for(WebElement frame:iframes)
		{
		  System.out.println("Frame name are"+frame.getAttribute("name"));
		}
	//	driver.switchTo().frame(driver.findElement(By.xpath("//frame[@scr='https://www.crmpro.com/system/index.cfm']")));
	//	driver.switchTo().frame("mainpanel");
	}
	
	public Boolean isUserNameDisplayed()
	{
		return loginName.isDisplayed();
	}
	
	public Boolean isHomeLinkDisplayed()
	{
		switchtoframeByName("mainpanel");
		webdriverwait(lnk_home);
		return lnk_home.isDisplayed();
	}
	
	public void clickHomelink()
	{
		switchtoframeByName("mainpanel");
		HomeTitle.click();
		logger.log(LogStatus.PASS, "Clicked on Home Link");
	}
	

	public void clickNewCompanylink() 
	{
		System.out.println("Clicking on NEW COMPANY");
		switchtoframeByName("mainpanel");
		action = new Actions(driver);
		webdriverwait(lnk_companies);
		action.moveToElement(lnk_companies).build().perform();
		lnk_company_newCompany.click();
		System.out.println("YES I HAVE CLIKCED on NEW COMPANY");
		logger.log(LogStatus.PASS, "Clicked on New Company Link"); 
		
	}
	
	public void clickCompaniesFullSearchForm()
	{
		switchtoframeByName("mainpanel");
		action = new Actions(driver);
		action.moveToElement(lnk_companies).build().perform();
		lnk_companies_FullSearchForm.click();
		logger.log(LogStatus.PASS, "Clicked on Company --> Full Search Form");
		
	}
	
	public void clickDealsNewDeal()
	{
		switchtoframeByName("mainpanel");
		action = new Actions(driver);
		action.moveToElement(lnk_deals).build().perform();
		lnk_newDeals.click();
		logger.log(LogStatus.PASS, "Clicked on Deals --> New Deals");
	}
	

	public void clickReportlink()
	{
		switchtoframeByName("mainpanel");
		lnk_Reports.click();
		logger.log(LogStatus.PASS, "Clicked on Report");
	}
	
	public void clickNewContactlink()
	{
		switchtoframeByName("mainpanel");
		action = new Actions(driver);
		action.moveToElement(lnk_contacts).build().perform();
		lnk_Contacts_NewContact.click();
		logger.log(LogStatus.PASS, "Clicked on Contacts --> New Contact Link");
	}
	
	public void clickContactlink()
	{
		switchtoframeByName("mainpanel");
		lnk_contacts.click();
		logger.log(LogStatus.PASS, "Clicked on Contacts");
	}
	
	
	
	
}
