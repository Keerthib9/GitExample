package com.opencart.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.utils.BaseClass;

public class RemoveProduct extends BaseClass {
	WebDriver driver;
	Properties prop;
	BaseClass configfile;

	public RemoveProduct(WebDriver driver) {

		this.driver = driver;

	}

	public void removeproduct() throws InterruptedException {

		configfile = new BaseClass();
		prop = configfile.init_prop();

		driver.findElement(By.xpath(prop.getProperty("Laptops&Notebooks"))).click();
		driver.findElement(By.xpath(prop.getProperty("ShowAll"))).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.linkText(prop.getProperty("HPLP3065"))).click();
		driver.findElement(By.xpath(prop.getProperty("quantity"))).sendKeys("2");
		driver.findElement(By.xpath(prop.getProperty("Addtocart"))).click();
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("ShoppingCart"))).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("Removeitem"))).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("Continue"))).click();
		
	}
	
}
