package com.automation.base;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import com.automation.listener.TestCaseListener;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass 

{
	protected static ExtentReports exreport;
	protected static ExtentTest logger;
	protected ConfigReader config = new ConfigReader();
	protected ExcelReader excel= new ExcelReader();
	JavascriptExecutor js ;
	
	protected   WebDriver driver;
//	private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new InheritableThreadLocal<>();
	
	private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	

	 public WebDriver SetupBrowser()
	{
	
	String browser = config.getBrowser();
	
		
	if(browser.equalsIgnoreCase("chrome"))
	{
	System.setProperty("webdriver.chrome.driver", config.getChromeDriverPath());
		                driver = ThreadGuard.protect( new ChromeDriver());
		                setDriver(driver);
		                return driver;
	}
	else if (browser.equalsIgnoreCase("firefox"))
	{
	 System.setProperty("webdriver.gecko.driver", config.getFirefoxDriverPath());
				        driver = new FirefoxDriver();
				        setDriver(driver);
				        return driver;
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
				        return driver;
       		}
	
	return driver;
	} 
	
	public void LaunchUrl(String url)
	{
		BaseClass base = new BaseClass();
		base.getDriver().manage().window().maximize();
//	    js =  (JavascriptExecutor)driver;
//		js.executeScript("if(window.screen){ window.moveTo(0, 0); window.resizeTo(window.screen.availWidth, window.screen.availHeight);};");
		base.getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		base.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		base.getDriver().get(url);
		System.out.println(" Thread ID is ====> "+Thread.currentThread().getId());
		System.out.println(" Thread HASH CODE is ====> "+base.getDriver().hashCode());
			//	driver.manage().deleteAllCookies();
	
	}
	
	public void driverClose()
	{
		BaseClass base = new BaseClass();
		base.getDriver().close();
	}
	
	public void driverQuit()
	{
		BaseClass base = new BaseClass();
		base.getDriver().quit();
	}
	
	static  void setDriver(WebDriver driver)
	{
		webDriver.set(driver);
	}
	
	public  WebDriver getDriver()
	{
		return webDriver.get();
	}
	
		

	
	public void webdriverwait(WebElement element)
	{
		System.out.println("---> Waiting for Visiblity of Element"+element);
		WebDriverWait wait = new WebDriverWait(getDriver(),config.getMaxtime());
		wait.pollingEvery(config.getPolltime(), TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void webDriverWaitUntilClickable(WebElement element)
	{
		System.out.println("---> Waiting for Element to be Clickable"+element);
		WebDriverWait wait = new WebDriverWait(getDriver(),config.getMaxtime());
		wait.pollingEvery(config.getPolltime(), TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public void switchtoframeByName(String framename)
	{
		driver.switchTo().frame(framename);
	}
	
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
	//	FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	/*
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
	
	
	@AfterMethod (alwaysRun=true)
	public void tearDown() 
	{
		exreport.endTest(logger);
		driverClose();
	} 
	
	@AfterSuite (alwaysRun=true)
	public void afterSuite()
	{
		exreport.flush();
	}
	 */
	
}

// Parallel Extent Report : http://extentreports.com/docs/versions/2/java/
