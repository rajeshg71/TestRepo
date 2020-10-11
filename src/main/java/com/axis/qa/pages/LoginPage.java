package com.axis.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.axis.qa.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(name = "txtUserName")
	@CacheLookup
	WebElement userName;
	
	@FindBy(name = "txtPassword")
	WebElement passWord;
	
	@FindBy(name = "Submit")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logout;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage login(String un,String pw) {
		userName.sendKeys(un);
		passWord.sendKeys(pw);
		loginBtn.click();
		logout.click();
		return new HomePage();
	}
	
}
