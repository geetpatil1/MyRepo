package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider
{


	public static Object[][] testdata(String Excelpath, String sheet) throws IOException
	{
		ExcelUtils excel=new ExcelUtils(Excelpath, sheet);
		int rowcount=ExcelUtils.getrowcount();
		int colcount=ExcelUtils.getcolcount();
		Object data[][]=new Object[rowcount-1][colcount];
		for(int i=1;i<rowcount;i++)
		{
			for (int j=0;j<colcount;j++)
			{
				String celldata=ExcelUtils.getcelldataString(i, j);
				data[i-1][j]=celldata;
			}
		}

		return data;

	}
}