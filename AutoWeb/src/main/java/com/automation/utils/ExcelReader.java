package com.automation.utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.ITestListener;

import com.automation.listener.TestCaseListener;



public class ExcelReader extends ConfigReader

{
	
	String testdatavalue = null;
	ConfigReader config;
	TestCaseListener test;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sh;

	public static void main(String[] args) {
	
	ExcelReader ex= new ExcelReader();
	String data = ex.getTestData("TC001_PhoneNumber");
	System.out.println("Data is ==>"+data);

	}
	

	
	public String getTestData(String testdata)
	{
		config = new ConfigReader();
		test = new TestCaseListener();		
		String workingdir = currentdirectory;
		String testdatapath = config.getTestDatapath();
		String testcasename = test.getTestcaseName()+".xlsx";
		String testdatafilepath= workingdir+"\\"+testdatapath+"\\"+testcasename;
		System.out.println("Test Data File "+testdatafilepath);
		
		try
		{
		fis = new FileInputStream(testdatafilepath);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheetAt(0);
		int rowcount = sh.getLastRowNum();
	
		
		for (int row =0;row<rowcount;row++)
		{
			int colcount = sh.getRow(row).getLastCellNum();
			
			for(int col=0;col<colcount;col++)
			{
				XSSFCell testdatacell = sh.getRow(row).getCell(col);
				XSSFCell testvaluecell = sh.getRow(row+1).getCell(col);
				String currenttestdata = testdatacell.toString();
			
				if (testdata.equalsIgnoreCase(currenttestdata))
				{
				CellType type = testvaluecell.getCellTypeEnum();
				
				switch(type)
				{
				case NUMERIC : testdatavalue = testvaluecell.getRawValue().toString();
				                System.out.println("Test Data value is ====>   "+testdatavalue);
				                
				               break;
				               
				case STRING : testdatavalue = testvaluecell.getStringCellValue().toString();
				               System.out.println("Test Data value is ====>  "+testdatavalue);
				                break;
				
				 default : break;
				}
				}
				
		    	}
				
	    	}
		
     }
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		System.out.println("Vault is -->"+ testdatavalue);
		return testdatavalue;
	}
}
