package com.opencart.selenium.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.pages.Login;
import com.opencart.utils.BaseClass;

public class UserLogin extends BaseClass {

	@BeforeTest
	public void bTest() throws IOException {

		launchBrowser();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@Test
	public void creatingAcnt() throws Throwable {

		Login logIn = new Login(driver);
		
		//Login
		logIn.gotoLogin();
		logIn.login(prop.getProperty("Email"), prop.getProperty("Pwd"));
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
		//Verifying Title
		logIn.gotoHomepage();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String Actual= driver.getTitle();
		String Expected = "Your Store";

        if (Actual.equals(Expected)) {
                   System.out.println("-------------Test Passed!");
        } else {
                   System.out.println("-------------Test Failed");
        }

		
	}

	@AfterTest
	public void aTest() {

		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		// driver.close();
	}

}
