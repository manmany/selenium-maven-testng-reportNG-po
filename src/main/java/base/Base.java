package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.commond;

public class Base implements ILogger {
	public WebDriver driver;
	
	public static long globaltimeout = 5;
	public final int TIMEOUT = 5;
	
	public Base() {

	}
	public Base(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT) , this);
	}


	/**
	 * PO中如何封装查找元素、显示时间等待，错误截图，操作步骤日志
	 */
	
	public WebElement findElement(By by) {
		WebElement element = null;
		try {
			element = new WebDriverWait(driver, globaltimeout).until(ExpectedConditions.presenceOfElementLocated(by));
//			logger.info(this.getClass().getName() + by.toString() + "对象被访问");
			return element;
		}catch (Exception e) {
//			logger.error(element + " not found");
//			String filename = this.getClass().getName();
//			commond.shotscreen(driver, filename);
//			logger.info("screenshot as "+ filename);
		}
	
		return element;
	}
	
	public WebElement findElement(By by, long timeout) {
		WebElement element = null;
		try {
			element = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(by));
//			logger.info(this.getClass().getName() + by.toString() + "对象被访问");
			return element;
		}catch (Exception e) {
//			logger.error(element + " not found");
			String filename = this.getClass().getName();
			commond.shotscreen(driver, filename);
//			logger.info("screenshot as "+ filename);
		}
		
		return element;
	}
	
	// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
	public void startTest(String sTestCaseName) {
		logger.info("****************************************************************************************");
		 
		logger.info("****************************************************************************************");
	 
		logger.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
	 
		logger.info("****************************************************************************************");
	 
		logger.info("****************************************************************************************");
	 
	}
	
	//This is to print log for the ending of the test case
	 public static void endTestCase(String sTestCaseName){
		 
		 logger.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
		 
		 logger.info("X");
		 
		 logger.info("X");
		 
		 logger.info("X");
		 
		 logger.info("X");
		 
	}
	 
	// Need to create these methods, so that they can be called  
	 
	 public static void info(String message) {
	 
			logger.info(message);
	 
	}
	 
	 public static void warn(String message) {
	 
	    logger.warn(message);
	 
		}
	 
	 public static void error(String message) {
	 
	    logger.error(message);
	 
		}
	 
	 public static void fatal(String message) {
	 
	    logger.fatal(message);
	 
		}
	 
	 public static void debug(String message) {
	 
	    logger.debug(message);
	 
		}
	 
	 /*
	  * 获取测试方法名
	  */
	 public String getTestName(Class class1) {
		 return  class1.getName() + "." + Thread.currentThread().getStackTrace()[2].getMethodName();	 
	 }
}
