package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Base;

public class LoginPage extends Base{
	
	public LoginPage() {
		super();
	}
	WebElement keyword_input2 = driver.findElement(By.id("kw"));
	WebElement search_button2 = driver.findElement(By.id("su"));
	//输入关键字，并点击查询
	public void searchByKeyword2(String keyword) {
		keyword_input2.sendKeys(keyword);
		search_button2.click();
	}
}
