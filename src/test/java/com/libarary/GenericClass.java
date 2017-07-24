package com.libarary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;

import io.appium.java_client.AppiumDriver;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class GenericClass {
	
	public static String configprop=BaseClass.sDirpath+"\\config.properties";
	public static String readexcel=BaseClass.sDirpath+"\\Abof.xlsx";
	static Dimension dSize;
	
	
	//READ data from the config.properties
	
	public static String getdataproperties(String key){
		
		String svalue=null;
		Properties properties=new Properties();
		
		try{
			
				FileInputStream file=new FileInputStream(configprop);
				properties.load(file);
				svalue=properties.getProperty(key);
			
		}catch(Exception e){
			
		}
		return svalue;
		
	}
	
	//Read data from the excelsheet
	public static String[] getExcelData(String TestcasesId) throws Exception{
		String SData[]=null;
		try{
			FileInputStream input=new FileInputStream(readexcel);
			Workbook wb=(Workbook)WorkbookFactory.create(input);
			Sheet sh=wb.getSheet("AbofLoginApplication");
			int row=sh.getLastRowNum();
			System.out.println(row);
			for(int i=1;i<=row;i++){
				if(sh.getRow(i).getCell(0).toString().equals(TestcasesId)){
					int cell=sh.getRow(i).getLastCellNum();
					System.out.println(cell);
					SData=new String[cell];
					for(int j=0;j<cell;j++){
						SData[j]=sh.getRow(i).getCell(j).getStringCellValue();
					}
					break;
				}
				
			}
		}catch(Exception e){
			throw e;
		}
		return SData;
	}
	
	
	//VERIFY THE TOAST MESSAGE
	public static String verifyToastMessage(AppiumDriver driver) throws IOException, TesseractException {
		String result = null;
		File scfile = driver.getScreenshotAs(OutputType.FILE);
		ITesseract instance = new Tesseract();
		try {
			result = instance.doOCR(scfile);
		} catch (TesseractException e) {
			
			throw e;
		}
		return result;
	}
	
	
	//swipe condtion
	public static void swipe(double startx,double endx){
		
		dSize=BaseClass.driver.manage().window().getSize();
		System.out.println(dSize);
		int STARTX=(int)(dSize.width*startx);
		System.out.println(STARTX);
		int ENDX=(int)(dSize.width*endx);
		System.out.println(ENDX);
		int starty=dSize.height/2;
		System.out.println(starty);
		
		BaseClass.driver.swipe(STARTX, starty, ENDX, starty, 3000);
		
	}
	
	//scroll condtion
	public static void scroll(double starty,double endy)
	{
		dSize=BaseClass.driver.manage().window().getSize();
		System.out.println(dSize);
		int STARTY=(int)(dSize.height*starty);
		int ENDY=(int)(dSize.height*endy);
		int startx=dSize.width/2;
		BaseClass.driver.swipe(startx, STARTY, startx,ENDY, 3000);
		
	}

	

}
