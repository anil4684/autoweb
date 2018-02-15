package com.automation.icehrmpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.automation.base.BaseClass;
import com.automation.listener.TestCaseListener;
import com.relevantcodes.extentreports.LogStatus;

public class IcehrmHomePage extends BaseClass{
	
	WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement lnkhome;
	
	
	
	@FindBy(id="employeeLink")
	WebElement lnkPeople;
	
	@FindBy(id="companyLink")
	WebElement lnkCompany;
	
	@FindBy(id="usersLink")
	WebElement lnkUser;
	
	@FindBy(id="projectsLink")
	WebElement lnkProject;
	
	
	@FindBy(id="attendanceLink")
	WebElement lnkAttendance;
	
	@FindBy(id="reportsLink")
	WebElement lnkReport;
	
	
	
	public IcehrmHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
				
	}
	
	public void clickOnHome()
	{
		BaseClass base = new BaseClass();
		try
		{
			if (lnkhome.isEnabled() && lnkhome.isDisplayed()) 
			{
				System.out.println("Clicking on element with using java script click");
			JavascriptExecutor je = (JavascriptExecutor)driver;
			je.executeScript("arguments[0].click();",lnkhome);
			
		// je.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", lnkhome);
			} else 
			{
				System.out.println("Unable to click on element");


		
	//	base.webDriverWaitUntilClickable(lnkhome);
	//	lnkhome.click();
		}
	}
		
	
	 catch (StaleElementReferenceException e) {
		System.out.println("Element is not attached to the page document "+ e.getStackTrace());
	} catch (NoSuchElementException e) {
		System.out.println("Element was not found in DOM "+ e.getStackTrace());
	} catch (Exception e) {
		System.out.println("Unable to click on element "+ e.getStackTrace());
	}
	}
	
	public void clickOnPeopleLink()
	{
		lnkPeople.click();
		logger.log(LogStatus.PASS, "Clicked  on People Link");
	}
	
	public void clickOnCompanyLink()
	{
		lnkCompany.click();
		logger.log(LogStatus.PASS, "Clicked  on Company Link");
	}
	
	public void clickOnLeaveManagement() throws FindFailed
	{
		try
		{
		Pattern leavemanagementtab= new Pattern(config.getSikuliImagePath()+"\\LeaveManagementTab.PNG");
		System.out.println("Patten"+leavemanagementtab);
		Screen s = new Screen();
	    s.click(leavemanagementtab);
		}
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
	
		
	public void clickOnProjectLink()
	{
		lnkProject.click();
		logger.log(LogStatus.PASS, "Clicked  on Company Link");
	}
	
	public void clickOnUserLink()
	{
		lnkUser.click();
		logger.log(LogStatus.PASS, "Clicked  on People Link");
	}
	
	public void clickOnAttendance()
	{
		lnkAttendance.click();
	}
	
	public void clickOnReport()
	{
		lnkReport.click();
	}
	
	public void backTohomePage()
	{
		
		BaseClass base = new BaseClass();
		driver = base.getDriver();
		driver.navigate().to("https://icehrm.com/app/anil4684/?g=admin&n=dashboard&m=admin_Admin");
		logger.log(LogStatus.PASS, "Navigated to Home Page");
	}

}
