package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageBase.homePage;
import testBase.testbase;

public class demoqa_sanity extends testbase {
	
	
	@Test 
	void TC01_login() throws IOException, InterruptedException {
		homePage hm=setup();
		hm.login_Orange_HRM();
	}

}
