package com.opencart.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.utils.BaseClass;

public class Login extends BaseClass {

	WebDriver driver;
	Properties prop;
	BaseClass configfile;

	public Login(WebDriver driver) {

		this.driver = driver;

	}

	public void gotoLogin() throws InterruptedException {

		configfile = new BaseClass();
		prop = configfile.init_prop();

		driver.findElement(By.xpath(prop.getProperty("MyAccount_btn_xpath"))).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("Login_xpath"))).click();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

	}

	public void login(String EmailUsername, String Password) throws InterruptedException {

		configfile = new BaseClass();
		prop = configfile.init_prop();
		driver.findElement(By.xpath(prop.getProperty("Email_login_xpath"))).sendKeys(EmailUsername);
		driver.findElement(By.xpath(prop.getProperty("Pwd_login_xpath"))).sendKeys(Password);

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("Login_btn_Xpath"))).click();

	}
	
	public void gotoHomepage(){
		
		driver.findElement(By.linkText(prop.getProperty("Home"))).click();
		
	}

}
