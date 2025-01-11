package com.pragmatic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CrossBrowserTest {

    WebDriver webDriver;


    @BeforeMethod
    public void beforeMethod() {
        //Create a browser instance

    }


    @AfterMethod
    public void afterMethod() {
        //Close the browser
        webDriver.quit();
    }


    @Test
    public void testGoogleChrome() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
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

    @Test
    public void testGoogleChromeHeadless() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
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

    @Test
    public void testFirefoxBrowser() {
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
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


     @Test
    public void testFirefoxBrowserHeadless() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");

        webDriver = new FirefoxDriver(options);
        webDriver.manage().window().maximize();
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


    @Test
    public void testEdgeBrowser() {
        webDriver = new EdgeDriver();
        webDriver.manage().window().maximize();
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

      @Test
    public void testEdgeHeadless() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("headlesss");

        webDriver = new EdgeDriver(options);
        webDriver.manage().window().maximize();
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





    @Test
    public void testSafariBrowser() {
        webDriver = new SafariDriver();
        webDriver.manage().window().maximize();
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
