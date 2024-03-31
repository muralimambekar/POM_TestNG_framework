package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
	
	
}
