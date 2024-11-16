package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import pageObjects.homePage;
import utilities.DriverFactory;

public class PageBase {
	private WebDriver driver;
	
	public PageBase() throws IOException {
		driver= DriverFactory.getWebDriver();
	}
	
	public void click(WebElement element) {
		element.click();
		System.out.println("clicked");
	}
	
	public void takeScreenshot() {
		String dateTime=String.valueOf(System.currentTimeMillis());
		File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("./screenshots/img_"+dateTime));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Screenshot captured successfully");
		
	}
	
	
}
