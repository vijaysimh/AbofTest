package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class ProductPage {
	
AndroidDriver driver;
	
	public ProductPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="com.abof.android:id/img_filter")
	public WebElement abofFilterIcon;
	
	@FindBy(id="com.abof.android:id/prduct_name")
	public List<WebElement> abofProductName;
	
	@FindBy(id="com.abof.android:id/imgview")
	public WebElement abofImageIcon;
	
	@FindBy(id="com.abof.android:id/fave_img_view")
	public WebElement abofFavIcon;

}
