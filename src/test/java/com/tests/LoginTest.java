package com.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.baseTest.BaseTest;
import com.pages.HomePage;
import com.pages.LandingPage;

public class LoginTest extends BaseTest {
	
	
	@Test(dataProvider="getLoginData")
	void login(String username, String password) {

		LandingPage landingPage = new LandingPage(super.driver);
		landingPage.userName().sendKeys(username);
		log.info("Entered Username = " + username);
		landingPage.password().sendKeys(password);
		log.info("Entered password = " + password);
		landingPage.loginButton().click();
		log.info("Clicked on Login Button");
		
		HomePage homePage = new HomePage(super.driver);
		try {
			Assert.assertTrue(homePage.menuButton().isDisplayed());
		} catch(Exception e) {
			log.error("-----------------Login Unsuccessful-----------------------");
			Assert.fail();
		}
	}
	
	@DataProvider
	Object[][] getLoginData() {
		Object[][] data = {
				{"standard_user","secret_sauce"},
				{"locked_out_user","secret_sauce"},
				{"problem_user","secret_sauce"},
				{"performance_glitch_user","secret_sauce"}
		};
		return data;
	}
	

}
