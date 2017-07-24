package com.libarary;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.kirwa.nxgreport.NXGReports;

import bsh.Capabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	
	public DesiredCapabilities Capabilities;
	public static  String sDirpath=System.getProperty("user.dir");
	public String apkfilepath=sDirpath+"\\ApkFile\\abof_com.abof.android.apk";
			
	public static  AndroidDriver driver;
	public static String node="C:\\Program Files (x86)\\Appium\\node.exe";
	public static String appiumjs="C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js";
	public AppiumDriverLocalService server;
	
/*	@BeforeSuite
	public void startappiumserver(){
		
		server=AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(4723).usingDriverExecutable(new File(node)).withAppiumJS(new File(appiumjs)));
		
		server.start();
	}
	*/
	
	@Parameters({ "port", "deviceName", "platformVersion","udid"})
	@BeforeMethod
	public void setup(String port,String deviceName,String platformVersion,String udid ){
		
		try{
		
		Capabilities=new DesiredCapabilities();
		
		Capabilities.setCapability("automationName",GenericClass.getdataproperties("AUTOMATIONNAME"));
		Capabilities.setCapability("platformName",GenericClass.getdataproperties("PLTFORMNAME"));
		Capabilities.setCapability("deviceName",deviceName);
		Capabilities.setCapability("platformVersion",platformVersion);
		Capabilities.setCapability("app",apkfilepath );
		Capabilities.setCapability("udid",udid);
		Capabilities.setCapability("appPackage",GenericClass.getdataproperties("AppPackage")); 
		Capabilities.setCapability("appActivity",GenericClass.getdataproperties("AppActivity"));

		driver=new AndroidDriver(new URL("http://127.0.0.1:"+port+"/wd/hub"), Capabilities);
		NXGReports.setWebDriver(driver);
		}catch(Exception e){
		e.printStackTrace();
	}
		
		
	}
	
	
	public void handlekeyboad(){
		try{
			driver.hideKeyboard();
			
		}catch(Exception e){
			
		}
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	/*@AfterSuite
	public void stopappiumserver(){
		server.stop();
	}
*/
}
