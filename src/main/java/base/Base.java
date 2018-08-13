package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.commond;
import bsh.org.objectweb.asm.Type;

public class Base implements ILogger {
	public static WebDriver driver;
	public static String pageTitle;
	public static String pageUrl;
	
	public static long globaltimeout = 5;
	public final int TIMEOUT = 5;
	
	/*
	 * 构造方法
	 */
	public Base() {

	}
	public Base(WebDriver driver) {
		Base.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT) , this);
	}


	/**
	 * PO中如何封装查找元素、显示时间等待，错误截图，操作步骤日志
	 */
	
	public WebElement findElement(By by) {
		WebElement element = null;
		try {
			element = new WebDriverWait(driver, globaltimeout).until(ExpectedConditions.presenceOfElementLocated(by));
			logger.info(this.getClass().getName() + by.toString() + "对象被访问");
			return element;
		}catch (Exception e) {
			logger.error( by.toString()+ " not found");
			String filename = this.getClass().getName()+by.toString();
			commond.shotscreen(driver, filename);
			logger.info("screenshot as "+ filename);
			return element;
		}
		
	}
	
	public WebElement findElement(By by, long timeout) {
		WebElement element = null;
		try {
			element = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(by));
			logger.info(this.getClass().getName() + by.toString() + "对象被访问");
			return element;
		}catch (Exception e) {
			logger.error(by.toString() + " not found");
			String filename = this.getClass().getName() + System.currentTimeMillis();
			commond.shotscreen(driver, filename);
			logger.info("screenshot as "+ filename);
			return element;
		}	
	}
	
	// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
	public static void startTest(String sTestCaseName) {
		logger.info("***********************************************************************************************************************");
		 
		logger.info("***********************************************************************************************************************");
	 
		logger.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
	 
		logger.info("***********************************************************************************************************************");
	 
		logger.info("***********************************************************************************************************************");
	 
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
	 public static String getTestName(Class class1) {
		 return  class1.getName() + "." + Thread.currentThread().getStackTrace()[2].getMethodName();	 
	 }
	 
	 /*
	  * 获取页面的url
	  */
	 protected String getCurrentPageUrl() {
		 pageUrl = driver.getCurrentUrl();
		 info("Current page url is  " + pageUrl);
		 return pageUrl;
	 }
	 
	 /*
	  * 获取当前页面的title
	  */
	 protected String getCurrentPageTitle() {
		 pageTitle = driver.getTitle();
		 info("Current page tile  is " + pageTitle);
		 return pageTitle;
	 }
	 
	 /*
	  * 在文本框内输入字符
	  */
	 protected void type(WebElement element, String text) {
		try {
			if(element.isEnabled()) {
				element.clear();
				info("Clean the value if any in" + element.toString() + ".");
				element.sendKeys(text);
				info("Type value is:  "+ text + ".");
			}
		}catch (Exception e) {
			error(e.getMessage() + ".");
		}
	}
	 /*
	  * 点击元素，这里☞点击鼠标左键
	  */
	 
	 protected void click(WebElement element) {
		try {
			if (element.isEnabled()) {
				element.click();			
				info("Element " + element.toString() + "was clicked.");
			}
		} catch (Exception e) {
			error(e.getMessage() + ".");
		}
	}
	
	 /*
	  * 等待时间
	  */
	 public void waitload() {
		 driver.manage().timeouts().implicitlyWait(globaltimeout, TimeUnit.SECONDS);
		 info("Waiting " + globaltimeout + " seconds.");
	 }
	
	 /*
	  * 打开网址
	  */
	 public void openUrl(String test_url) {
		 driver.get(test_url);
		 info("Open WebSite:"  + test_url);
	 }
	 
	 public void maximize() {
		driver.manage().window().maximize();
		info("maximize the browser");
	}
	 /*
	  * 关闭浏览器
	  */
	 
	 public void close() {
		driver.close();
		info("close browser");
	}
}
