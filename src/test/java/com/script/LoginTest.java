package com.script;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.libarary.BaseClass;
import com.libarary.GenericClass;
import com.pages.LoginPage;

public class LoginTest extends BaseClass {
	public String[] Sdata=null;
	
	
/*	@Test(dataProvider="getdata",description="Login to abof application")
	public void LogintoAbofApplication(String username,String password) throws Exception{
		
		LoginPage login=new LoginPage(driver);
		try{
			Thread.sleep(4000);	
			Assert.assertTrue(login.AbofUserNameTextBox.isDisplayed(),"The AbofUsername textbox is not displayed");
			NXGReports.addStep("the abofusername textbox is displayed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			login.AbofUserNameTextBox.sendKeys(username);
			handlekeyboad();
			Thread.sleep(4000);
			Assert.assertTrue(login.AbofPasswordTextBox.isDisplayed(),"The Abofpassword textbox is not displayed");
			NXGReports.addStep("the abofpassword textbox is displayed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			login.AbofPasswordTextBox.sendKeys(password);
			handlekeyboad();
			Thread.sleep(4000);
			NXGReports.addStep("the abofSignButton is displayed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			login.AbofSignButton.click();
			
		}catch(Exception e){
			throw e;
		}
		
		*/
		
		
	/*}
	
	
	@DataProvider
	public Object[][] getdata() throws Exception{
		
				Object[][] data=new Object[3][2];
				
				
				data[0][0]="abofqa.raghucbt@gmail.com";
				data[0][1]="raghukiran92";
				
				data[1][0]="cbtcrowd001@gmaul.com";
				data[1][1]="crowd@123";
				
				data[2][0]="cbtcrowd002@gmail.com";
				data[2][1]="crowd@123";
			
		
		return data;
		
	}
*/
	
	@Test(priority=1,enabled=true,description="Login to the abof application")
	public void abofLoginApplication() throws Exception{
		LoginPage login=new LoginPage(driver);
		try{
			Sdata=GenericClass.getExcelData("Login_01");
			login.AbofUserNameTextBox.sendKeys(Sdata[1]);
			handlekeyboad();
			login.AbofPasswordTextBox.sendKeys(Sdata[2]);
			handlekeyboad();
			login.AbofSignButton.click();
			Thread.sleep(4000);
			
		}catch(Exception e){
			throw e;
			
		}
	}
}
