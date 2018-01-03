package com.automation.base;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.automation.utils.ConfigReader;
import com.automation.utils.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass extends ExcelReader

{
	protected static ExtentReports exreport;
	protected static ExtentTest logger;
	protected ConfigReader config = new ConfigReader();
	protected ExcelReader excel= new ExcelReader();
	JavascriptExecutor js ;
	protected  static WebDriver driver;

	 public void SetupBrowser()
	{
	
	//	String browser = config.getBrowser();
		 // Sample
		
		System.setProperty("webdriver.chrome.driver", config.getChromeDriverPath());
        driver = new ChromeDriver();
        setDriver(driver); 
	
		
		
	/*switch (browser)
		{
		case "chrome" : System.setProperty("webdriver.chrome.driver", config.getChromeDriverPath());
		                driver = new ChromeDriver();
		                setDriver(driver);
		                break;
			 
		case "firefox" : System.setProperty("webdriver.gecko.driver", config.getFirefoxDriverPath());
				        driver = new FirefoxDriver();
				        setDriver(driver);
				        break;
				        
        default :       break;
        
      		} */
	} 
	
	public void LaunchUrl(String url)
	{
	//	driver.manage().window().maximize();
		js =  (JavascriptExecutor)driver;
		js.executeScript("if(window.screen){ window.moveTo(0, 0); window.resizeTo(window.screen.availWidth, window.screen.availHeight);};");
	    driver.navigate().to(config.getUrl());
			//	driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	
	}
	
	public void driverClose()
	{
		driver.close();
	}
	
	public void driverQuit()
	{
		driver.quit();
	}
	
	public  void setDriver(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  WebDriver getDriver()
	{
		return driver;
	}
	
	public void wait(WebElement element)
	{
		System.out.println("---> Waiting for Element"+element);
		WebDriverWait wait = new WebDriverWait(driver,config.getMaxtime());
		wait.pollingEvery(config.getPolltime(), TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void switchtoframeByName(String framename)
	{
		driver.switchTo().frame(framename);
	}
	
	@BeforeSuite
	public void extentReport()
	{
		BaseClass base = new BaseClass();
		String reportpath = base.getReportPath()+"\\"+"AutomationReport.html";
		System.out.println("==== Report file Path is ===>"+reportpath);
		exreport = new ExtentReports(reportpath);
		exreport.addSystemInfo("OS", "WINDOWS 8");
	}
	
	@AfterClass
	public void afterClass()
	{
		exreport.endTest(logger);
	}
	
	@AfterSuite
	public void afterSuite()
	{
		exreport.flush();
	}
}
