package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.homePage;
import utilities.DriverFactory;
import utilities.configFile;

public class testBase {
	private WebDriver driver;
	
	@BeforeMethod
	public void setup() throws IOException {
		DriverFactory.setWebDriver();
	}
	
	
	@AfterMethod
	public void teardown() {
		driver= DriverFactory.getWebDriver();
		driver.quit();
		
	}
}
