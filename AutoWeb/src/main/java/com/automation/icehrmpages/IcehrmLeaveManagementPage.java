package com.automation.icehrmpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.automation.base.BaseClass;
import com.automation.extentreport.ExtentTestManager;
import com.automation.utils.ConfigReader;
import com.relevantcodes.extentreports.LogStatus;

public class IcehrmLeaveManagementPage extends BaseClass{
	WebDriver driver;
	
	public IcehrmLeaveManagementPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	ConfigReader config = new ConfigReader();
	
	public void clickOnAddNewButton() throws FindFailed
	{
		try
		{
		Pattern btn_addNew= new Pattern(config.getSikuliImagePath()+"\\AddNewBtn.PNG");
		Screen s = new Screen();
	    s.click(btn_addNew);
	 //   ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked  on New  Button");
		}
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
	
	public void enterCode(String code) throws FindFailed
	{
		try
		{
		Pattern txt_code= new Pattern(config.getSikuliImagePath()+"\\txt_Code.PNG");
		Screen s = new Screen();
	    s.type(txt_code,code);
	  //  ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Code");
		}
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
	

}


