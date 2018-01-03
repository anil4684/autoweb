package com.automation.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class DemoTest {
  @Test(enabled=false)
  public void Demo() {
	  
	  System.out.println(" =====ANOTHER TEST ===== TEST2  ==>");
  }
  @BeforeClass
  public void beforeClass() {
  }

}
