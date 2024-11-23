package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverFactory {
	
	private static WebDriver driver;
	
	public static void setWebDriver() throws IOException {
		driver=new ChromeDriver();
		driver.get(configFile.getVal("url"));
		driver.manage().window().maximize();
	}
	
	public static WebDriver getWebDriver() {
		return driver;
	}

}
