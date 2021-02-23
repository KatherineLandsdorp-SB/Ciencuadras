package com.segurosbolivar.automation;

import com.segurosbolivar.automation.commons.Methods;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;
@SuppressWarnings("unchecked")
public class TestClass {

    public static void main(String[] args) {
        System.out.println("Test");
        TestNG testng = new TestNG();
        List suites = Lists.newArrayList();
        suites.add("src/test/java/resources/suiteSanity.xml");
        testng.setTestSuites(suites);
        testng.run();
    }
}