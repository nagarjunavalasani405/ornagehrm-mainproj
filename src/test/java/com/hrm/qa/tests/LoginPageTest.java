package com.hrm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.basepage.BaseClass;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.pages.HomePage;

public class LoginPageTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest(){
		
		super();
	}
	
	@BeforeMethod
	
	public void setup() {
		
		Initiolization();
	    loginpage = new LoginPage();
	}
	
	@Test
	
	public void validateTittleTest() {
		
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	@Test
	
	public void validateLogoTest() {
		
		boolean logo = loginpage.validateLogoImg();
		Assert.assertTrue(logo);
		
	}
	
	@Test
	public void validatefooterLinkTest() {
		boolean futerlinks = loginpage.validateFooterLinks();
		Assert.assertTrue(futerlinks);
	}
	
	@Test
	public void liginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
		
	}

}
