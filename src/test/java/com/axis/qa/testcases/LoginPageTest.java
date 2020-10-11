package com.axis.qa.testcases;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.axis.qa.base.TestBase;
import com.axis.qa.pages.HomePage;
import com.axis.qa.pages.LoginPage;
public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	//@BeforeTest
	public void setUp() {
		initialization();
		loginPage = new LoginPage();		
	}
	
	//@Test(priority=1)
	public void loginpagetitletest() {
		String title = loginPage.validateLoginPageTitle();
		System.out.println(title);
	}
	//@Test(priority=2)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
//	@Test(priority=3)
//	public void homePageTest() {
//		homePage.mouseHover();
//		homePage.editBtn();
//		homePage.textEntry();
//	}
	
	//@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
}
