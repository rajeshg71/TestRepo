package com.axis.qa.testcases;

import com.axis.qa.pages.HomePage;

public class HomePageTest {
	HomePage homepage;
	
	public void homePageTest() {
		homepage.mouseHover();
		homepage.editBtn();
		homepage.textEntry();
	}
}
