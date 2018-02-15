package com.automation.crmtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.crmpages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;


public class Sampletestngclass_Test extends BaseClass {
	

  @Test (enabled=true)
  public void sampletestngclass_test() {

	  System.out.println("<========================Executed TEST CASE ===============>");
	  logger.log(LogStatus.PASS, "Executed the step");
  }
}
