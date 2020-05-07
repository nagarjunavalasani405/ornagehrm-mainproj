package testnglistenersITestlistener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListeners implements ITestListener {
	
     private static final String TakesScreenshot = null;
	WebDriver driver;
     
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test started and test case details are " +result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test success and test case details are " +result.getName());
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test Failed and test case details are "  +result.getName());
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//if(!IsNullOrundefinedObj(TakesScreenshot)driver)
		
			try {
				FileUtils.copyFile(source, new File("C:\\workspace\\orangehrm\\ScreenShots\\hrm.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test skipped and test case details are " +result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		
	}
	
	
	
	
	
		
}