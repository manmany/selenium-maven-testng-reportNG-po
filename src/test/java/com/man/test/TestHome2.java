package com.man.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import PageObjects.HomePage2;

public class TestHome2 {
	 String test_url = "https://www.baidu.com/";
	 WebDriver  driver;
	 HomePage2 homePage2;
	 
	/**
	 * Testing the findElement not by Factory page
	 * @throws InterruptedException 
	 */
  @Test
  public void TestHome() throws InterruptedException {
		String osType = System.getProperty("os.name");
		System.out.println("Test on " + osType);
		if(osType.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		}

	  driver = new FirefoxDriver();
	  homePage2  = new HomePage2(driver);	  
	  homePage2.startTest(homePage2.getTestName(this.getClass()));
	  homePage2.openUrl(test_url);
	  homePage2.maximize();
	  homePage2.searchByKeyword2("test");
	  
  }
  @AfterTest(alwaysRun=true)
  public void AfterTest() {
	  homePage2.close();
  }
}
