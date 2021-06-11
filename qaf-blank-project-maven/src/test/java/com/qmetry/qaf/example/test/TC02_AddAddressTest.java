package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.*;

import java.util.Map;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;


/**************************************************************
 * Create By: B Keerthi Date: 010-06-2021 Type: Qmetry Framework
 *
 *************************************************************/

public class TC02_AddAddressTest extends WebDriverTestCase {

	@QAFDataProvider(dataFile = "resources/UserData.xls")
	@Test
	public void addAddress(Map<String, String> data) throws InterruptedException {

		get("/");
		getDriver().manage().window().maximize();
		
		//Sign In
		click("SignIn");
		clear("emailIN");
		sendKeys(data.get("email"), "emailIN");
		clear("pwdIN");
		sendKeys(data.get("pwd"), "pwdIN");
		click("SigninBtn");
		
		//Adding Address
		click("AddFirstAddr");
		sendKeys(data.get("address"),"Address");
		sendKeys(data.get("city"),"CityPath");
		sendKeys(data.get("state"),"StatePath");
		sendKeys(String.valueOf(data.get("postal")),"PostPath");
		sendKeys(String.valueOf(data.get("Homephn")),"HphnPath");
		sendKeys(String.valueOf(data.get("Mobile")),"mobilePath");
		sendKeys(data.get("addrName"),"refAddr");
		click("SaveAddr");
		verifyLinkWithPartialTextPresent("MY ADDRESS");
		Thread.sleep(1000);
		Reporter.logWithScreenShot("pass");
	}
}
