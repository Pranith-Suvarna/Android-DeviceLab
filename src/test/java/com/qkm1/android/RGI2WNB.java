package com.qkm1.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import static java.time.Duration.ofMillis;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class RGI2WNB {
	
	AndroidDriver driver;
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		
		return customFormat.format(currentDate);
	}
	
	public static String captureScreenshot(AndroidDriver driver)
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/"+ getCurrentDateTime() + ".png";
		try {
			FileHandler.copy(src, new File(screenshotPath ));
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot"+e.getMessage());
		}
		
		return screenshotPath;
	}
	
	
	@BeforeClass
	public void startDriver() throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("Capability_Username", "pranith.suvarna@qualitykiosk.com");
		capabilities.setCapability("Capability_ApiKey", "2zz9g8kp8k8jqpt9jtvkgvdb");
		capabilities.setCapability("Capability_DurationInMinutes", 10);
		capabilities.setCapability("newCommandTimeout", 600);
		capabilities.setCapability("launchTimeout", 90000);
		capabilities.setCapability("Capability_DeviceFullName", "SAMSUNG_GalaxyA50_Android_11.0.0_8efc9");
		//capabilities.setCapability("Capability_DeviceFullName", "SAMSUNG_GalaxyM02_Android_10.0.0_1dad4");
		capabilities.setCapability("platformVersion", "11.0.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "uiautomator2");
	    //capabilities.setCapability("Capability_ApplicationName", "app-debug.apk");
		capabilities.setCapability("appPackage", "com.rgi.customerapp.live");
	    capabilities.setCapability("appActivity", "com.customerapp.rgi.live.slider.WelcomeActivity");
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("Capability_WildNet", "false");
		capabilities.setCapability("Capability_EnableVideo", "true");
		capabilities.setCapability("Capability_EnablePerformanceData", "true");
		capabilities.setCapability("Capability_EnableDeviceLogs", "true");
		capabilities.setCapability("appiumVersion", "1.20.2");
		driver = new AndroidDriver<WebElement>(new URL("https://qkm1.qualitykiosk.com/appiumcloud/wd/hub"), capabilities);

	}
	
	@Ignore
	public void test_01() throws InterruptedException {

		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement Skip= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Skip']")));
		Skip.isDisplayed();
		Skip.click();
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//*[contains(@resource-id,'permission_allow_button')]")).click();
	    driver.findElement(By.xpath("//*[contains(@resource-id,'permission_allow_button')]")).click();
	 	driver.findElement(By.xpath("//*[@text='Connect with Mobile Number']")).sendKeys("9136011635");
		driver.findElement(By.xpath("//*[@text='Generate OTP']")).click();
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 20L)).until((Function)ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text,'Please enter the One Time Password')]")))).isDisplayed();
	    Thread.sleep(20000);
	    driver.openNotifications();
	    String otp = driver.findElementByXPath("//*[contains(@text,'<#>Your Reliance General Insurance - Self-i App registration OTP is:')]").getText().split(" is:")[1].substring(0,5);
	    System.out.println("OTP is "+  otp);
	    driver.navigate().back();
	    String otp1 = String.valueOf(otp.charAt(0));
	    System.out.println("OTP1 is "+  otp1);
	    String otp2 = String.valueOf(otp.charAt(1));
	    System.out.println("OTP2 is "+  otp2);
	    String otp3 = String.valueOf(otp.charAt(2));
	    System.out.println("OTP3 is "+  otp3);
	    String otp4 = String.valueOf(otp.charAt(3));
	    System.out.println("OTP4 is "+  otp4);
	    String otp5 = String.valueOf(otp.charAt(4)); 
	    System.out.println("OTP5 is "+  otp5);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//*[contains(@resource-id,'edtOTP')]")).sendKeys(otp1);
	    driver.findElement(By.xpath("//*[contains(@resource-id,'edtOTP2')]")).sendKeys(otp2);
	    driver.findElement(By.xpath("//*[contains(@resource-id,'edtOTP3')]")).sendKeys(otp3);
	    driver.findElement(By.xpath("//*[contains(@resource-id,'edtOTP4')]")).sendKeys(otp4);
	    driver.findElement(By.xpath("//*[contains(@resource-id,'edtOTP5')]")).sendKeys(otp5);
		driver.findElement(By.xpath("//*[@text='Confirm']")).click();
		WebDriverWait wait1=new WebDriverWait(driver, 30);
		WebElement Help= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'help')]")));
		Help.isDisplayed();
		Help.click();		
	}
	
	@Test
	public void test_02() throws InterruptedException {
		
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   //new TouchAction(driver).tap(point(940,648)).waitAction(waitOptions(ofMillis(500))).perform();
   //System.out.println("tapped cross icon");
		if (driver.findElements(By.id("com.rgi.customerapp.live:id/btnClose")).size() > 0) {
		  		if (driver.findElementById("com.rgi.customerapp.live:id/btnClose").isDisplayed()) {
		  				      driver.findElementById("com.rgi.customerapp.live:id/btnClose").click();
		  					  System.out.println("tried to click cross icon again");
		  		}
	     }
	 driver.findElement(By.xpath("//*[contains(@resource-id,'buyNewPolicy_txt')]")).click();
     driver.findElement(By.xpath("//*[@text='Two-wheeler Insurance']")).click();
     driver.findElement(By.xpath("//*[@text='Your Two-Wheeler Reg. Number']")).sendKeys("MH02AS1000");
     driver.findElement(By.xpath("//*[@text='Get Quote']")).click();
	 Thread.sleep(6000);
     driver.findElement(By.xpath("//*[@text='Honda Activa 3g 110 Cc']")).click();
	 driver.findElement(By.xpath("//*[@text='City where Two-wheeler is Registered']")).sendKeys("maharashtra mumbai western");
	 Thread.sleep(2000);
     driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[3]")).click();
	 Thread.sleep(2000);
     driver.findElement(By.xpath("//*[@text='Select Two-Wheeler Age']")).click();
     driver.findElement(By.xpath("//*[@text='1 Year']")).click();
     driver.findElement(By.xpath("//*[@text='Get Quote']")).click();
		
	}
	
	@Test
	public void test_03() throws InterruptedException {
		
     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//*[@text='1 year plan']")).click();
	 driver.findElement(By.xpath("//*[contains(@resource-id,'dob_edt')]")).click();
	 driver.findElement(By.xpath("//*[@text='15']")).click();
	 driver.findElement(By.xpath("//*[@text='OK']")).click();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//*[contains(@resource-id,'edt_reg_date')]")).click();
	 driver.findElement(By.xpath("//*[contains(@resource-id,'date_picker_header_year')]")).click();
	 driver.findElement(By.xpath("//*[@text='2020']")).click();
	 driver.findElement(By.xpath("//*[@text='16']")).click();
	 driver.findElement(By.xpath("//*[@text='OK']")).click();
	 driver.findElement(By.xpath("//*[@text='What was the duration of your last policy?']")).click();
	 driver.findElement(By.xpath("//*[@text='1 year']")).click();
	 driver.findElement(By.xpath("//*[@text='Did you make any claim last year?']")).click();
	 driver.findElement(By.xpath("//*[@text='Yes']")).click();
	 driver.findElement(By.xpath("//*[@text='Yes, made 1 claim']")).click();
	 new TouchAction(driver).press(point(540,2007)).waitAction(waitOptions(ofMillis(5000))).moveTo(point(534, 888)).release().perform();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//*[@text='What is your current No Claim Bonus?']")).click();
	 driver.findElement(By.xpath("//*[@text='0%']")).click();
	 driver.findElement(By.xpath("//*[@text='Continue']")).click();
     System.out.println("clicked Continue");

	}
	
	@Test
	public void test_04() throws InterruptedException {
		
     driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//*[@text='Voluntary deductible']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//*[contains(@text,'500')]")).click();
	 driver.findElement(By.xpath("//*[@text='Add']")).click();
     driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//*[@text='Automobile association member']")).click();
	 driver.findElement(By.xpath("//*[@text='Association name']")).sendKeys("Sal");
	 driver.findElement(By.xpath("//*[@text='Membership number']")).sendKeys("7894561230");
	 driver.findElement(By.xpath("//*[@text='Add']")).click();
     driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//*[contains(@resource-id,'tv_yes_driving')]")).click();
     driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//*[contains(@resource-id,'tv_yes_pa')]")).click();
	 System.out.println("clicked yes for personal accident");
     driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//*[contains(@resource-id,'BUY_NOW')]")).click();
	// new TouchAction(driver).tap(point(816,2134)).waitAction(waitOptions(ofMillis(500))).perform(); 
	 System.out.println("tapped LET'S BUY button");
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//*[contains(@resource-id,'icon_Ndc_plus')]")).click();
     driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//*[@text='Next']")).click();

	 
	}
	
	@Test
	public void test_05() throws InterruptedException {
		
     driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//*[contains(@resource-id,'ed_regNum')]")).sendKeys("MH-02-AS-1000");
	 driver.findElement(By.xpath("//*[contains(@resource-id,'ed_egineNo')]")).sendKeys("enginenumber123");
	 driver.findElement(By.xpath("//*[contains(@resource-id,'ed_chasis_no')]")).sendKeys("chassisnumber123");
	 driver.findElement(By.xpath("//*[contains(@resource-id,'img_left_reg')]")).click();
	 driver.findElement(By.xpath("//*[@text='16']")).click();
	 driver.findElement(By.xpath("//*[@text='OK']")).click();
     driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//*[contains(@resource-id,'img_left_manu')]")).click();
	 driver.findElement(By.xpath("//*[@text='16']")).click();
	 driver.findElement(By.xpath("//*[@text='OK']")).click();
	 driver.findElement(By.xpath("//*[contains(@resource-id,'img_down_fuel')]")).click();
	 driver.findElement(By.xpath("//*[@text='Petrol']")).click();
	// new TouchAction(driver).tap(point(222,1706)).waitAction(waitOptions(ofMillis(500))).perform();
	 driver.findElement(By.xpath("//*[@text='Hypothecation']")).click();
	 new TouchAction(driver).press(point(522,2000)).waitAction(waitOptions(ofMillis(5000))).moveTo(point(522, 776)).release().perform();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//*[contains(@resource-id,'autoFinancerName')]")).sendKeys("Saraswat Co Op Bank Ltd");
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//*[@text='Saraswat Co Op Bank Ltd']")).click();
	 Thread.sleep(2000);
	 driver.hideKeyboard();
	 Thread.sleep(2000);
	// new TouchAction(driver).tap(point(430,1398)).waitAction(waitOptions(ofMillis(500))).perform();
	 driver.findElement(By.xpath("//*[contains(@resource-id,'ed_financeAddress')]")).sendKeys("Malad");
	 driver.findElement(By.xpath("//*[contains(@resource-id,'img_down_insurer')]")).click();
	 driver.findElement(By.xpath("//*[@text='The Oriental Insurance Company Limited']")).click();
	 driver.findElement(By.xpath("//*[contains(@resource-id,'ed_previous_po')]")).sendKeys("100348600");
	 driver.findElement(By.xpath("//*[@text='Continue to Personal Details']")).click();
	 
	}
	
	@Test
	public void test_06() throws InterruptedException {
		
     driver.findElement(By.xpath("//*[@text='Full Name']")).sendKeys("Virat Kohli");
	 driver.findElement(By.xpath("//*[@text='Date of Birth']")).click();
	 System.out.println("clicked on dob field");
	 driver.findElement(By.xpath("//*[contains(@resource-id,'date_picker_header_year')]")).click();
	 System.out.println("clicked on year option");
	 driver.findElement(By.xpath("//*[@text='2020']")).click();
	 System.out.println("clicked on year 2020");
	 driver.findElement(By.xpath("//*[contains(@resource-id,'android:id/prev')]")).click();
	 System.out.println("clicked previous option");
	 driver.findElement(By.xpath("//*[@text='12']")).click();
	 System.out.println("clicked 12");
	 driver.findElement(By.xpath("//*[@text='OK']")).click();
	 driver.findElement(By.xpath("//*[contains(@resource-id,'ed_mdn')]")).click();
	 driver.findElement(By.xpath("//*[contains(@resource-id,'ed_mdn')]")).sendKeys("8520369741");
	 driver.hideKeyboard();
	 Thread.sleep(2000);


	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) 
		{
			RGI2WNB.captureScreenshot(driver);
		}
	}
	
    @AfterClass
	public void quitDriver() {
		
     driver.quit();
	}
	
	

}
