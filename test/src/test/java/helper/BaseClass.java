package helper;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import dataProviderFactory.DataProviderFactory;

public class BaseClass {
	//we are creating objects so we can reference back to them
	//instead of calling the jar files every time.
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	//find by, how
	@BeforeSuite
	public void setupReport()
	{
		System.out.println("LOG: Info- Before Suite Running- Setting Up Report");
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") +"/Reports.AP"+Utility.getTime()+".html"));

		report = new ExtentReports();
		report.attachReporter(reporter);
		
		System.out.println("LOG: Info- After Suite Running - Reports are ready to use");
	}
		@BeforeClass
		public void setupBrowser()
		{
			System.out.println("LOG: INFO- Creating Browser Session");
			driver = BrowserFactories.startBrowser(
			DataProviderFactory.getConfig().getBrowser()
			,DataProviderFactory.getConfig().getStagingURL());
			System.out.println("LOG: Info- Browser Session Created");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		@AfterMethod
		public void appendReport(ITestResult result)
		{
			System.out.println("Test Name "+ result.getName());
			
			System.out.println("LOG: INFO- After method running - Generating test report");
			
			int status = result.getStatus();
			
			if(status==ITestResult.SUCCESS)
			{
				try
				{//build method for action classes to compile all the code into one action
					logger.pass("Test Scenario Passed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenShot(driver)).build());
						
				}
				
				catch (IOException e)
				{
					System.out.println("Not Able to attach screenshot "+e.getMessage());
				}
			}
			else if (status==ITestResult.FAILURE)
			{
				try
				{//get throwable basically tells you what type of exception it is
					logger.fail("Test Failed"+result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenShot(driver)).build());
				}
				catch(IOException e)
				{
					System.out.println("Not able to attach screenshot " +e.getMessage());
				}
			}
			else if (status== ITestResult.SKIP)
			{
				logger.skip("Test Scenario skipped");
			}//flush basically empties the old and starts the basis for a new report
			report.flush();
			
			System.out.println("LOG: INFO- After Method Executed- Test Result appended to report");
		}
		
//		@AfterClass
//		public void closeSessions()
//		{
//			System.out.println("LOG: INFO- Closing Browser Session");
//			driver.quit();
//			System.out.println("LOG: INFO- After method executed");
//		}
}


