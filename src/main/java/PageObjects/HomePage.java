package PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import base.Base;

public class HomePage extends Base {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}


	/* 定义百度搜索的输入框*/
	@FindBy(id="kw")
	@CacheLookup
	public WebElement keyword_input;

	/* 定义百度搜索的搜索按钮*/

	@FindBy(id="su")
	@CacheLookup
	public WebElement search_button;
	
	//输入关键字，并点击查询
	public void searchByKeyword(String keyword) {
		type(keyword_input, keyword);
		click(search_button);
	}
	
}
