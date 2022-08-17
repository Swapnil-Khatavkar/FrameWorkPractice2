package com.baseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LandingPage;

public class LogoTest extends BaseTest{
	
	@Test
	public void verifyLogo() {
		LandingPage lp=new LandingPage(driver); 
		Assert.assertTrue(lp.loginLogo().isDisplayed());
	}
	

}
