package com.baseTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.base.Base;

public class BaseTest extends Base {
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());
	@BeforeClass
	public void invokeBrowser(ITestContext context) {
		super.initialiseBrowser();
		log.info("Browser invoked");
		context.setAttribute("WebDriver", super.driver);
		super.driver.manage().window().maximize();
		log.info("Browser Maximized");
	}
	
	@BeforeMethod
	public void launchWebsite() {
		super.driver.get(URL);
		log.info("Navigated to " + URL);
	}
	
	@AfterClass
	public void tearDown() {
		super.driver.close();
		log.info("Browser closed");
	}

}
