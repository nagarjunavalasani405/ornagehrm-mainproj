package com.hrm.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hrm.qa.basepage.BaseClass;

public class GetTextData extends BaseClass {
	
	  static XSSFWorkbook wbook;
	
	  
	public static Object[][] getTextData(){
		
	  
		try {
			File file = new File("C:\\workspace\\orangehrm\\src\\main\\java\\com\\hrm\\qa\\testdata\\Testdata.xlsx");
			
			FileInputStream fis = new FileInputStream(file);
			
			wbook = new XSSFWorkbook(fis);
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = wbook.getSheetAt(0);
		
		//here we create the object of array and given size of array..
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		
	    for(int i=1; i<sheet.getLastRowNum() ;i++) {
	    	
		   for(int k=0; k < sheet.getRow(i).getLastCellNum(); k++) {
			  
			    data[i][k] = sheet.getRow(i).getCell(k).getStringCellValue();
			   
			  // System.out.print( data[i][k]+ " ");
			  
	   }
		// System.out.println();
     }
	    return data;
	    
	       }
	
	
	}




