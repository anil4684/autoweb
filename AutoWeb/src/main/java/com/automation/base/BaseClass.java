package com.automation.base;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.automation.listener.TestCaseListener;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass 

{
	protected static ExtentReports exreport;
	protected static ExtentTest logger;
	protected ConfigReader config = new ConfigReader();
	protected ExcelReader excel= new ExcelReader();
	JavascriptExecutor js ;
	
	protected  static  WebDriver driver;

	 public void SetupBrowser()
	{
	
	String browser = config.getBrowser();
	
		
	if(browser.equalsIgnoreCase("chrome"))
	{
	System.setProperty("webdriver.chrome.driver", config.getChromeDriverPath());
		                driver = new ChromeDriver();
		                setDriver(driver);
	}
	else if (browser.equalsIgnoreCase("firefox"))
	{
	 System.setProperty("webdriver.gecko.driver", config.getFirefoxDriverPath());
				        driver = new FirefoxDriver();
				        setDriver(driver);
       		} 
	else if (browser.equalsIgnoreCase("ie"))
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		cap.setCapability("ignoreZoomSetting", true);
		
	 System.setProperty("webdriver.ie.driver", config.getIEDriverPath());
				        driver = new InternetExplorerDriver();
				        setDriver(driver);
				        driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
       		}
	} 
	
	public void LaunchUrl(String url)
	{
		driver.manage().window().maximize();
		js =  (JavascriptExecutor)driver;
//		js.executeScript("if(window.screen){ window.moveTo(0, 0); window.resizeTo(window.screen.availWidth, window.screen.availHeight);};");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    driver.get(url);
			//	driver.manage().deleteAllCookies();
	
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
	
		

	
	public void webdriverwait(WebElement element)
	{
		System.out.println("---> Waiting for Visiblity of Element"+element);
		WebDriverWait wait = new WebDriverWait(driver,config.getMaxtime());
		wait.pollingEvery(config.getPolltime(), TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void webDriverWaitUntilClickable(WebElement element)
	{
		System.out.println("---> Waiting for Element to be Clickable"+element);
		WebDriverWait wait = new WebDriverWait(driver,config.getMaxtime());
		wait.pollingEvery(config.getPolltime(), TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public void switchtoframeByName(String framename)
	{
		driver.switchTo().frame(framename);
	}
	
	
	
	@BeforeSuite
	public synchronized static ExtentReports extentReport()
	{
		ExcelReader excel = new ExcelReader();
		String reportpath = excel.getReportPath()+"\\"+"AutomationReport.html";
		System.out.println("==== Report file Path is ===>"+reportpath);
		exreport = new ExtentReports(reportpath);
		exreport.addSystemInfo("OS", "WINDOWS 8");
		
		// Screen Grab https://github.com/anshooarora/extentreports-java/issues/751
		//  Report using Listener  https://www.swtestacademy.com/extentreports-testng/  
		 // Allure Report https://www.swtestacademy.com/allure-testng/
		return exreport;
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
