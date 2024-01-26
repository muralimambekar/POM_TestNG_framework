package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageBase.homePage;

public class testbase {
	private WebDriver driver;
	
	@BeforeTest
	public homePage setup() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		homePage hm= new homePage(driver);
		driver.get("https://demoqa.com");
		driver.manage().window().maximize();
		return hm;
	}

}
