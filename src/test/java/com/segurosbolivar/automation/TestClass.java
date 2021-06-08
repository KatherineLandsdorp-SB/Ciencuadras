package com.segurosbolivar.automation;

import com.segurosbolivar.automation.commons.Methods;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestClass {

    public static void main(String[] args) {
        Pattern pat = Pattern.compile("casa|apartamento");
        Matcher mat = pat.matcher("apartamento");
        System.out.println(mat.find());
    }
}