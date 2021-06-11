package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import test.mytest;

public class blazedemo
{
	WebDriver driver=null;
	By Searchbycat=By.xpath("//*[@id=\"laptopsImg\"]");
	By Searchsucess= By.xpath("/html/body/div[3]/section/article/h3");
	By product=By.linkText(mytest.Product);
	By qtytextbox= By.name("quantity");
	By qtybtn= By.name("save_to_cart");
	By cartbtn=By.id("menuCart");
	By vreifycart=By.partialLinkText(mytest.Product);
	public blazedemo(WebDriver driver)
	{
		this.driver=driver;
	}

	public void SelectCatagory()
	{
		driver.findElement(Searchbycat).click();
	}

	public void SelectProduct()
	{
		driver.findElement(product).click();
	}

	public void addtocart(String Quentity)
	{
		driver.findElement(qtytextbox).sendKeys(Quentity);
		driver.findElement(qtybtn).click();
	}

}