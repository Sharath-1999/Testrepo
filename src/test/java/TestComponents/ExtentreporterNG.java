package TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreporterNG extends BaseTest {
	

	public  static ExtentReports getRepoObject()
	{
		String path = System.getProperty("user.dir"+"//reports//index.html");
		ExtentSparkReporter reporter=new ExtentSparkReporter("path");
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Sharath Test Results");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sharath Chandra");
		
		
		return extent;
		
	}
}
