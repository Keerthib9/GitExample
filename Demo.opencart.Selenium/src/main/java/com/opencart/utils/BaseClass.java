package com.opencart.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;
	public Properties prop;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;

	public WebDriver launchBrowser() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\opencart_config\\opencart_config.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		if (browsername.equals("Mozilla")) {
			System.setProperty("webdriver.gecko.driver", "src\\\\main\\\\resources\\\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		return driver;
	}

	public Properties init_prop() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/opencart_config/opencart_config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	public static void screenShot(String path) throws Exception {
		
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File(path);
		FileUtils.copyFile(src, des);
	}
	
	public static String getData(int row, int cell) throws Throwable {

		File filepath = new File(System.getProperty("user.dir") + "\\Book1.xlsx");
		FileInputStream stream = new FileInputStream(filepath);
		wb = new XSSFWorkbook(stream);
		sheet = wb.getSheetAt(0);
		String data = sheet.getRow(row).getCell(cell).getStringCellValue();
		return data;

	}
	

}
