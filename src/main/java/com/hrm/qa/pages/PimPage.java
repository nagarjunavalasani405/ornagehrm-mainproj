package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.basepage.BaseClass;

public class PimPage extends BaseClass {
	
	@FindBy(id="firstName")
	WebElement fistname;
	
	@FindBy(id="lastName")
	WebElement lastname;
	
	@FindBy(id="btnSave")
	WebElement savebtn;
	
	public PimPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void addEmpolyeePim(String ftname,String ltname) {
		
		fistname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		savebtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
