package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageBase.homePage;
import testBase.testbase;

public class demoqa_sanity extends testbase {
	
	
	@Test (priority=1)
	void TC01_login() throws IOException, InterruptedException {
		homePage hm=setup();
		hm.login_Orange_HRM();
	}
	
	@Test (priority=2)
	void TC01_login_fails_with_invalid_credentials() throws IOException, InterruptedException {
		homePage hm=setup();
		hm.login_Orange_HRM_invalid_credentials();
	}

}
