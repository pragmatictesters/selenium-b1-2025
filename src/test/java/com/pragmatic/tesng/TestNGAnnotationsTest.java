package com.pragmatic.tesng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationsTest extends TestNGBasedClass {




    @Test
    public void testMethod1() {
        System.out.println("TestNGAnnotationsTest.testMethod1");
    }


    @Test
    public void testMethod2() {
        System.out.println("TestNGAnnotationsTest.testMethod2");
    }


     @Test
    public void testMethod3() {
        System.out.println("TestNGAnnotationsTest.testMethod3");
    }

     @Test
    public void testMethod4() {
        System.out.println("TestNGAnnotationsTest.testMethod4");
    }




}
