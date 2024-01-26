package pageBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	private WebDriver driver;
	public homePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this); 
	}
	
	
	@FindBy (xpath = "//input[@id='pseudonym_session_unique_id']")
	WebElement userName;
	
	public void login() {
		userName.sendKeys("Hi");
		driver.close();
	}

}
