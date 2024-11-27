package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import pageObjects.homePage;
import utilities.DriverFactory;
import utilities.ReportManager;
import utilities.configFile;

public class testBase {
	private WebDriver driver;
	
	@BeforeClass
	public void beforeClass() throws IOException {
		ReportManager.initializeReport();
	}
	
	@BeforeMethod
	public void setup(ITestResult tr,Method m) throws IOException {
		System.out.println("Test "+m.getName()+" started ");
		ReportManager.createTest(m.getName());
		DriverFactory.setWebDriver();
	}
	
	
	@AfterMethod
	public void teardown() {
		driver= DriverFactory.getWebDriver();
		driver.quit();
		
		
	}
	
	@AfterClass
	public void endofClass() {
		ReportManager.flushReport();
	}
}
