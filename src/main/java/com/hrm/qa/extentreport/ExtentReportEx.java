package com.hrm.qa.extentreport;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.hrm.qa.basepage.BaseClass;

public class ExtentReportEx extends BaseClass {
	
	@Test
	public void extentReport() throws IOException {
	
	ExtentHtmlReporter reporter = new ExtentHtmlReporter("C:\\workspace\\orangehrm\\extentreports\\orangehrm.html");
	
	ExtentReports extent = new ExtentReports();
	
	extent.attachReporter(reporter);
	
	ExtentTest test = extent.createTest("LoginTest"); //one test case
	
	
	test.log(Status.INFO, "login test info");
	
	test.log(Status.PASS, "login test pass");
	
	extent.flush();     // every test case end with flush
	
	ExtentTest test1 = extent.createTest("logout test"); // second test case
	
	test1.log(Status.INFO, "logon fail info");
	
	test1.log(Status.FAIL, "login test fail");
	
	test1.fail("thsis is failed test case",MediaEntityBuilder.createScreenCaptureFromPath("C:\\workspace\\orangehrm\\ScreenShots\\hrm.png").build());
	
	extent.flush();
	
	
	
	
	}
	
	
	
	

}
