package com.man.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestDemo {
	@Test
	public void TestDemo() {
		String osType = System.getProperty("os.name");
		System.out.println("Test on " + osType);
		if(osType.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		}

		System.out.println("launching firefox browser");
		WebDriver driver = new FirefoxDriver();
		String urlAddress = "http://www.baidu.com";
		driver.get(urlAddress);
		driver.close();
	}
}
