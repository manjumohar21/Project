package com.gopro.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.gopro.qa.util.TestUtil;
import com.gopro.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListner;
	
	public void testbase() throws IOException {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"E:\\Java_Training\\project\\src\\main\\java\\com\\gopro\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialisation() {
		System.out.println("initialising browser");
		String BrowserName = prop.getProperty("browser");
	
		if (BrowserName.equals("chrome")) {
			System.out.println("Launching Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "E:\\Java_Training\\WebDriver_files\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("Launching Firefox Browser");
		}

		e_driver = new EventFiringWebDriver(driver);
		eventListner = new WebEventListener();
		e_driver.register(eventListner);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		System.out.println("opening"+ prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);

	}
}