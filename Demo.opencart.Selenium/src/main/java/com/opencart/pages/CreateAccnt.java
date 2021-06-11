package com.opencart.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.utils.BaseClass;

public class CreateAccnt extends BaseClass {

	WebDriver driver;
	Properties prop;
	BaseClass configfile;

	public CreateAccnt(WebDriver driver) {
		this.driver = driver;
	}

	public void fillCreateaccountForm(String FirstName, String LastName, String EmailAddress, String Telephone,
			String Password, String ConfirmPassword) {

		configfile = new BaseClass();
		prop = configfile.init_prop();

		driver.findElement(By.xpath(prop.getProperty("MyAccount_btn_xpath"))).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("Register_btn_xpath"))).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("First_name_xpath"))).sendKeys(FirstName);
		driver.findElement(By.xpath(prop.getProperty("Last_name_xpath"))).sendKeys(LastName);
		driver.findElement(By.xpath(prop.getProperty("Email_id_xpath"))).sendKeys(EmailAddress);
		driver.findElement(By.xpath(prop.getProperty("Telephone_number_xpath"))).sendKeys(Telephone);
		driver.findElement(By.xpath(prop.getProperty("Create_Pwd_xpath"))).sendKeys(Password);
		driver.findElement(By.xpath(prop.getProperty("Confirm_pwd_xpath"))).sendKeys(ConfirmPassword);
	}

	public void clickSubmit() {
		configfile = new BaseClass();
		prop = configfile.init_prop();
		driver.findElement(By.xpath(prop.getProperty("check_box_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("Click_continue_xpath"))).click();
	}

}
