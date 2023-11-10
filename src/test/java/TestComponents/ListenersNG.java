package TestComponents;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;

import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersNG extends BaseTest implements ITestListener{
	  ExtentTest test;
	  ExtentReports extent=ExtentreporterNG.getRepoObject();
	  
	  @Override
	  public void onTestStart(ITestResult result) {
	    // not implemented
		 test=  extent.createTest(result.getMethod().getMethodName());
	  }
	  @Override
	  public void onTestSuccess(ITestResult result) {
	    // not implemented
		  test.log(Status.PASS, "Test Passed");
	  }

	  @Override
	  public void onTestFailure(ITestResult result) {
	    // not implemented
		  //test.log(Status.FAIL,"Test Failed");
		  test.fail(result.getThrowable());
		  try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver")
					  .get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		  
		  String filepath=null;
		  
			 try {
				filepath=getScreenShot(result.getMethod().getMethodName(),driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		
		  test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	  }

	  @Override
	  public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }
	  
	  @Override
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

		  
	  @Override
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }
	  
	  @Override
	  public void onStart(ITestContext context) {
	    // not implemented
	  }
	  
	  @Override
	  public void onFinish(ITestContext context) {
	    // not implemented
		  extent.flush();
	  }
	}


