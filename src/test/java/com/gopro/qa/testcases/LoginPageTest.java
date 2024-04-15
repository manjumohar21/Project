package com.gopro.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gopro.qa.base.TestBase;
import com.gopro.qa.pages.HomePage;
import com.gopro.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage GPLogin;
	HomePage homePage;

	public LoginPageTest() throws IOException {
		this.testbase();
		// super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialisation();
		GPLogin = new LoginPage();
	}

	@Test(priority = 2)

	public void ValidateLoginTitlePage() {
		String title = GPLogin.ValidateLoginTitlePage();
		System.out.println("Print Title Page : " + title);
		Assert.assertEquals(title, "ParaBank | Welcome | Online Banking");
	}

	@Test(priority = 1)
	public void loginTest() {
		System.out.println("Reached LoginPage");
		homePage = GPLogin.login(prop.getProperty("email"), prop.getProperty("password"));
		System.out.println("what homepage returns :" + homePage);
	}

	@Test(priority = 4)
	public void VerifyLogoImage() {
		boolean flag = GPLogin.VerifyLogoImage();
		Assert.assertTrue(flag);

	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}

}
