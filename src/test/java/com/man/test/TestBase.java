package com.man.test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;

public class TestBase extends Base{

	@BeforeMethod
	public void BeforeMethod() {
		 
	}
	
	/**
	 * Testing the findElement not by Factory page
	 */
  @Test
  public void TestBase() {
	  driver = new FirefoxDriver();
	  startTest(getTestName(this.getClass()));
	  driver.get("https://www.baidu.com");
	  WebElement input = findElement(By.id("kw"));
	  WebElement submit = findElement(By.id("su"));
	  input.sendKeys("test");
	  submit.click();
	  driver.close();  
	  
  }
  @AfterTest
  public void AfterTest() {
	  endTestCase(getTestName(this.getClass()));
  }
}
