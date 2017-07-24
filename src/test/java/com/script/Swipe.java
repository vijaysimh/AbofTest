package com.script;

import org.testng.annotations.Test;

import com.libarary.BaseClass;
import com.libarary.GenericClass;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.pages.filterpage;

public class Swipe extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	ProductPage productpage;
	filterpage filterpag;
	
	@Test
	public void swipeabofapplication() throws Exception{
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		productpage=new ProductPage(driver);
		filterpag=new filterpage(driver);
		try{
			Thread.sleep(5000);
			loginpage.AbofCloseIcon.click();
			Thread.sleep(5000);
			homepage.AbofMenTab.click();
			Thread.sleep(5000);
			homepage.abofNewInOption.get(1).click();
			Thread.sleep(5000);
			
			homepage.abofClothingIcon.click();
			Thread.sleep(5000);
			productpage.abofProductName.get(0).click();
			Thread.sleep(5000);
			productpage.abofImageIcon.click();
			Thread.sleep(5000);
			GenericClass.swipe(.90, .20);
			Thread.sleep(5000);
			GenericClass.swipe(.20, .90);
			Thread.sleep(5000);
		}catch(Exception e){
			throw e;
		}
	}

}
