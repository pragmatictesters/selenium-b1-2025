package com.pragmatic.tesng;

import org.testng.annotations.Test;

public class TestNGPriorityTest  extends TestNGBasedClass{


    @Test (priority = 2)
    public void testMethod1() {
        System.out.println("TestNGPriorityTest.testMethod1");
    }


    @Test
    public void testMethod2() {
        System.out.println("TestNGPriorityTest.testMethod2");
    }

    @Test(priority = 1)
    public void testMethod3() {
        System.out.println("TestNGPriorityTest.testMethod3");
    }


    @Test
    public void testMethod4() {
        System.out.println("TestNGPriorityTest.testMethod4");
    }



}
