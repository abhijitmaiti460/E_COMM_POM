package com.ibm.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataSupplier {
	
	@DataProvider(name ="loginData")
	public String [][] loginData() throws IOException{
		File file = new File("./src/test/resources/TestDate.xlsx");
		FileInputStream fileInputStream =  new FileInputStream(file);
		XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workBook.getSheet("Login");
		int row = sheet.getPhysicalNumberOfRows();
		int col = sheet.getRow(0).getLastCellNum();
		String [][]data = new String[row-1][col];
		for(int i=0;i<row-1;i++) {
			for(int j=0;j<col;j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		workBook.close();
		fileInputStream.close();
		
		return data;
			
	}
	
	@DataProvider(name ="signupData")
	public String [][] signupData() throws Exception{
		File file = new File("./src/test/resources/TestDate.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workBook.getSheet("Signup");
		int row = sheet.getPhysicalNumberOfRows();
		int col = sheet.getRow(0).getLastCellNum();
		String [][]data = new String [row-1][col];
		for(int i=0;i<row-1;i++) {
			for(int j=0;j<col;j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		workBook.close();
		fileInputStream.close();
		
		return data;
		
	}

}
