package com.script;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kirwa.nxgreport.NXGReports;
import com.libarary.GenericClass;

import io.appium.java_client.android.AndroidDriver;

public class SwtichBtwApplication {
	
	public DesiredCapabilities Capabilities;
	public static  String sDirpath=System.getProperty("user.dir");
	public String apkfilepath=sDirpath+"\\ApkFile\\abof_com.abof.android.apk";
			
	public static  AndroidDriver driver;
	
	@BeforeMethod
	public void setup() throws MalformedURLException{
		Capabilities=new DesiredCapabilities();
		
		Capabilities.setCapability("automationName",GenericClass.getdataproperties("AUTOMATIONNAME"));
		Capabilities.setCapability("platformName",GenericClass.getdataproperties("PLTFORMNAME"));
		Capabilities.setCapability("deviceName",GenericClass.getdataproperties("DEVICENAME"));
		Capabilities.setCapability("platformVersion",GenericClass.getdataproperties("PLTFORMVESION"));
		Capabilities.setCapability("app",apkfilepath );
		Capabilities.setCapability("appPackage",GenericClass.getdataproperties("AppPackage")); 
		Capabilities.setCapability("appActivity",GenericClass.getdataproperties("AppActivity"));

		driver=new AndroidDriver(new URL(GenericClass.getdataproperties("APPIUMSERVERURL")), Capabilities);
		NXGReports.setWebDriver(driver);
	}
	
	@Test
	public void sampleTest() throws InterruptedException{
		Thread.sleep(4000);
		driver.startActivity(GenericClass.getdataproperties("CalAppPackage"), GenericClass.getdataproperties("CalAppActivity"));
		Thread.sleep(4000);
	
	}
	

}
