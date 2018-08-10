package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class commond {
	public static void shotscreen(WebDriver driver, String filename) {
		//获取截图
		File  screenshotFile =( (TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//保存路径
		try {
			FileUtils.copyFile(screenshotFile, new File("screenshots/" + filename + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
