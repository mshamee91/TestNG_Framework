package com.qa.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	public void onStart(ITestContext context) {
		System.out.println(context.getOutputDirectory());
	}

	public void onTestStart(ITestResult result) {
		System.out.println(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println(context.getPassedTests());
		System.out.println(context.getFailedTests());
	}

}
