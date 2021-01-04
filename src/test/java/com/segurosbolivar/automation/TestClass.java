package com.segurosbolivar.automation;

import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        TestNG testng = new TestNG();
        List suites = Lists.newArrayList();
        suites.add("src/test/java/resources/suite.xml");
        testng.setTestSuites(suites);
        testng.run();
    }
}
