package com.gopro.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gopro.qa.pages.SignUp;

public class TestSignUpPage extends SignUp {
	SignUp sign_up;

	public TestSignUpPage() throws IOException {
		this.testbase();
	}

	@BeforeMethod
	public void setup()

	{
		initialisation();
		sign_up = new SignUp();
	}
	
	
	@Test

	public void TestSignUp() {
		sign_up.SignUpClass(prop.getProperty("firstName"), prop.getProperty("lastName"));	
		System.out.println("Sign Up Successful");
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}

}
