package com.opencart.selenium.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.pages.CreateAccnt;
import com.opencart.utils.BaseClass;

public class RegistrationFail extends BaseClass {

	public String path=("user.dir") + "\\Screenshots";
	
	@BeforeTest
	public void bTest() throws IOException {

		launchBrowser();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@Test
	public void creatingAcnt() throws Throwable {

		CreateAccnt ca = new CreateAccnt(driver);
		ca.fillCreateaccountForm(prop.getProperty("Fname"), prop.getProperty("Lname"), prop.getProperty("Emaill"),
				prop.getProperty("phn"), prop.getProperty("Pwd"), prop.getProperty("ConfirmPwd"));
		ca.clickSubmit();
		screenShot(path+"\\RegistrationFailed.png");
		
	}

	@AfterTest
	public void aTest() {
		
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.close();
	}
}
