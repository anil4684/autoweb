package com.automation.icehrmpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.automation.base.BaseClass;
import com.automation.utils.ConfigReader;

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
		}
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
	

}


