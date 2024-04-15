package com.gopro.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.gopro.qa.base.TestBase;

public class AdminPage extends TestBase{
	
	@FindBy(id = "loanProvider")
	WebElement loanProvider;
	
	@FindBy(linkText = "Admin Page")
	WebElement admins;
	
	public AdminPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void SelectLoanProvider()
	{
		System.out.println("Opening Admin Page");
		admins.click();
		System.out.println("Selecting LoanProvider");
		Select select = new Select(loanProvider);
		select.selectByVisibleText("Local");
	}
	

}
