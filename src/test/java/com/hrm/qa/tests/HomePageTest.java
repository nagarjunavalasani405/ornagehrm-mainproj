package com.hrm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.basepage.BaseClass;
import com.hrm.qa.pages.AdminPage;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.pages.PimPage;

public class HomePageTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	AdminPage adminpage;
	PimPage pimpage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		Initiolization();
		loginpage = new LoginPage();
		
	    homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTittletest() {
		String tittle = homepage.verifyHomePageTittle();
		Assert.assertEquals(tittle, "OrangeHRM", "Tittle is not matching");
	}
	
	@Test(priority=2)
	public void verifyHomepageDashboardtTest() {
		
		Assert.assertTrue(homepage.verifyHomePageDashboardText());
		
	}
	@Test(priority=3)
	public void verifyAdminLinkTest() {
		
	    adminpage = homepage.verifyAdminLink();
	}
	@Test(priority=4)
	public void verifyPimLinkTest() {
		
		pimpage = homepage.verifyPimLink();
	} 
	@Test(priority=5)
	public void verifyLeaveLinkTest() {
		homepage.verifyLeaveLink();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
