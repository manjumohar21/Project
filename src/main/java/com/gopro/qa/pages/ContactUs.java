package com.gopro.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gopro.qa.base.TestBase;
import com.gopro.qa.util.TestUtil;

public class ContactUs extends TestBase{
	@FindBy(xpath ="//input[@id='name']")
	WebElement Name;
	
	@FindBy(xpath ="//input[@id='email']")
	WebElement Email;
	
	@FindBy(xpath ="//input[@id='phone']")
	WebElement PhoneNo;
	
	@FindBy(name ="message")
	WebElement Message;
	
	@FindBy(xpath="//input[@type= 'submit' and @value='Send to Customer Care']")
	WebElement Send;
	
	@FindBy(xpath = "//*[@class='contact']")
	WebElement Contacts;
	
	public  ContactUs()
	{
		PageFactory.initElements(driver, this);
	}

	public void SendCustomerFeedback(String name, String email, String PhoneNum, String message)
	{
		System.out.println("We have reached: SendCustomerFeedback() method");
		Contacts.click();
		System.out.println("Filling Data in Contact section");
		System.out.println(name);
		System.out.println(email);
		System.out.println(PhoneNum);
		System.out.println(message);
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		//System.out.println("Adding Data Started");
		Name.sendKeys(name);
		Email.sendKeys(email);
		PhoneNo.sendKeys(PhoneNum);
		Message.sendKeys(message);
		Send.click();
		
	}
	


}
