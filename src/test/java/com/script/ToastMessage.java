package com.script;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.libarary.BaseClass;
import com.libarary.GenericClass;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;

public class ToastMessage extends BaseClass {
	
	public String[] Sdata=null;
	
	@Test(priority=1,enabled=true,description="Login to abof application and verify the tOAST MEESAGE")
	public void verifYToastMessage() throws Exception{
		LoginPage login=new LoginPage(driver);
		HomePage home=new HomePage(driver);
		ProductPage product=new ProductPage(driver);
		try{
			Sdata=GenericClass.getExcelData("Login_01");
			login.AbofUserNameTextBox.sendKeys(Sdata[1]);
			handlekeyboad();
			Thread.sleep(4000);

			login.AbofPasswordTextBox.sendKeys(Sdata[2]);
			handlekeyboad();
			Thread.sleep(4000);

			login.AbofSignButton.click();
			Thread.sleep(4000);
			home.AbofMenTab.click();
			Thread.sleep(4000);
			home.abofNewInOption.get(1).click();
			Thread.sleep(4000);
			home.abofClothingIcon.click();
			Thread.sleep(4000);
			product.abofFavIcon.click();
			String Text=GenericClass.verifyToastMessage(driver);
			System.out.println(Text);
			Assert.assertTrue(Text.contains("Cha-ching! Added to your"),"The mesage is not displayed");
			NXGReports.addStep("The message is displayed", LogAs.PASSED, null);
			//\Thread.sleep(4000);
			Thread.sleep(4000);
		}catch(Exception e){
			throw e;
		}
			
	}
	

}
