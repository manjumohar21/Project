package com.gopro.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gopro.qa.base.TestBase;
import com.gopro.qa.util.TestUtil;

public class LoginPage extends TestBase {

	/*
	 * Page Factory is a class provided by Selenium WebDriver to support Page Object
	 * Design patterns. In Page Factory, testers use @FindBy annotation. The
	 * initElements method is used to initialize web elements.
	 * 
	 * @FindBy: An annotation used in Page Factory to locate and declare web
	 * elements using different locators. Below is an example of declaring an
	 * element using @FindBy
	 * 
	 * @FindBy(id="elementId") WebElement element;
	 */

	@FindBy(xpath = "//input[@name='username']")
	private WebElement email_id;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath ="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//img[contains(@title,'ParaBank')]")
	WebElement LogoImage;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	/**Actions*/
	public String ValidateLoginTitlePage()
	{
	return driver.getTitle();
	}
	
	public boolean VerifyLogoImage()
	{
		return LogoImage.isDisplayed();
	}
	
	
	public HomePage login(String un, String pwd)
	{
		System.out.println("Have we reached here?");
		System.out.println("email "+un);
		System.out.println("Password "+pwd);
		boolean b1 = email_id.isDisplayed();
		System.out.println(b1);
		boolean b2 = password.isDisplayed();
		System.out.println(b2);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		email_id.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
	
	
}
