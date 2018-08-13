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

	/**
	 * 
	 * Testing the findElement not by Factory page
	 */
	@Test(dataProvider="searchkeyword", groups="test")
	public void TestBaidu(String keyword) {	
		String osType = System.getProperty("os.name");
		System.out.println("Test on " + osType);
		if(osType.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		}

		driver = new FirefoxDriver();
		homePage = new HomePage(driver);
		testName = homePage.getTestName(this.getClass());
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
