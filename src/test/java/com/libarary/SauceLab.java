package com.libarary;

import java.net.MalformedURLException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import java.net.URL;

public class SauceLab {
	
	 public  final String USERNAME = "onlineappium123";
	  public  final String ACCESS_KEY = "0786a147-f897-4ba3-ba96-43c2628146a7";
	  public  final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	 public AndroidDriver driver;
	
	
	@BeforeMethod
	public void setup() throws MalformedURLException{
		
		 
		    DesiredCapabilities capabilities = new DesiredCapabilities();
		    capabilities.setCapability("automationName", "Appium");
		    capabilities.setCapability("platformName", "Android");
		    capabilities.setCapability("deviceName", "Android Emulator");
		    capabilities.setCapability("platformVersion", "4.4");
		    capabilities.setCapability("app", "sauce-storage:abof_com.abof.android.apk");
		  
		    capabilities.setCapability("deviceOrientation", "portrait");
		    capabilities.setCapability("appiumVersion", "1.5.3");
		    capabilities.setCapability("name","Abof exceution test script");
		    driver=new AndroidDriver(new URL(URL), capabilities);
		 
		
	}
	
	
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}


}
