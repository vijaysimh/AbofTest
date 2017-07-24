package com.defaulttestng;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testng {
	
	
	@BeforeSuite
	public void samplesuite(){
		System.out.println("samplesuite");
	}
	
	
	@BeforeTest
	public void launchserver(){
		System.out.println("appium server is launched");
	}
	
	
	@BeforeClass
	public void sampleclass(){
		System.out.println("sample class is exceuted");
	}
	
	
	@BeforeMethod
	public void launchabofapplication(){
		System.out.println("Launch the abof application");
	}
	
	@Test(priority=1)
	public void sampletest(){
		
		System.out.println("Login to the ABOF APPLICATION");
	}
	
	@Test(priority=2)
	public void verifyhome(){
		System.out.println("verify the homepage");
		
	}

	@Test(priority=3)
	public void logout(){
		System.out.println("Logout to the abof application");
	}
}
