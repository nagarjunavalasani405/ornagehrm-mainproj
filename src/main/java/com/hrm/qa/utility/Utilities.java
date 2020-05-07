package com.hrm.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.hrm.qa.basepage.BaseClass;

public class Utilities extends BaseClass {
	
	public static long PAGE_LOAD_TIMEOUT=20;
	
	public static long IMPLICT_WAIT=10;
	
	  static XSSFWorkbook wbook;
	
	
	
	////////////***this is screenshot method..we using throut project**/////////
	  
	
	public static void TakeScreenShot()  {       
		
		    TakesScreenshot tcr=(TakesScreenshot)driver;
		    
		    File source = tcr.getScreenshotAs(OutputType.FILE);
		    
		   File destfile = new File("C:\\workspace\\orangehrm\\ScreenShots\\orangehrm.png");
		    		    
		    try {
		    	
				FileUtils.copyFile(source, destfile);
				
			} catch (IOException e) {
				
			System.out.println("if get exception" +e.getMessage());
			}
		  
	}
	
	////// this method is Textdata from excel file
	
	public static Object[][] getTextData(){
		
		  
		try {
			File file = new File("C:\\workspace\\orangehrm\\src\\main\\java\\com\\hrm\\qa\\testdata\\Testdata.xlsx");
			
			FileInputStream fis = new FileInputStream(file);
			
			wbook = new XSSFWorkbook(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = wbook.getSheetAt(0);
		
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
	       for(int i=1; i<sheet.getLastRowNum() ;i++) {
	    	
		       for(int k=0; k < sheet.getRow(i).getLastCellNum(); k++) {
			  
			      data[i][k] = sheet.getRow(i).getCell(k).getStringCellValue();
		
	     }
     }
	    return data;
	    
	       }
	
	

}
