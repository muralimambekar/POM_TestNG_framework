package utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestListener;
import org.testng.ITestResult;



public class myListener implements ITestListener  {
	
	public void onTestStart(ITestResult tr) {
		

		System.out.println("Test started ");
		
	}
	
public void onTestSuccess(ITestResult tr) {
		
		System.out.println("on success");
		
	}

public void onTestFailure(ITestResult tr) {
	
	System.out.println("on Failure");
	
}

public void onTestSkipped(ITestResult tr) {
	
	System.out.println("on skip");
	
}

}
