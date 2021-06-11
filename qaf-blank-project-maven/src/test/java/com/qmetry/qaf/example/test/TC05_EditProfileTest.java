package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.*;
import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class TC05_EditProfileTest extends WebDriverTestCase {

	@QAFDataProvider(dataFile = "resources/UserData.xls")
	@Test
	public void editProfile(Map<String, String> data) throws InterruptedException {

		get("/");
		getDriver().manage().window().maximize();

		// Sign In
		click("SignIn");
		clear("emailIN");
		sendKeys(data.get("email"), "emailIN");
		clear("pwdIN");
		sendKeys(data.get("pwd"), "pwdIN");
		click("SigninBtn");

		// Edit Profile
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		click("accntBtn");
		click("accounts");
		click("personalInfo");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		clear("lastname");
		String lname = getBundle().getString("lname");
		sendKeys(lname, "lastname");
		getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		String bday = getBundle().getString("bday");
		sendKeys(bday, "bdayPath");
		getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		String bmonth = getBundle().getString("bmonth");
		sendKeys(bmonth, "bmonthPath");
		getDriver().manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		String byear = getBundle().getString("byear");
		sendKeys(byear, "bYearPath");
		getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		sendKeys(data.get("pwd"), "currentPwd");

		getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		click("saveEdit");
		getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		click("accntBtn");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		click("Logout");
		verifyLinkWithPartialTextPresent("Your personal information has been successfully updated.");

	}
}
