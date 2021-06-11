package Config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.mytest;
public class propertyfile
{
	static Properties prop = new Properties();
	static String 	projectpath=System.getProperty("user.dir");

	public static void main(String args[])
	{
		setproperties();
		getproperties();
	}

	public static void getproperties()
	{
		try
		{
			InputStream input=new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\Test\\src\\main\\java\\Config\\config.properties");
			prop.load(input);			
			mytest.browsername=prop.getProperty("browser");
			mytest.URL=prop.getProperty("URL");
		}
		catch (Exception e)
		{

		}
	}

	public static void setproperties()
	{
		try
		{
			OutputStream output=new FileOutputStream("C:\\Users\\Administrator\\eclipse-workspace\\Test\\src\\main\\java\\Config\\config.properties");
			prop.setProperty("browser", "chrome");
			prop.store(output,"");

		}
		catch (Exception e)
		{

		}
	}


}