package com.hrm.qa.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.qa.utility.Utilities;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() {
		
		try {
			
	    prop = new Properties();
			
		FileInputStream fis = new FileInputStream("C:\\workspace\\orangehrm\\src\\main\\java\\com\\hrm\\qa\\config\\config.properties");
			
		prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void Initiolization() {
		
		String browsernmae = prop.getProperty("browser");
		
		if(browsernmae.equals("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    }
		else if(browsernmae.equals("FF")){
			System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\geckhodriver.exe");
		    driver = new ChromeDriver();
		}
	    
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    // instead of hard coded of 30 or 20 seconds..we use utilities class
	    driver.manage().timeouts().pageLoadTimeout(Utilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(Utilities.IMPLICT_WAIT, TimeUnit.SECONDS);
	    
	    driver.get(prop.getProperty("url"));
	    
	 
	    
	}

	
	

}
