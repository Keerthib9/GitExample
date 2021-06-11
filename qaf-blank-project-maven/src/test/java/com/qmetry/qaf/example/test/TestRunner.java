package com.qmetry.qaf.example.test;

import org.testng.annotations.Test;

public class TestRunner {

	TC01_CreateAccountTest cat = new TC01_CreateAccountTest();
	TC02_AddAddressTest aat = new TC02_AddAddressTest();
	TC03_BookHotelRoom bhr = new TC03_BookHotelRoom();
	TC04_CancelOrderTest cot = new TC04_CancelOrderTest();
	TC05_EditProfileTest ept = new TC05_EditProfileTest();
	TC06_ContactUsTest cut = new TC06_ContactUsTest();
	TC07_RemoveFromCart rfc = new TC07_RemoveFromCart();
	


	@Test(priority = 0, enabled = true)
	public void TC01_CreateAccountTest() throws Throwable {

		cat.createAccount(null);
	}

	@Test(priority = 1, enabled = true)
	public void TC02_AddAddressTest() throws Throwable {

//		login.userLogin();
	}

	@Test(priority = 2, enabled = true)
	public void TC03_BookHotelRoom() throws Throwable {

//		selectChandelier.selectChandelier();
	}

	@Test(priority = 3, enabled = true)
	public void TC04_CancelOrderTest() throws Throwable {

//		selectProd.selectItem();
	}

	@Test(priority = 4, enabled = true)
	public void TC05_EditProfileTest() throws Throwable {

		//.SearchItem();
	}


}
