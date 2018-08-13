package PageObjects;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Base;

public class HomePage2 extends Base{
	protected WebElement input;
	protected  WebElement submit;
	
	public HomePage2(WebDriver driver) {
		super(driver);
	}
	
	public void openUrl(String test_url) {
		this.driver.get(test_url);
		assertEquals(getCurrentPageTitle(), "百度一下，你就知道", "打开网址不正确");
		assertEquals(getCurrentPageUrl(), test_url, "网址不正确");
	}
	
	//输入关键字，并点击查询
	public void searchByKeyword2(String keyword) throws InterruptedException {
		setInput(findElement(By.id("kw")));
		setSubmit(findElement(By.id("su")));
		type(getInput(), keyword);
		click(getSubmit());
		Thread.sleep(1000);
		assertEquals(getCurrentPageTitle(), keyword + "_百度搜索", "搜索结果不正确");
	}

	public WebElement getInput() {
		return input;
	}

	public void setInput(WebElement input) {
		this.input = input;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public void setSubmit(WebElement submit) {
		this.submit = submit;
	}
	
	
}
