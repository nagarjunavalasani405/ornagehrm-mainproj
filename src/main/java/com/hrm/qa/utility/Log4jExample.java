package com.hrm.qa.utility;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.hrm.qa.basepage.BaseClass;

public class Log4jExample extends BaseClass {
	
	Logger log = LogManager.getLogger(Logs.class.getName());
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
	    log.info("My Info Log");
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
	    log.info("My Info Log");
	    
	}
	
	@Test
	public void login() {
		
	    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		log.info("My Info Log");
		String tittle = driver.getTitle();
		System.out.println(tittle);
		Assert.assertEquals(tittle, "OrangeHRM");
		log.info("My Info Log");
		
		log.debug("My Debug Log");
		log.warn("My Warn Log");
		log.error("My error log");
		log.fatal("My fatal log");
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
