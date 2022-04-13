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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;

public class AndroidSample {
    
	
	AndroidDriver driver;
	
		  
	@BeforeClass
	public void startDriver() throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("Capability_Username", "pranith.suvarna@qualitykiosk.com");
		capabilities.setCapability("Capability_ApiKey", "p5z36vsw6wwwfbfk7xpqnh3r");
		capabilities.setCapability("Capability_DurationInMinutes", 10);
		capabilities.setCapability("newCommandTimeout", 600);
		capabilities.setCapability("launchTimeout", 90000);
//		capabilities.setCapability("Capability_DeviceFullName", "SAMSUNG_GalaxyA50_Android_11.0.0_8efc9");
		capabilities.setCapability("Capability_DeviceFullName", "VIVO_Y71_Android_8.1.0_67d63");
		capabilities.setCapability("platformVersion", "8.1.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("Capability_ApplicationName", "com-bitmart-bitmarket.apk");
		capabilities.setCapability("appPackage", "com.bitmart.bitmarket");
		capabilities.setCapability("appActivity", "com.uniex.bitmarket.biz.SplashActivity");
		capabilities.setCapability("Capability_WildNet", "false");
		capabilities.setCapability("Capability_EnableVideo", "true");
		capabilities.setCapability("Capability_EnablePerformanceData", "true");
		capabilities.setCapability("Capability_EnableDeviceLogs", "true");
		capabilities.setCapability("appiumVersion", "1.20.2");
		driver = new AndroidDriver<WebElement>(new URL("https://qkm1.qualitykiosk.com/appiumcloud/wd/hub"), capabilities);
	
	
	/*	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("Capability_Username", "pranith.suvarna@qualitykiosk.com");
		capabilities.setCapability("Capability_ApiKey", "3wq7qph62473cbmyf4yw5y74");
		capabilities.setCapability("Capability_DurationInMinutes", 10);
		capabilities.setCapability("newCommandTimeout", 600);
		capabilities.setCapability("launchTimeout", 90000);
		capabilities.setCapability("Capability_DeviceFullName", "SAMSUNG_GalaxyS10_Android_11.0.0_a5111");
		capabilities.setCapability("platformVersion", "11.0.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("Capability_ApplicationName", "cricbuzz.apk");
		capabilities.setCapability("appPackage", "com.cricbuzz.android.vernacular");
		capabilities.setCapability("appActivity", "com.cricbuzz.android.ALGNSplashScreen");
		capabilities.setCapability("Capability_WildNet", "false");
		capabilities.setCapability("Capability_EnableVideo", "true");
		capabilities.setCapability("Capability_EnablePerformanceData", "true");
		capabilities.setCapability("Capability_EnableDeviceLogs", "true");
		capabilities.setCapability("appiumVersion", "1.20.2");
		driver = new AndroidDriver<WebElement>(new URL("https://qkm1vil.qualitykiosk.com/appiumcloud/wd/hub"), capabilities);
		
	*/
	
	}
	
	@Test
	public void test_01() throws InterruptedException {

		  
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 60L)).until((Function)ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'permission_deny_button')]")))).isDisplayed();
	    driver.findElementByXPath("//*[contains(@resource-id,'permission_deny_button')]").click();
	    driver.findElementByXPath("//*[contains(@resource-id,'permission_deny_button')]").click();
	    Thread.sleep(4000);
	    if (driver.findElements(By.id("com.bitmart.bitmarket:id/update_later")).size() > 0) {
	  		if ( driver.findElementById("com.bitmart.bitmarket:id/update_later").isDisplayed()) {
	  				      driver.findElementById("com.bitmart.bitmarket:id/update_later").click();
	  				}
	  			}
        Thread.sleep(1000);
        if (driver.findElements(By.id("com.bitmart.bitmarket:id/alert_image_close")).size() > 0) {
	  		if ( driver.findElementById("com.bitmart.bitmarket:id/alert_image_close").isDisplayed()) {
	  				      driver.findElementById("com.bitmart.bitmarket:id/alert_image_close").click();
	  		}
        }
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 30L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Buy Crypto']")))).isDisplayed();
	
	}
    
	@Test
	public void test_02() throws InterruptedException {
       driver.findElementById("com.bitmart.bitmarket:id/main_tab_market").click();
       driver.findElementById("com.bitmart.bitmarket:id/main_tab_trade").click();
       driver.findElementById("com.bitmart.bitmarket:id/main_tab_home").click();
	}
	
	@Test
	public void test_03() throws InterruptedException {
        driver.findElementById("com.bitmart.bitmarket:id/home_drawer_toggle").click();
	    driver.findElementByXPath("//*[@text='Login/Sign up']").click();
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 30L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='LOGIN']")))).isDisplayed();
	}
	
    @AfterClass
	public void quitDriver() {
		
     driver.quit();
	}
	
	
	
}
