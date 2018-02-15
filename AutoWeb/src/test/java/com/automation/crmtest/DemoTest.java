package com.automation.crmtest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class DemoTest extends BaseClass{
  @Test(enabled=true)
  public void Demo() {
	  
	  System.out.println(" =====ANOTHER TEST ===== TEST2  ==>");
	  logger.log(LogStatus.PASS, "Test Step Passed");
	  
  }
  @BeforeClass
  public void beforeClass() {
  }

}
