package com.opencart.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.utils.BaseClass;

public class ProductAvailability extends BaseClass {
	
	WebDriver driver;
	Properties prop;
	BaseClass configfile;

	public ProductAvailability(WebDriver driver) {

		this.driver = driver;

	}

	public void productSearch() throws InterruptedException {

		configfile = new BaseClass();
		prop = configfile.init_prop();
		
		driver.findElement(By.xpath(prop.getProperty("Searchbar"))).sendKeys(prop.getProperty("SearchKey"));
		driver.findElement(By.xpath(prop.getProperty("SearchBtn"))).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.linkText(prop.getProperty("iphone"))).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("quantity"))).clear();
		driver.findElement(By.xpath(prop.getProperty("quantity"))).sendKeys("2");
		driver.findElement(By.xpath(prop.getProperty("Addtocart"))).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("Itemcart"))).click();
		driver.findElement(By.xpath(prop.getProperty("Checkout"))).click();
		
	}
}
