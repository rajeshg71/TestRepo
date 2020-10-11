package com.axis.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.axis.qa.util.TestUtil;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	FileInputStream fis = null;
	public TestBase() {
		File file = new File("D:/SelTest/orange/src/main/java/com/axis/qa/config/config.properties"); 
		try {
			prop = new Properties();
			 fis = new FileInputStream(file);
			prop.load(fis);
		}
		catch(FileNotFoundException e) {}
		catch(IOException e) {}
	}
	public static void initialization() {
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\vicky\\Downloads\\chromedriver.exe");
		    driver = new ChromeDriver();	
		}
		else if(browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\vicky\\Downloads\\chromedriver.exe");
		    driver = new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}
