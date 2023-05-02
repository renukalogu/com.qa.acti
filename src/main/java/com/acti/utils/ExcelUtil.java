package com.acti.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
XSSFWorkbook wb;
	
	public ExcelUtil(String excelpath) {
		try
		{
			File src = new File(excelpath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("unable to load the excel sheet plz check the path "+e.getMessage());
		}
		
	}
	
	public int getRows(int sheetnum)
	{
		int rows = wb.getSheetAt(sheetnum).getLastRowNum()+1;
		return rows;
	}
	public String getCellData(int sheetnum,int row,int col)
	{
		String data = wb.getSheetAt(sheetnum).getRow(row).getCell(col).toString();
		return data;
		
	}

}
