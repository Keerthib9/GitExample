package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;


/**************************************************************
 * Create By: B Keerthi Date: 010-06-2021 Type: Qmetry Framework
 *
 *************************************************************/

public class TC01_CreateAccountTest extends WebDriverTestCase {

	@QAFDataProvider(dataFile = "resources/UserData.xls")
	@Test
	public void createAccount(Map<String, String> data) throws InterruptedException {
		
		DOMConfigurator.configure("Logger\\Log4j.xml");
		get("/");
		getDriver().manage().window().maximize();

		click("SignIn");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		sendKeys(data.get("email"), "emailPath");
		click("CreateBtn");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		sendKeys(data.get("fname"), "fnamePath");
		sendKeys(data.get("lname"), "lnamePath");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		sendKeys(data.get("pwd"), "pwdPath");
		click("Register");
		Thread.sleep(1000);
		verifyLinkWithPartialTextPresent(" Your account has been created.");
		Reporter.logWithScreenShot("pass");
	}
}
