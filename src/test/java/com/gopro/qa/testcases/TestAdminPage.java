package com.gopro.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gopro.qa.base.TestBase;
import com.gopro.qa.pages.AdminPage;

public class TestAdminPage extends TestBase {

	AdminPage admin;

	public  TestAdminPage() throws IOException {
		this.testbase();
	}

	@BeforeMethod

	public void setup() {
		initialisation();
		admin = new AdminPage();
	}

	@Test
	public void loanProviderTest() {
		
		admin.SelectLoanProvider();
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}

}
