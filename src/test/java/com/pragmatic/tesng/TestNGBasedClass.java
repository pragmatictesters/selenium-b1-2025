package com.pragmatic.tesng;

import org.testng.annotations.*;

public class TestNGBasedClass {



    @BeforeSuite
    public void beforeSuite(){
        System.out.println("TestNGBasedClass.beforeSuite ================");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("TestNGBasedClass.afterSuite <<<<<<<<<<<<<<<<<<<<<<");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("TestNGBasedClass.beforeClass");
    }


    @AfterClass
    public void afterClass(){
        System.out.println("TestNGBasedClass.afterClass");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("TestNGAnnotationsTest.beforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("TestNGAnnotationsTest.afterMethod");
    }

}
