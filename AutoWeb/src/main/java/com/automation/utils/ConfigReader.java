package com.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {


	public static Properties prop;
	static String currentdirectory;
	
	public   ConfigReader()
	{
		try
		{
			currentdirectory = System.getProperty("user.dir");
			String proppath = currentdirectory+"\\src\\main\\resources\\com\\automation\\config"+"\\config.properties";
			File fs = new File(proppath);
	    	FileInputStream fis = new FileInputStream(fs);
	    	prop = new Properties();
	    	prop.load(fis);
				
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	

	
	public String getChromeDriverPath()
	{	
		String chrome = prop.getProperty("chromedriverpath");
		String chromepath = currentdirectory+"\\"+chrome;
		System.out.println("Chrome PAth"+chromepath);
		return chrome;
	}
	
	public String getFirefoxDriverPath()
	{
		String firefox = prop.getProperty("firefoxdriverpath");
		String firefoxpath = currentdirectory+"\\"+firefox;
		System.out.println("fire->"+firefoxpath);
		return firefoxpath;
	}
	
	public String getIEDriverPath()
	{
		String ie = prop.getProperty("iedriverpath");
		String iepath = currentdirectory+"\\"+ie;
		System.out.println("fire->"+iepath);
		return iepath;
	}
	
	public String getCrmTestDatapath()
	{
		String testdatapth = prop.getProperty("crmtestdatapath");
		System.out.println(" CRM Test Data Path is "+testdatapth);
		return testdatapth;
	}
	
	public String getIceHrmTestDatapath()
	{
		String testdatapth = prop.getProperty("icehrmtestdatapath");
		System.out.println(" Ice Hrm Test Data Path is "+testdatapth);
		return testdatapth;
	}
	
	public String getMyHrTestDatapath()
	{
		String testdatapth = prop.getProperty("myhrtestdatapath");
		System.out.println("My Hr Test Data Path is "+testdatapth);
		return testdatapth;
	}
	
	public String getSkyTestDatapath()
	{
		String testdatapth = prop.getProperty("skytestdatapath");
		System.out.println("Test Data Path is "+testdatapth);
		return testdatapth;
	}
	
	public String getTestDatapath()
	{
		String testdatapth = prop.getProperty("testdatapath");
		System.out.println("Test Data Path is "+testdatapth);
		return testdatapth;
	}
	
	public String getCrmUrl()
	{
		String url = prop.getProperty("crmurl");
		System.out.println("URL is "+url);
		return url	;
	}
	
	public String getCrmUserName()
	{
		String username = prop.getProperty("crmusername");
		System.out.println("User Name is "+username);
		return username;
	}
	
	public String getCrmUserPassword()
	{
		String password = prop.getProperty("crmpassword");
		System.out.println("Password is "+password);
		return password;
	}
	
	
	public String getIcehrmUrl()
	{
		String url = prop.getProperty("icehrmurl");
		System.out.println("URL is "+url);
		return url	;
	}
	

	
	public String getIcehrmUserName()
	{
		String username = prop.getProperty("icehrmusername");
		System.out.println("User Name is "+username);
		return username;
	}
	

	
	public String getIcehrmUserPassword()
	{
		String password = prop.getProperty("icehrmpassword");
		System.out.println("Password is "+password);
		return password;
	}
	
	public String getMyhrUrl()
	{
		String url = prop.getProperty("myurl");
		System.out.println("URL is "+url);
		return url	;
	}
	
	public String getMyhrUserName()
	{
		String username = prop.getProperty("myhrusername");
		System.out.println("User Name is "+username);
		return username;
	}
	
	public String getMyhrUserPassword()
	{
		String password = prop.getProperty("myhrpassword");
		System.out.println("Password is "+password);
		return password;
	}
	
	public String getSkyUrl()
	{
		String url = prop.getProperty("skyurl");
		System.out.println("URL is "+url);
		return url	;
	}
	
	public String getSkyUserName()
	{
		String username = prop.getProperty("skyusername");
		System.out.println("User Name is "+username);
		return username;
	}
	
	public String getSkyUserPassword()
	{
		String password = prop.getProperty("skypassword");
		System.out.println("Password is "+password);
		return password;
	}
	
	public String getBrowser()
	{
		String browser = prop.getProperty("browser");
		System.out.println("Browser is "+browser);
		return browser;
	}
	
	public long getMaxtime()
	{
		long maxwaitpoll = Long.parseLong(prop.getProperty("maxtime"));
		System.out.println("Max Pool is "+maxwaitpoll);
		return maxwaitpoll;
	}
	
	public long getPolltime()
	{
		long polltime = Long.parseLong(prop.getProperty("polltime"));
		System.out.println("Poll time  is "+polltime);
		return polltime;
	}

	
	 public String getReportPath()
	 {
		 String reportpath = currentdirectory+"\\"+prop.getProperty("report");
		 System.out.println("Report Path is --> "+reportpath);
		 return reportpath;
	 }
	 
	 public String getSikuliImagePath()
	 {
		 String reportpath = currentdirectory+"\\"+prop.getProperty("sikuliImagePath");
		 System.out.println("sikuliImage Path is --> "+reportpath);
		 return reportpath;
	 }
}
