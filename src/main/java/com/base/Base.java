package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Base {
	
	public WebDriver driver;
	public String URL;
	private String browserName;

	
	public void initialiseBrowser() {
		this.getProperties();
//		if(browserName.equalsIgnoreCase("chrome")) {
//			//System.clearProperty("webdriver.chrome.driver");
//			System.setProperty("webdriver.chrome.driver",
//					"F:\\Tools\\ChromeDownload\\chromedriver_win32\\chromedriver.exe");
//			this.driver = new ChromeDriver();
//		} else if(browserName.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver",
//					"F:\\Tools\\BrowserDrivers\\geckodriver-v0.31.0-win64\\geckodriver.exe");
//			this.driver = new FirefoxDriver();	
//		}else if(browserName.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver",
					"F:\\Tools\\BrowserDrivers\\edgedriver_win32\\msedgedriver.exe");
			this.driver = new EdgeDriver();
//		}
		
	}
	
	
	private void getProperties() {
		Properties prop = new Properties();
		FileInputStream fis;

		try {
			fis = new FileInputStream("./globalVariables/globalData.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.browserName = prop.getProperty("browser");
		this.URL = prop.getProperty("url");
	}
	
	

}
