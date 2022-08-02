package com.qa.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class Transformer implements IAnnotationTransformer{
	public void transform(ITestAnnotation annotation,  Class myClass, Constructor constructor, Method myMethod) {
		annotation.setRetryAnalyzer(com.qa.util.RetryAnalyzer.class);
	}
}
