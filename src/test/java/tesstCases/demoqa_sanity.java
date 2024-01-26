package tesstCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageBase.homePage;
import testBase.testbase;

public class demoqa_sanity extends testbase {
	
	
	@Test (priority = 1)
	void TC01_login() throws IOException {
		homePage hm=setup();
		hm.textBoxFunctionality();
	}

}
