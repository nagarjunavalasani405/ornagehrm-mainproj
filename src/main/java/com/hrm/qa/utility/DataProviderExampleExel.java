package com.hrm.qa.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExampleExel {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
	    
	}
	@DataProvider(name="dataProvider")
	public Object[][] dataProvider() {
		
		Object data[][] = Utilities.getTextData();
		return data;
	}
	
	@Test(dataProvider="dataProvider")
	//@DataProvider(name="dataProvider")
	public void loginTest(String username,String password) {
		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	

}
