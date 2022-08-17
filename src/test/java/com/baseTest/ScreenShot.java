package com.baseTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	public static String getScreenshot(String fileName, WebDriver driver) {
		TakesScreenshot ts =(TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\ScreenShots\\" + fileName + ".png";
		//System.out.println(path);
		File destination = new File(path);
		try {
			//FileHandler.copy(source, destination);
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
	}

}
