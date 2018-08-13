package com.man.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import PageObjects.LoginPage;

public class TestLogin {
  @Test
  public void TestBaidu() {
	  WebDriver  driver = new FirefoxDriver();
	  LoginPage loginPage  = new LoginPage();
	  loginPage.driver = driver;
	  loginPage.driver.get("www.baidu.com");
	  loginPage.searchByKeyword2("test");
	  loginPage.driver.close();
  }
}
