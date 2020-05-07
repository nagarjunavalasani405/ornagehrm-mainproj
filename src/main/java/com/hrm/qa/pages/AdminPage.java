package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.basepage.BaseClass;

public class AdminPage extends BaseClass {
	
	@FindBy(xpath="//a[text()='Test_123']//parent::td[contains(@class,'left')]//preceding-sibling::td//input[@name='chkSelectRow[]']")
	WebElement checkbox;
	
	@FindBy(xpath="//input[contains(@id,'btnDelete')]")
	WebElement deletebtn;
	
	public AdminPage(){
		PageFactory.initElements(driver, this);
		
	}
	// 
	public void verifyCheckBox() {
		
		checkbox.click();
	}
	
	public boolean verifyDeletebtn() {
		return deletebtn.isEnabled();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
