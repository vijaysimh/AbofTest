package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class HomePage {
	
	AndroidDriver driver;
	
	
	public HomePage(AndroidDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="MEN")
	public WebElement AbofMenTab;
	
	@FindBy(id="com.abof.android:id/img")
	public List<WebElement> abofNewInOption;
	
	
	@FindBy(name="Clothing")
	public WebElement abofClothingIcon;

}
