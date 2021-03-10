package com.segurosbolivar.automation.commons.anotations;

import com.segurosbolivar.automation.commons.enums.Dom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Suite {
    String name() default  "none";
    int id();
    Dom[] domList();
}
