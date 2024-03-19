package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.homePage;
import utilities.configFile;

public class testbase {
	private WebDriver driver;
	
	public homePage setup() throws IOException {
		driver= new ChromeDriver();
		homePage hm= new homePage(driver);
		driver.get(configFile.getVal("url"));
		driver.manage().window().maximize();
		return hm;
	}
	@AfterMethod
	public void teardown() {
		
		driver.quit();
		
	}
}
