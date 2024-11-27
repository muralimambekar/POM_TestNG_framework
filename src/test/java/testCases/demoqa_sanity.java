package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import base.testBase;
import pageObjects.homePage;

public class demoqa_sanity extends testBase {
	
	
	@Test (priority=1)
	void TC01_login() throws IOException, InterruptedException {
		homePage hm=new homePage();
		hm.login_Orange_HRM();
	}
	
	@Test (priority=2)
	void TC02_login_fails_with_invalid_credentials() throws IOException, InterruptedException {
		homePage hm=new homePage();
		hm.login_Orange_HRM_invalid_credentials();
	}
	

}
