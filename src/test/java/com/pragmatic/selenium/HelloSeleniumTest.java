package com.pragmatic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HelloSeleniumTest {

    WebDriver webDriver;


    @BeforeMethod
    public void beforeMethod(){
        //Create a browser instance
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }


    @AfterMethod
    public void afterMethod(){
        //Close the browser
        webDriver.quit();
    }


    @Test
    public void testHelloSelenium(){
        //Navigate to the login page
        webDriver.get("https://www.saucedemo.com/");

        //Type username
        webDriver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Type password
        webDriver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click login
        webDriver.findElement(By.id("login-button")).click();

        //Assert that "Product" is in the title
        Assert.assertEquals(webDriver.findElement(By.cssSelector("[data-test='title']")).getText(), "Products");
    }




}
