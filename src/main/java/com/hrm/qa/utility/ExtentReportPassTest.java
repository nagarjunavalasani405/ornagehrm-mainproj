package com.hrm.qa.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportPassTest {
	
	 WebDriver driver;
	 ExtentReports extent;
	 ExtentTest test;
	 
	 @BeforeTest
	 public void extentReport() {
		  ExtentHtmlReporter reporter = new ExtentHtmlReporter("C:\\workspace\\orangehrm\\extentreports\\hrm.html");
		  extent = new ExtentReports();
		  extent.attachReporter(reporter);
		  //test = extent.createTest("hrmloginTest");
		 
	 }
	 @AfterTest
	 public void endReport() {
		 extent.flush();
	 }
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
		
	}
	@Test(priority=1)
	public void loginTest() {
		
		test = extent.createTest("loginTest");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String tittle = driver.getTitle();
		System.out.println(tittle);
		Assert.assertEquals(tittle, "OrangeHR");
		
	}
	@Test(priority=2)
	public void homePageTest() {
		test = extent.createTest("homepageTest");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.xpath("//a[contains(@id,'menu_admin_viewAdminModule')]")).click();
		String tittle = driver.getTitle();
		Assert.assertEquals(tittle, "OrangeHRM");
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(ITestResult.FAILURE==result.getStatus()) {
			
			test.log(Status.FAIL, "this is failed test case" + result.getName()); //result.getName()..shows the test case name
			test.log(Status.INFO, "test case info");
						
		}else if(ITestResult.SUCCESS==result.getStatus()) {
			
			test.log(Status.PASS, "this ispassed test case" + result.getName());
			test.log(Status.INFO, "test case info");
			
		}
		driver.quit();
	}
	
	
	
}
