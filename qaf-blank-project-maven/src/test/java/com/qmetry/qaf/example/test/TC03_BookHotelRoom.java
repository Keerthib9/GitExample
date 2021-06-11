package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import static com.qmetry.qaf.automation.step.CommonStep.verifyLinkWithPartialTextPresent;
import static com.qmetry.qaf.automation.step.CommonStep.waitForVisible;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;


/**************************************************************
 * Create By: B Keerthi Date: 010-06-2021 Type: Qmetry Framework
 *
 *************************************************************/

public class TC03_BookHotelRoom extends WebDriverTestCase {

	@QAFDataProvider(dataFile = "resources/UserData.xls")
	@Test
	public void bookRoom(Map<String, String> data) throws InterruptedException {

		get("/");
		getDriver().manage().window().maximize();
		
		//Navigating to Executive Rooms
		click("menu");
		getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		waitForVisible("rooms", 5);
		click("rooms");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,150)");
		Thread.sleep(1000);
		click("exeroom");
		for(String winHandle : getDriver().getWindowHandles()){
		    getDriver().switchTo().window(winHandle);
		}
		
		// Booking Hotel Room
		waitForVisible("checkInDate", 5);
		click("checkInDate");
		getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		waitForVisible("mnthPick", 5);
		click("mnthPick");
		click("mnthPick");
		click("mnthPick");
		click("mnthPick");
		click("mnthPick");
		getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		click("datePick");
		getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		waitForVisible("bookNow", 5);
		click("bookNow");
		waitForVisible("proceedChkout", 10);
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		click("proceedChkout");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		click("proceed");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		// SignIn
		click("loginNow");
		sendKeys(data.get("email"), "loginEmail");
		sendKeys(data.get("pwd"), "loginPwd");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		click("loginSubmit");

		// Room Checkout and payment
		waitForVisible("prodProceed", 5);
		click("prodProceed");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		click("agree");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		click("payWire");
		waitForVisible("confrmBtn", 5);
		click("confrmBtn");
		verifyLinkWithPartialTextPresent("Qlo Reservation System is complete.");
		Reporter.logWithScreenShot("BookingHotelRoom");
	}

}
