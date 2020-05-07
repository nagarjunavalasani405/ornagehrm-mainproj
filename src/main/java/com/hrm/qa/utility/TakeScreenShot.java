package com.hrm.qa.utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TakeScreenShot {
	
	static WebDriver driver;
	@Test

	public static void screenShot() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
	    
	    
	    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	    
	     TakesScreenshot tcr=(TakesScreenshot)driver; // here we doing upcasting with driver reference
	     
	    File source= tcr.getScreenshotAs(OutputType.FILE);
	    
	    File destfile = new File("C:\\workspace\\orangehrm\\ScreenShots\\Orangehrm.png");
	    
	    FileUtils.copyFile(source, destfile);
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}

}
