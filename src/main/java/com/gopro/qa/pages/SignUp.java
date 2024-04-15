package com.gopro.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gopro.qa.base.TestBase;
import com.gopro.qa.util.TestUtil;

public class SignUp extends TestBase{

/*	@FindBy(xpath ="//a[text()='Register']")
	WebElement Register;
*/	
	@FindBy(linkText = "Register")
	WebElement Register;
	

	@FindBy(id = "customer.firstName")
	WebElement firstName;
	

	@FindBy(id = "customer.lastName")
	WebElement lastName;
	
	public SignUp() 
	{
		PageFactory.initElements(driver, this);
	}

	public void SignUpClass(String firstname, String lastname)
	{
		
     driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
	 Register.click();
     driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
     System.out.println("Did we click?");
	 firstName.sendKeys(firstname);
	 lastName.sendKeys(lastname);
	 
	}
	
}
