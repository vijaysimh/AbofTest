package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class filterpage {
	
AndroidDriver driver;
	
	
	public filterpage(AndroidDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(id="com.abof.android:id/sort_radio_bt")
	public List<WebElement> abofHandleRadiobtn;
	
	
public void handleradiobutton() throws InterruptedException{
		
		int count=abofHandleRadiobtn.size();
		System.out.println(count);
		for(int i=0;i<=count;i++){
			Thread.sleep(4000);
			abofHandleRadiobtn.get(i).click();
		}
		
	}
	

}
