package com.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.google.common.collect.Multiset.Entry;

public class ExcelUtils {
	public String readDataFromExcelFile(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		String value=wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	public int getLastRowNum(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
	   int	rowCount=wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
	}
	public void writeDataIntoExcel(String sheetName,int row,int cell,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(value);
		FileOutputStream fout=new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fout);
		wb.close();//compulsory you need to close the excel file after writing into it
	}
	public HashMap<String, String> readMultipleData(String sheetName,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int rowCount=sh.getLastRowNum();
		
		HashMap<String,String>map=new HashMap<String, String>();
		
		for(int i=0;i<=rowCount;i++)
		{
			String key = sh.getRow(i).getCell(cell).getStringCellValue();
			String value=sh.getRow(i).getCell(cell+1).getStringCellValue();
			
			map.put(key,value);
		}
//	for(Entry<String,String>set:map.entrySet())
//		{
///		driver.findElement(By.name(set.getKey()).sendKeys(set.getValue());
//		}
		//for fetching elements in map
		return map;
		}
		
	//TestNG-Data provider		
	public Object[][] excelData(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		int lastRow=sh.getLastRowNum()+1;   //row is 0 index based in excel
		int lastCell=sh.getRow(0).getLastCellNum();
		Object[][] obj=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
			
		{
			for(int j=0;j<lastCell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
			
			}
		return obj;
		}
		

	
		
		
		
	}

