package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;


/**************************************************************
 * Create By: B Keerthi Date: 010-06-2021 Type: Qmetry Framework
 *
 *************************************************************/

public class TC07_RemoveFromCart extends WebDriverTestCase {

	@Test
	public void removeFromCart() throws InterruptedException {

		get("/");
		getDriver().manage().window().maximize();

		getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		String loc = getBundle().getString("loc");
		sendKeys(loc, "hotelLoc");
		getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		String hotelname = getBundle().getString("hotelname");
		sendKeys(hotelname, "hotelName");
		Thread.sleep(1000);
		waitForVisible("checkDatePath", 5);
		click("checkDatePath");
		getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		click("checkInDateSel");
		getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		waitForVisible("checkOutDateSel", 5);
		click("checkOutDateSel");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		click("searchBtn");
		
		//Executive adding to cart and removing
		getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,100)");
		click("exeRoomBook");
		getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		waitForVisible("proceedChkout", 5);
		click("proceedChkout");
		getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		click("cartSym");
		Thread.sleep(1000);
		click("removeRoom");
		getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		verifyLinkWithPartialTextPresent("Till now you did not added any room in your cart.");
		
	}

}
