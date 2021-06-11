package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static com.qmetry.qaf.automation.step.CommonStep.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;


/**************************************************************
 * Create By: B Keerthi Date: 010-06-2021 Type: Qmetry Framework
 *
 *************************************************************/

public class TC04_CancelOrderTest extends WebDriverTestCase {

	@QAFDataProvider(dataFile = "resources/UserData.xls")
	@Test
	public void cancelOrder(Map<String, String> data) throws InterruptedException {

		get("/");
		getDriver().manage().window().maximize();

		// Sign In
		click("SignIn");
		clear("emailIN");
		sendKeys(data.get("email"), "emailIN");
		clear("pwdIN");
		sendKeys(data.get("pwd"), "pwdIN");
		click("SigninBtn");

		// Cancelling order in Orders page
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		click("accntBtn");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		click("orders");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		click("ordrDetails");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		click("cancelBookingbtn");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		click("selectPack");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,150)");
		waitForVisible("cancelReqSubmt", 10);
		click("cancelReqSubmt");
		getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		String msg = getBundle().getString("msg");
		waitForVisible("popupMsg", 10);
		sendKeys(msg , "popupMsg");
		click("popupSubmit");
		Thread.sleep(1000);
		verifyLinkWithPartialTextPresent("You have booking cancelation requests from this order");
		
	}

}
