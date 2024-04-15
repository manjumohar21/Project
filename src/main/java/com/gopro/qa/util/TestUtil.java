package com.gopro.qa.util;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class TestUtil {

	public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPLICIT_TIMEOUT=10;
	
	public static  String TESTDATA_SHEET_PATH = "E:\\Java_Training\\project\\src\\main\\java\\com\\gopro\\qa\\testdata\\Data.xlsx";
	
	// Making a 2D array to store the excel data (using in data provider)
	public static Object[][] getTestData(String sheetName) throws IOException {

		FileInputStream file = null;
		file = new FileInputStream(TESTDATA_SHEET_PATH);
		XSSFWorkbook workbook = new XSSFWorkbook(file); 
		XSSFSheet sheet = workbook.getSheet(sheetName);
	    
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println("Printing in TestUtil");

		System.out.println("priting lastRow Num"+ sheet.getLastRowNum());
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);

			}
            
		}
		workbook.close();
		file.close();
		return data;
		
	}
	
	
	
	
	
	
	
	
	
}
