package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.LoginPage;

public class LoginTest extends BaseClass {
	
	LoginPage login;
	
	@BeforeMethod(alwaysRun=true)
	public void setPage() {
		login = new LoginPage(driver);
	}

	@Test(groups = {"LoginGroup"}, priority = 0, dataProvider = "TestData", description = "Login method description")
	public void LoginMethod(String username, String password) throws InterruptedException {
		test = extent.createTest("Login Test");
		login.clickSigninLink();
		Thread.sleep(2000);
		login.enterUsername(username);
		test.pass("username entered successfully");
		login.enterPassword(password);
		test.pass("password entered successfully");
		login.clickSigin();
		test.pass("login success");
	}

	@DataProvider(name = "TestData")
	public Object[][] getTestData() {
		return new Object[][] { { "cucumberpractice00@gmail.com", "practice00" } };
	}
	
	@Test(groups = {"DummyGroup"}, priority = 1, enabled = true, description = "Dummy description")
	public void DummyMethod() {
		Assert.assertTrue(true);
	}

}
