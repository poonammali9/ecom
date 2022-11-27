package com.ecom.utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecom.base.BaseClass;

public class Utility extends BaseClass {
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public static void applyImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
	}
	
	public static void applyExplicitWait(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
	}
	public static void takeScreenShot(String name) throws IOException{
		File  screenshotsrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = projectPath+"//screenshots//"+name+".jpeg";
		FileUtils.copyFile(screenshotsrc,new File(destination));
		
	}

}
