package com.script;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.libarary.BaseClass;
import com.libarary.GenericClass;
import com.libarary.SauceLab;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.pages.filterpage;

public class FilterTest extends BaseClass {
	
	
	LoginPage loginpage;
	HomePage homepage;
	ProductPage productpage;
	filterpage filterpag;
	
	
	/*@BeforeClass
	public void createObject(){
		
		
		
	}
	
	*/
	@Test(priority=1,enabled=true,description="Login to aBOF APPLICATION AND handle radio button")
	public void handleRadioButton() throws Exception{
		
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		productpage=new ProductPage(driver);
		filterpag=new filterpage(driver);
		try{
			
			Thread.sleep(5000);
			NXGReports.addStep("The close icon is displayed", LogAs.PASSED, null);
			loginpage.AbofCloseIcon.click();
			Thread.sleep(5000);
			homepage.AbofMenTab.click();
			Thread.sleep(5000);
			homepage.abofNewInOption.get(1).click();
			Thread.sleep(5000);
			
			homepage.abofClothingIcon.click();
			
			Thread.sleep(5000);
			for(int i=0;i<=5;i++){
			GenericClass.scroll(.90,.10);
		}
			//productpage.abofFilterIcon.click();
			Thread.sleep(5000);
			//filterpag.handleradiobutton();
			//Thread.sleep(5000);
			
			
		}catch(Exception e){
			throw e;
		}
		
		Thread.sleep(5000);
		
		
	}

}
