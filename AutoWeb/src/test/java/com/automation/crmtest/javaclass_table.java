package com.automation.crmtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javaclass_table {
	WebDriver driver;

	public static void main(String[] args) {
		javaclass_table j  = new javaclass_table();
		j.crmcontacttable();

	}

	public void crmcontacttable()
	{
		String status = "";
		WebElement ele;
		System.setProperty("webdriver.chrome.driver", "D:\\AK\\Selenium\\WebDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.get("http://www.crmpro.com/");
	  driver.findElement(By.name("username")).sendKeys("anil4684");
	  driver.findElement(By.name("password")).sendKeys("Ocwen@036");
	  ele = driver.findElement(By.xpath("//input[@type='submit']"));
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].click();", ele);
	
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[@title='Contacts']")).click();
		driver.findElement(By.xpath("//form[@id='vContactsForm']/table[@class='datacard']/descendant::tr/td/a[@_name='Bharath K']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
		driver.findElement(By.xpath(" //form[@id='vContactsForm']/table[@class='datacard']/descendant::tr/td/a[@_name='Bharath K']/parent::td/following-sibling::td/a/i[@title='Edit']")).click();
		driver.findElement(By.name("middle_initial")).sendKeys("Kumar3");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
}
