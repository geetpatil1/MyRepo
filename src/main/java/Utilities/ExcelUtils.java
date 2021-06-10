package Utilities;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtils
{
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public  ExcelUtils(String excelpath,String sheetname) throws IOException
	{
		workbook=new XSSFWorkbook(excelpath);
		sheet=workbook.getSheet(sheetname);		
	}
	public static void main(String args[])
	{
		
	}
	
	public static int getrowcount()
	{
		int rowcount=0;
		try
		{
			rowcount=sheet.getPhysicalNumberOfRows();
		}
		catch(Exception e)
		{
			
		}
		return rowcount;
	}
	
	public static int getcolcount()
	{
		int colcount=0;
		try
		{
			colcount=sheet.getRow(0).getPhysicalNumberOfCells();
		}
		catch(Exception e)
		{
			
		}
		return colcount;
	}
	public static String getcelldataString(int rownum, int colnum)
	{
		String celldata="";
		try
		{
			 celldata=sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		}
		catch(Exception e)
		{
			
		}
		return celldata;
	}
	
	public static double getcelldataNumber(int rownum, int colnum)
	{
		double  celldata=0;
		try
		{
			 celldata=sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
		}
		catch(Exception e)
		{
			
		}
		return celldata;
	}
	
	
}