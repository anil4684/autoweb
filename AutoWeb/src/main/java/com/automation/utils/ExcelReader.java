package com.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.ITestListener;
import org.testng.annotations.DataProvider;

import com.automation.listener.TestCaseListener;
import com.automation.utils.ConfigReader;



public class ExcelReader extends ConfigReader

{
	// Excel Reader for DataProvider
	// https://sqa.stackexchange.com/questions/25944/automate-mutliple-test-cases-in-a-property-file
	
	String testdatavalue = null;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sh;
	String workingdir = null;
	ConfigReader config ;
	TestCaseListener test ;
	String projectname = null;

	public static void main(String[] args) {
	
	ExcelReader ex= new ExcelReader();
	String data = ex.getTestData("TC001_PhoneNumber");
	System.out.println("Data is ==>"+data);

	}
	

	
	public String getTestData(String testdata)
	{
		 config = new ConfigReader();
		 test = new TestCaseListener();		
	    workingdir = currentdirectory;
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
		
		System.out.println("Value is -->"+ testdatavalue);
		return testdatavalue;
	}
	
	public String getIceHrmestDataFile(){
		
		/*	crmtestdatapath = AutomationResources\\TestData\\CrmProject
				icehrmtestdatapath = AutomationResources\\TestData\\IceHrmProject
				myhrtestdatapath = AutomationResources\\TestData\\MyHrProject
				skytestdatapath = AutomationResources\\TestData\\SkyProject    */
		
		config = new ConfigReader();
	    test = new TestCaseListener();
		String testdatafilepath = null;
		workingdir = currentdirectory;
		
		String testdatapath = config.getIceHrmTestDatapath();
		String testcasename = "TC002_DataProvider_RegisterCompany.xlsx";
		
	//	String testcasename = test.getDPTestcaseName()+".xlsx";
		testdatafilepath= workingdir+"\\"+testdatapath+"\\"+testcasename;
         System.out.println("Test Data File "+testdatafilepath);
		return testdatafilepath;
		
	}
	
	public XSSFSheet getWorkBookSheet(String filepath)
	{
		
	
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sh = wb.getSheetAt(0);
		return sh;
	}
	
	
	public Object[][] getIceHrmTestData()
	{
		int row =0;
		int col =0;
		
		
		
		String filepath = getIceHrmestDataFile();
		
		
		sh = getWorkBookSheet(filepath);
		
		
		
         int rowcount = sh.getLastRowNum();
         int colcount = sh.getRow(0).getLastCellNum();
         Object[][]  tableArray = new Object[rowcount][colcount];
         
		
		for ( row =1;row<=rowcount;row++)
		{
			// colcount = sh.getRow(row).getLastCellNum();
			
			for( col=0;col<colcount;col++)
			{
				XSSFCell testdatacell = sh.getRow(row).getCell(col);
				String currenttestdata = testdatacell.toString();
				System.out.println(" Vaule is ==> "+currenttestdata);
			
				
				CellType type = testdatacell.getCellTypeEnum();
				System.out.println("==> Row   "+row+"   ==> Col   "+col);
				
				switch(type)
				{
				case NUMERIC : tableArray[row-1][col] = testdatacell.getRawValue().toString();
				              //  System.out.println("<== DP : Test Data value is ====>   "+tableArray[row-1][col].toString());
				                 break;
				             
				               
				case STRING : tableArray[row-1][col] = testdatacell.getStringCellValue().toString();
				            //   System.out.println("<== DP Test Data value is ====>  "+tableArray[row-1][col].toString());
				                break;
				
				 default : throw new RuntimeException("There is no support for this type of cell");
					 
				
				}
				
		    	}
	       }
		
				
		return tableArray;
	}
	
	


}
