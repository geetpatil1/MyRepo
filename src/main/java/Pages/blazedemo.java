package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class blazedemo
{
	WebDriver driver=null;
	By searchbtn=By.className("btn btn-primary");
	By fromdropdown=By.name("fromPort");
	By todropdown=By.name("toPort");
	
	public blazedemo(WebDriver driver)
	{
	this.driver=driver;
	}
	
public void selectfromdropdown(String value)
{
	Select dropdown = new Select(driver.findElement(fromdropdown));
	dropdown.selectByVisibleText(value);	
}

public void selecttodropdown(String value)
{
	Select dropdown = new Select(driver.findElement(todropdown));
	dropdown.selectByVisibleText(value);	
}

public void clickbutton()
{
	driver.findElement(searchbtn).click();
}
}