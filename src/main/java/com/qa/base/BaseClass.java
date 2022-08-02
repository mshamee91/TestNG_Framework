package com.qa.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qa.util.ConfigReader;
import com.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ConfigReader config = new ConfigReader();
	
	public WebDriver driver;
	EventFiringWebDriver e_driver;
	WebEventListener event;
	public ExtentSparkReporter reporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeSuite(alwaysRun=true)
	public void initProperties() throws IOException {
		config.initProperty();
		reporter = new ExtentSparkReporter("./extentreport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() throws IOException, InterruptedException {
		driver = WebDriverManager.chromedriver().create();
		e_driver = new EventFiringWebDriver(driver);
		event =  new WebEventListener();
		e_driver.register(event);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(config.getProperty("url"));
		Thread.sleep(4000);
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		extent.flush();
		driver.quit();
	}
	
}
