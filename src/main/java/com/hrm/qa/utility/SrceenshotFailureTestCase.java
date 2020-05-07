package com.hrm.qa.utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class SrceenshotFailureTestCase {
	
	WebDriver driver;
	
	@Test
	public void screenShotFailure() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
	    
	    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	    driver.findElement(By.name("Subm")).click();
	    	
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception { // (result)..is  refference variable it will store all test case data
		
		if(ITestResult.FAILURE==result.getStatus())
		{
		
			 Utilities.TakeScreenShot();           // if we use result.getname() is a screenshot name...it will take name automatically
		}
		                                           // as per test name that is the screenshot name
		//driver.quit();
		
		
	}
		
	
	
	
	

}
