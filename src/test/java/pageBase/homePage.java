package pageBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import testBase.testbase;

public class homePage extends testbase{
	private WebDriver driver;
	
	public homePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this); 
	}
	
	
	@FindBy (xpath = "//span[text()='Text Box']")
	WebElement textBoxIcon;
	
	public void textBoxFunctionality() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(textBoxIcon));
		textBoxIcon.click();
		driver.close();
	}

}
