package com.automation.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.pages.LoginPage;


public class sampletestngclass extends BaseClass {
	

  @Test (enabled=false)
  public void sampletestngclass_test() {

	  System.out.println("<========================Executed TEST CASE ===============>");
	  Assert.assertTrue(false, "SAMPLE");
  }
}
