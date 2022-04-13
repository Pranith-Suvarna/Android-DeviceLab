package com.qkm1.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Msite {
	
	AndroidDriver driver;

	public void switchToWeb() {
	    Set<String> str = driver.getContextHandles();
	    for (String newsrt : str) {
	      if (newsrt.contains("CHROMIUM"))
	        driver.context(newsrt); 
	    } 
	  }
	  
	  public void switchToNative() {
	    Set<String> allContext = driver.getContextHandles();
	    for (String context : allContext) {
	      if (context.contains("NATIVE"))
	        driver.context(context); 
	    } 
	  }
	  
	@BeforeClass  
	public void startDriver() throws MalformedURLException {
		
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("Capability_Username", "pranith.suvarna@qualitykiosk.com");
	capabilities.setCapability("Capability_ApiKey", "2zz9g8kp8k8jqpt9jtvkgvdb");
	capabilities.setCapability("Capability_DurationInMinutes", 10);
	capabilities.setCapability("newCommandTimeout", 600);
	capabilities.setCapability("launchTimeout", 90000);
	capabilities.setCapability("Capability_DeviceFullName", "SAMSUNG_GalaxyM02_Android_10.0.0_1dad4");
	capabilities.setCapability("platformVersion", "10.0.0");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("automationName", "uiautomator2");
	capabilities.setBrowserName("Chrome");
	capabilities.setCapability("Capability_WildNet", "false");
	capabilities.setCapability("Capability_EnableVideo", "true");
	capabilities.setCapability("Capability_EnablePerformanceData", "true");
	capabilities.setCapability("Capability_EnableDeviceLogs", "true");
	capabilities.setCapability("appiumVersion", "1.20.2");
    driver = new AndroidDriver<WebElement>(new URL("https://qkm1.qualitykiosk.com/appiumcloud/wd/hub"), capabilities);
	
    	/*DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("Capability_Username", "pranith.suvarna@qualitykiosk.com");
		capabilities.setCapability("Capability_ApiKey", "svnky95w6kc2svrjgdvbm5d9");
		capabilities.setCapability("Capability_DurationInMinutes", 10);
		capabilities.setCapability("newCommandTimeout", 600);
		capabilities.setCapability("launchTimeout", 90000);
		capabilities.setCapability("Capability_DeviceFullName", "SAMSUNG_GalaxyNote8_Android_9.0.0_3e4e3");
		capabilities.setCapability("platformVersion", "9.0.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setBrowserName("Chrome");
		capabilities.setCapability("Capability_WildNet", "false");
		capabilities.setCapability("Capability_EnableVideo", "true");
		capabilities.setCapability("Capability_EnablePerformanceData", "true");
		capabilities.setCapability("Capability_EnableDeviceLogs", "true");
		capabilities.setCapability("appiumVersion", "1.20.2");
		driver = new AndroidDriver<WebElement>(new URL("https://qkm1.qualitykiosk.com/appiumcloud/wd/hub"), capabilities);*/
    
	} 
	  
	@Test
	public void test_01() {
		
		driver.get("https://www.amazon.com");
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 60L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='nav-logo']")))).isDisplayed();
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 30L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='Search Amazon']")))).click();
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 30L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='Search Amazon']")))).sendKeys("pendrive");
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 30L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='issDiv0']//child::div")))).click();
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 60L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='RESULTS']")))).isDisplayed();
	   
	}  
	
	 @AfterClass
		public void quitDriver() {
			
	     driver.quit();
		}
		
	  
}
