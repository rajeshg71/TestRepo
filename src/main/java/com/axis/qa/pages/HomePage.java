package com.axis.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.axis.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[text()='Admin']")
	WebElement eleLoc;
	
	@FindBy(xpath="//span[text()='Company Info']")
	WebElement ele1Loc;
	
	@FindBy(xpath="//span[text()='Locations']")
	WebElement ele2Loc;
	
	@FindBy(xpath="//div[@class='actionbuttons']/input[1]")
	WebElement editBtn;
	
	@FindBy(id="txtLocDescription")
	WebElement locDesc;
	
	@FindBy(xpath="//select[@name='cmbCountry']")
	WebElement el;
	
	@FindBy(name="txtAddress")
	WebElement txtAddress;
	
	@FindBy(name="txtZIP")
	WebElement txtZIP;
	
	@FindBy(xpath="//input[@class='savebutton']")
	WebElement saveBtn;
	
	public void mouseHover() {
		Actions action = new Actions(driver);
		action.moveToElement(eleLoc).perform();
		action.moveToElement(ele1Loc).perform();
		action.moveToElement(ele2Loc).click().build().perform();
	}
	public void editBtn() {
		driver.switchTo().frame("rightMenu");
		editBtn.click();
		driver.switchTo().defaultContent();
	}
	public void textEntry() {
		driver.switchTo().frame("rightMenu");
		locDesc.sendKeys("Vikram Technologies");
		Select sele = new Select(el);
		List<WebElement> l = sele.getOptions();
		int options =l.size();
		System.out.println(options);
		for(int i=0;i<options;i++) {
		  String value = sele.getOptions().get(i).getText();
		  //System.out.println(value);
		  	if(value.equals("India")) {
		  	l.get(i).click();
		  	}
		}
		
		txtAddress.sendKeys("This is the world largest company");
		txtZIP.sendKeys("505501");
		saveBtn.click();
		System.out.println("Saving the file completed");
		driver.switchTo().defaultContent();
		
	}
	

}
