package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.basepage.BaseClass;

public class LoginPage extends BaseClass {
	
	//pageFactory or object repository
	
	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(name="Submit")
	WebElement loginbtn;
	
	@FindBy(xpath="//img[@src='/webres_5e7b15c4882d04.47780062/themes/default/images/login/logo.png']")
	WebElement hrmlogo;
	
	@FindBy(xpath="//div[@id='social-icons']//child::a[@target='_blank']")
	WebElement footerlinks;
	
	public LoginPage(){
	  PageFactory.initElements(driver, this);
	} 
	
	// actions
	
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean validateLogoImg() {
		
		return hrmlogo.isDisplayed();
		
	}
	
	public HomePage login(String usern, String pwd) {
		username.sendKeys(usern);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
	}
	
	public boolean validateFooterLinks() {
		return footerlinks.isDisplayed();
	}
	
	
}
