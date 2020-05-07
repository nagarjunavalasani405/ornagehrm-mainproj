package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.basepage.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath="//a[contains(@class,'firstLevelMenu')]//parent::li[contains(@class,'current')]")
	WebElement adminlink;
	
	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
	WebElement pimlink;
	
	@FindBy(xpath="//a[@id='menu_leave_viewLeaveModule']")
	WebElement leavelink;
	
	@FindBy(xpath="//div[contains(@class,'head')]//child::h1[text()='Dashboard']")
	WebElement dashboardtext;
	
	@FindBy(xpath="//a[text()='Add Employee']")
	WebElement addemployee;
	
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
		
	}
	public String verifyHomePageTittle() {
		return driver.getTitle();
	}
	
	public boolean verifyHomePageDashboardText() {
		
	 return dashboardtext.isDisplayed();
	 
	}
	
	public AdminPage verifyAdminLink() {
		
		adminlink.click();
		return new AdminPage();
	}
	
	public PimPage verifyPimLink() {
		
		pimlink.click();
		return new PimPage();
	}
	
	public LeavePage verifyLeaveLink() {
		
		leavelink.click();
		return new LeavePage();
	}
	
	public void addEmployee() {
		Actions actoin = new Actions(driver);
		actoin.moveToElement(pimlink).build().perform();
		addemployee.click();
	}
	
}
