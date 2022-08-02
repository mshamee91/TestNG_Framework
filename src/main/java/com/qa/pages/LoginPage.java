package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class LoginPage extends BaseClass{
	
	//locators
	@FindBy(xpath = "//*[@class='login']")
	WebElement SignInLink;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement EmailAddress;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement Password;

	@FindBy(xpath = "//button[@id='SubmitLogin']")
	WebElement SigninButton;	
	
	//constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public void clickSigninLink() {
		SignInLink.click();
	}
	
	public void enterUsername(String username) {
		EmailAddress.sendKeys(username);
	}

	public void enterPassword(String password) {
		Password.sendKeys(password);
	}

	public void clickSigin() {
		SigninButton.click();
	}
}
