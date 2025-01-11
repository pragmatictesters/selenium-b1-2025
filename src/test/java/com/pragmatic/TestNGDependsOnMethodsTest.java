package com.pragmatic;

import org.testng.annotations.Test;

public class TestNGDependsOnMethodsTest {


    @Test
    public void testMethod1() {
        System.out.println("TestNGPriorityTest.testMethod1");
    }


    @Test (dependsOnMethods = {"testMethod3", "testMethod4"})
    public void testMethod2() {
        System.out.println("TestNGPriorityTest.testMethod2");
    }

    @Test
    public void testMethod3() {
        System.out.println("TestNGPriorityTest.testMethod3");
    }


    @Test
    public void testMethod4() {
        System.out.println("TestNGPriorityTest.testMethod4");
    }



}
