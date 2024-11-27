package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.PageBase;
import base.testBase;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import utilities.DriverFactory;
import utilities.ReportManager;
import utilities.configFile;

public class homePage  extends PageBase  {
	private WebDriver driver;
	private WebDriverWait wait;
	//private static ReportManager report;
	
	
	public homePage() throws IOException{
		this.driver=DriverFactory.getWebDriver();
		PageFactory.initElements(driver, this); 
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//ReportManager.initializeReport();
	}
	
	
	@FindBy (xpath = "//span[text()='Text Box']")
	WebElement textBoxIcon;
	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	WebElement dasboardHeading;
	
	
	@FindBy(xpath="//p[text()='Invalid credentials']")
	WebElement invalidCredentialErrorMsg;
	
	public void login_Orange_HRM() throws IOException, InterruptedException {
		try {
			//ReportManager.createTest("login_Orange_HRM");
			wait.until(ExpectedConditions.visibilityOf(userName));
			userName.sendKeys(configFile.getVal("username"));
			password.sendKeys(configFile.getVal("password"));
			ReportManager.logTestStep(Status.INFO, "Entered user name and password");
			clickElement(loginBtn,"loginBtn");
			wait.until(ExpectedConditions.visibilityOf(dasboardHeading));
			ReportManager.logTestStep(Status.PASS, "Login successfull");
			Thread.sleep(3000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public void login_Orange_HRM_invalid_credentials() throws IOException, InterruptedException {
		try {
			//ReportManager.createTest("login_Orange_HRM");
			wait.until(ExpectedConditions.visibilityOf(userName));
			userName.sendKeys(configFile.getVal("username"));
			password.sendKeys("wrongPwd");
			ReportManager.logTestStep(Status.INFO, "Entered user name and password");
			loginBtn.click();
			wait.until(ExpectedConditions.visibilityOf(invalidCredentialErrorMsg));
			ReportManager.logTestStep(Status.PASS, "Login failure verified");
			Thread.sleep(3000);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenshot();
		}
	}
	
	
	public void login_fails_with_screenshot() throws IOException, InterruptedException {
		try {
			
			wait.until(ExpectedConditions.visibilityOf(userName));
			userName.sendKeys(configFile.getVal("username"));
			password.sendKeys("wrongPwd");
			loginBtn.click();
			wait.until(ExpectedConditions.visibilityOf(dasboardHeading));
			Thread.sleep(3000);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenshot();
		}
	}

}
