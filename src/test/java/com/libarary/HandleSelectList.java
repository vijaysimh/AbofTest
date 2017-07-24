package com.libarary;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kirwa.nxgreport.NXGReports;

import io.appium.java_client.android.AndroidDriver;

public class HandleSelectList {
	
	public DesiredCapabilities Capabilities;
	public static  String sDirpath=System.getProperty("user.dir");
	public String apkfilepath=sDirpath+"\\ApkFile\\Channels_com.kirusa.ivchannels.apk";
			
	public static  AndroidDriver driver;
	
	
	@BeforeMethod
	public void setup(){
		
		try{
		
		Capabilities=new DesiredCapabilities();
		
		Capabilities.setCapability("automationName",GenericClass.getdataproperties("AUTOMATIONNAME"));
		Capabilities.setCapability("platformName",GenericClass.getdataproperties("PLTFORMNAME"));
		Capabilities.setCapability("deviceName",GenericClass.getdataproperties("DEVICENAME"));
		Capabilities.setCapability("platformVersion",GenericClass.getdataproperties("PLTFORMVESION"));
		Capabilities.setCapability("app",apkfilepath );
		//Capabilities.setCapability("appPackage",GenericClass.getdataproperties("AppPackage")); 
		//Capabilities.setCapability("appActivity",GenericClass.getdataproperties("AppActivity"));

		driver=new AndroidDriver(new URL(GenericClass.getdataproperties("APPIUMSERVERURL")), Capabilities);
		NXGReports.setWebDriver(driver);
		}catch(Exception e){
		e.printStackTrace();
	}
		
		
	}
	
	
	public void select(String countryname)
	{
		System.out.println(GenericClass.getdataproperties("COUNTRYNAME"));
		driver.findElement(By.xpath("//android.widget.ListView//android.widget.LinearLayout//android.widget.TextView[@text='"+countryname+"']")).click();
		
	}
	
	@Test
	public void handle() throws InterruptedException{
		Thread.sleep(4000);
		
		driver.findElement(By.id("com.kirusa.ivchannels:id/iv_dropdown")).click();
		Thread.sleep(4000);
		select(GenericClass.getdataproperties("COUNTRYNAME"));
		//driver.findElement(By.xpath("//android.widget.ListView//android.widget.LinearLayout//android.widget.TextView[@text='Afghanistan']")).click();
		Thread.sleep(4000);
		
		
	}
	
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}


}
