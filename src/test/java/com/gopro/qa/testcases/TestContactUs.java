package com.gopro.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gopro.qa.base.TestBase;
import com.gopro.qa.pages.ContactUs;
import com.gopro.qa.util.TestUtil;

public class TestContactUs extends TestBase {
	TestUtil testUtil;
	ContactUs contact;
	String sheetName = "details";

	public TestContactUs() throws IOException {
		this.testbase();
	}

	@BeforeMethod

	public void setup() {
		System.out.println("Calling Initialisation from TestContactUs.java");
		initialisation();
		contact = new ContactUs();
	}

	@DataProvider

	public Object[][] getData_ParaBank() throws IOException {
		System.out.println("Fetching TestData from TestUtil");
		Object data[][] = TestUtil.getTestData(sheetName);
		System.out.println("Data from TestUtil is fetched" + sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getData_ParaBank")
	public void ContactUsTest(String Name, String Email, String PhoneNum, String Message) {
		System.out.println("Printing data from excel" );
		System.out.println(Name);
		System.out.println(Email);
		System.out.println(PhoneNum);
		System.out.println(Message);

		contact.SendCustomerFeedback(Name, Email, PhoneNum, Message);
		System.out.println("Contacts created successfully");
	}

	@AfterMethod

	public void tearDown() {
		System.out.println("Time to close browser");
		driver.quit();
	}
}

/*****************************************OUTPUT***********************************************************/
/*
 * [RemoteTestNG] detected TestNG version 7.4.0
Fetching TestData from TestUtil
Printing in TestUtil
priting lastRow Num2
Manju Mohar
manjumohar@yahoo.com
7.838197789E9
You are the best Manju.
Anu Mohar
moharanu@gmail.com
7.404404411E9
You are very cool.
Data from TestUtil is fetcheddetails
Calling Initialisation from TestContactUs.java
initialising browser
Launching Chrome Browser
Starting ChromeDriver 123.0.6312.105 (399174dbe6eff0f59de9a6096129c0c827002b3a-refs/branch-heads/6312@{#761}) on port 24404
Only local connections are allowed.
Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.
ChromeDriver was started successfully.
Apr 14, 2024 4:13:18 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
openinghttps://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC
Printing data from excel
Manju Mohar
manjumohar@yahoo.com
7.838197789E9
You are the best Manju.
We have reached: SendCustomerFeedback() method
Filling Data in Contact section
Manju Mohar
manjumohar@yahoo.com
7.838197789E9
You are the best Manju.
Contacts created successfully
Time to close browser
PASSED: ContactUsTest("Manju Mohar", "manjumohar@yahoo.com", "7.838197789E9", "You are the best Manju.")

===============================================
    Default test
    Tests run: 1, Failures: 0, Skips: 0
===============================================
===============================================
Default suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================
*/
