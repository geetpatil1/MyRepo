package test;


import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Utilities.ExcelDataProvider;
import Config.propertyfile;
import Pages.blazedemo;

public class mytest
{
	WebDriver driver=null;
	public static String URL="";
	public static String browsername=null;
	public static String ShopCatagory=null;
	public static String Product=null;
	public static String quentity=null;
	blazedemo demo;	
	Logger log= LogManager.getLogger(mytest.class);

	//Setup Prerequisite 
	@BeforeTest
	public void setup()
	{
		propertyfile.getproperties();
		System.out.print(browsername);
		if(browsername.equalsIgnoreCase("chrome"))
		{	
			String path = System.getProperty("user.dir");
			System.out.print(path);
			System.setProperty("webdriver.ie.driver", path+"\\Driver\\IEDriverServer.exe"); 
			driver=new InternetExplorerDriver();
		}

	}
	//Get data from Excel
	@DataProvider(name="testdata")
	public static Object[][] getdata() throws IOException
	{
		String excelfilepath = System.getProperty("user.dir");
		String excelpath=excelfilepath+"\\src\\main\\java\\Utilities\\Testdata.xlsx";
		Object data[][]= ExcelDataProvider.testdata(excelpath,"Sheet1");
		return data;

	}

	//Search Product by Category
	@Test(dataProvider = "testdata")
	public void searchCatagory(String ShopCatagory, String Product, String Quentity) throws InterruptedException
	{
		mytest.ShopCatagory=ShopCatagory;
		mytest.Product=Product;
		mytest.quentity=Quentity;
		driver.get(URL);
		driver.wait();
		demo=new blazedemo(driver);
		demo.SelectCatagory();
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/section/article/h3")).isDisplayed());
		log.info("Product searched by Catagory");
	}

	//Search Product and validate added to the cart
	@Test(dataProvider = "testdata")
	public void searchProduct(String ShopCatagory, String Product, String Quentity) throws InterruptedException
	{
		demo.SelectProduct();
		demo.addtocart(quentity);
		Assert.assertTrue(driver.findElement(By.partialLinkText(mytest.Product)).isDisplayed());
		log.info("Product added to cart");
	}

	//Close the browser
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}