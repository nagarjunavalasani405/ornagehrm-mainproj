package com.hrm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.basepage.BaseClass;
import com.hrm.qa.pages.AdminPage;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;

public class AdminPageTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	AdminPage adminpage;
	
	
	AdminPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		          Initiolization();
		          loginpage = new LoginPage();
	   homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		          homepage = new HomePage();
	  adminpage = homepage.verifyAdminLink();

	}
	@Test(priority=1)
	public void verifyAdminPageTittleTest() {
		String tittle = driver.getTitle();
		Assert.assertEquals(tittle, "OrangeHRM" ,"tittle not matching");
	}
	
	@Test(priority=2)
	public void verifyCheckBoxTest() {
		adminpage.verifyCheckBox();
		

	}
	
	@Test(priority=3)
	  public void verifyDeleteButtonTest() {
		
		boolean deletebtn = adminpage.verifyDeletebtn();
		Assert.assertTrue(deletebtn);
		
	}
	
		
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
