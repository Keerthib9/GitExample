package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static com.qmetry.qaf.automation.step.CommonStep.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

/**************************************************************
 * Create By: B Keerthi Date: 010-06-2021 Type: Qmetry Framework
 *
 *************************************************************/

public class TC06_ContactUsTest extends WebDriverTestCase {
	
	@QAFDataProvider(dataFile = "resources/UserData.xls")
	@Test(description = "Contact Us")
	public void contactUs(Map<String, String> data) throws InterruptedException {
		{

			get("/");
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			// Sign In
			click("SignIn");
			clear("emailIN");
			sendKeys(data.get("email"), "emailIN");
			clear("pwdIN");
			sendKeys(data.get("pwd"), "pwdIN");
			click("SigninBtn");
			
			getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			click("menu");
			getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			click("contact");
			getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			click("subject");
			getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			click("customerservice");
			getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			click("textarea");
			String text = getBundle().getString("text");
			sendKeys(text, "textarea");
			getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			click("sendmessage");
			getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			verifyLinkWithPartialTextPresent("Your message has been successfully sent to our team.");
			
		}
	}
}
