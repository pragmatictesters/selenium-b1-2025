package com.pragmatic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebDriverMethodTest {


    WebDriver webDriver;


    @BeforeMethod
    public void beforeMethod() {
        //Create a browser instance
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }


    @AfterMethod
    public void afterMethod() {
        //Close the browser
        webDriver.quit();
    }


    @Test
    public void tesCurrentURL() {
        //Navigate to the login page
        String baseURL = "https://opensource-demo.orangehrmlive.com";
        webDriver.get(baseURL);
//        Assert.assertEquals(webDriver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com");
        Assert.assertTrue(webDriver.getCurrentUrl().startsWith(baseURL));

    }

    @Test
    public void testPageTitle() {
        //Navigate to the login page
        String baseURL = "https://opensource-demo.orangehrmlive.com";
        webDriver.get(baseURL);
        Assert.assertEquals(webDriver.getTitle(), "OrangeHRM", "Page title is not correct");

    }

    @Test
    public void testNavigation() {
        //Navigate to the login page
        String baseURL = "https://opensource-demo.orangehrmlive.com";
//        webDriver.get(baseURL);
        webDriver.navigate().to(baseURL);
        webDriver.navigate().back();
        webDriver.navigate().forward();
        webDriver.navigate().refresh();
    }


    @Test
    public void testFindElements() {
        //Navigate to the login page
        String baseURL = "https://www.saucedemo.com/";
        webDriver.get(baseURL);
        List<WebElement> elements = webDriver.findElements(By.tagName("input"));

        Assert.assertEquals(elements.size(), 3);

        elements.get(0).sendKeys("standard_user");
        elements.get(1).sendKeys("secret_sauce");
        elements.get(2).click();
    }


}
