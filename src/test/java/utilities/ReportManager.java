package utilities;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
	
	private static ThreadLocal<ExtentReports> extent = new ThreadLocal<ExtentReports>();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	
	public static void initializeReport() throws IOException {
    	// Create ExtentReports instance
        ExtentReports extentInstance = new ExtentReports();
        String dateTime=String.valueOf(System.currentTimeMillis());
        // Attach reporter to specify the output location
        //ExtentSparkReporter spark = new ExtentSparkReporter("./reports/"+reportName+".html");
        ExtentSparkReporter spark = new ExtentSparkReporter("./reports/"+configFile.getVal("projectName")+"_"+dateTime+".html");
        extentInstance.attachReporter(spark);

        // Add information to the report
        extentInstance.setSystemInfo("OS", "Windows");
        extentInstance.setSystemInfo("Tester", "John Doe");
        extent.set(extentInstance);
        System.out.println("Extent object created");
        //return extent;
    	
    }
    
    public static synchronized void createTest(String testName) {
    	 // Create test case
        ExtentTest extentest = extent.get().createTest(testName).info(testName+" test started");
        test.set(extentest);
        //System.out.println("Test object created");
        //return test;
    }
    
    public static synchronized void logTestStep(Status status, String log) {
        test.get().log(status, log);
    }
    
    public static synchronized void flushReport() {
        extent.get().flush();
    }
    

}
