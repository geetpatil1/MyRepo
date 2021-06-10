package test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Config.propertyfile;
import Pages.blazedemo;

public class mytest
{
	WebDriver driver=null;
	public static String browsername=null;
    Logger log= LogManager.getLogger(mytest.class);
	@BeforeTest
	public void setup()
	{
				propertyfile.getproperties();
		System.out.print(browsername);
	 if(browsername.equalsIgnoreCase("chrome"))
		{		
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Administrator\\Downloads\\IEDriverServer.exe"); 
		driver=new InternetExplorerDriver();
		}
	}
	@Test(dataProvider = "testdata")
	public void search(String Fromlocation, String Tolocation) throws InterruptedException
	{
	driver.get("http://blazedemo.com/");
	driver.wait();
	blazedemo demo=new blazedemo(driver);
	demo.selectfromdropdown(Fromlocation);
	demo.selecttodropdown(Tolocation);
	demo.clickbutton();	
	log.info("This is success meassage");
	}
	
	@AfterTest
	public void teardown()
	{
	 driver.quit();
	}
}