package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import pageObjects.homePage;
import utilities.DriverFactory;

public class PageBase {
	private WebDriver driver;
	
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
	
	public PageBase() throws IOException {
		driver= DriverFactory.getWebDriver();
	}
	
	public void clickElement(WebElement element, String elementName) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		System.out.println("clicked on "+elementName);
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
