package com.hrm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.qa.basepage.BaseClass;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.pages.PimPage;
import com.hrm.qa.utility.GetTextData;
import com.hrm.qa.utility.Utilities;

public class pimAddEmpolyeeTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	PimPage pimpage;
	Utilities utility;
	
	public pimAddEmpolyeeTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		     Initiolization();
             loginpage = new LoginPage();
  homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
  homepage.verifyPimLink();
             pimpage = new PimPage();
            utility = new Utilities();       
             
	}
	@DataProvider
	public Object[][] getText() {
		
		Object data1[][] =Utilities.getTextData();
		return data1;
		
	}
	
	@Test
	@DataProvider(name="getText")
	public void verifyAddEmployeeTest() {
		
		homepage.addEmployee();
		pimpage.addEmpolyeePim("nagarjuna","valasani");
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
