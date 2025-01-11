package com.pragmatic.selenium;

import com.pragmatic.DataProviderSauceLabs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceLoginTest {

    WebDriver webDriver;


    @BeforeMethod
    public void beforeMethod() {
        //Create a browser instance
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.saucedemo.com/");
    }


    @AfterMethod
    public void afterMethod() {
        //Close the browser
        webDriver.quit();
    }


    @Test
    public void testVerifyValidUserLogin() {

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
    public void testLoginWithBlankUsernameAndBlankPassword() {
        webDriver.findElement(By.id("user-name")).clear();
        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("login-button")).click();

        String errorMessage = webDriver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        //Compare
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required", "Error message is incorrect");
    }


    @Test
    public void testLoginWithBlankUsernameAndPassword() {
        webDriver.findElement(By.id("user-name")).clear();
        webDriver.findElement(By.id("password")).sendKeys("secret_sauce");
        webDriver.findElement(By.id("login-button")).click();

        String errorMessage = webDriver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        //Compare
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required", "Error message is incorrect");

    }


    @Test
    public void testLoginWithUserNameAndBlankPassword() {
        webDriver.findElement(By.id("user-name")).sendKeys("standard_user");
        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("login-button")).click();

        String errorMessage = webDriver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        //Compare
        Assert.assertEquals(errorMessage, "Epic sadface: Password is required", "Error message is incorrect");

    }


    @Test
    public void testLoginWithInvalidPassword() {
        //Type username
        webDriver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Type password
        webDriver.findElement(By.id("password")).sendKeys("secret_saucew");
        //Click login
        webDriver.findElement(By.id("login-button")).click();

        String errorMessage = webDriver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        //Compare
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service",
                "Error message is incorrect");
    }


    @Test(dataProvider = "login-credentials")
    public void testInvalidUserLogin(String username, String password, String expectedMessage, String anotherParam) {
        //Type username
        webDriver.findElement(By.id("user-name")).sendKeys(username);

        //Type password
        webDriver.findElement(By.id("password")).sendKeys(password);
        //Click login
        webDriver.findElement(By.id("login-button")).click();

        String errorMessage = webDriver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        //Compare
        Assert.assertEquals(errorMessage, expectedMessage, "Error message is incorrect");
    }

    @Test(dataProvider = "login-credentials", dataProviderClass = DataProviderSauceLabs.class)
    public void testInvalidUserLoginDDTFromClass(String username, String password, String expectedMessage) {
        //Type username
        webDriver.findElement(By.id("user-name")).sendKeys(username);

        //Type password
        webDriver.findElement(By.id("password")).sendKeys(password);
        //Click login
        webDriver.findElement(By.id("login-button")).click();

        String errorMessage = webDriver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        //Compare
        Assert.assertEquals(errorMessage, expectedMessage, "Error message is incorrect");
    }


    @Test(dataProvider = "login-credentials")
    public void testParameters(String username, String password, String expectedMessage, String anotherParam) {
        System.out.println("username = " + username + ", password = " + password + ", expectedMessage = " + expectedMessage + ", anotherParam = " + anotherParam);
    }


    @Test(dataProvider = "add-numbers")
    public void testAddNumber(int a, int b, int c) {
        int result = a + b;
        Assert.assertEquals(result, c);
    }


    @DataProvider(name = "add-numbers")
    public Object[][] addNumber() {
        return new Object[][]{
                {1, 1, 2},
                {1, 5, 6},
                {4, 1, 5},
                {1, 0, 1},
        };
    }


    @DataProvider(name = "login-credentials")
    public Object[][] userCredentials() {
        return new Object[][]{
                {"", "", "Epic sadface: Username is required", "test1"},
                {"", "secret_saucew", "Epic sadface: Username is required", "test2"},
                {"standard_user", "", "Epic sadface: Password is required", "Test3"},
                {"standard_user", "ivalid", "Epic sadface: Username and password do not match any user in this service", "test4"}
        };
    }


}
