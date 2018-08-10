package com.man.test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import base.Base;

public class TestBaiduSearch extends Base{
  @Test
  public void TestBaiduSearch() {
	  driver = new FirefoxDriver();
	  driver.get("https://www.baidu.com");
	  WebElement input = driver.findElement(By.id("kw"));
	  WebElement submit = driver.findElement(By.id("su"));
	  input.sendKeys("test");
	  submit.click();
	  driver.close();  
  }
}
