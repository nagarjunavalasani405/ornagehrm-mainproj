package com.hrm.qa.utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportExaplSrcshot {
	
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeMethod
	public void setUp() {
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("C:\\workspace\\orangehrm\\extentreports\\hrm.html");
		
		 extent = new ExtentReports();
		
		 extent.attachReporter(reporter);
		
		//test = extent.createTest("loginTest");
		
	}
	@Test
	public void loginExample() {
		
		test = extent.createTest("loginTest");

		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
	    
	    
	    driver.findElement(By.id("txtUsernam")).sendKeys("Admin");
		
	}
	
	@AfterTest
	public void tearDown(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
		    Utilities.TakeScreenShot();
		    
		    test.log(Status.FAIL, (Markup) MediaEntityBuilder.createScreenCaptureFromPath("C:\\workspace\\orangehrm\\ScreenShots\\hrm.png").build());
			test.log(Status.INFO, "this is failed test case");
		}
		extent.flush();
		driver.quit();
		
	}
	
	
	
	

}
