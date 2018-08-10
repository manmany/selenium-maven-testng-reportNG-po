package com.man.test;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;


public class TestHome {
	WebDriver driver;
	HomePage homePage;
	String test_url = "http://www.baidu.com";
	String testName;

	@Test(dataProvider="searchkeyword", groups="test")
	public void TestBaidu(String keyword) {	
		testName = this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();	 
		driver = new FirefoxDriver();
		homePage = new HomePage(driver);
		homePage.startTest(testName);
		
		homePage.openUrl(test_url);
		homePage.searchByKeyword(keyword);
		homePage.close();
		
		homePage.endTestCase(testName);
  }
	
  @DataProvider(name = "searchkeyword")
  public static Object[][] searchDataProvider(){
	  return new Object[][] {{"selenium"}};
  }
  
}
