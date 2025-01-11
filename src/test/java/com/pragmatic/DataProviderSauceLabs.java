package com.pragmatic;

import org.testng.annotations.DataProvider;

public class DataProviderSauceLabs {

    @DataProvider(name = "login-credentials")
    public Object[][] userCredentials(){
        return new Object[][] {
                {"", "", "Epic sadface: Username is required"},
                {"", "secret_saucew", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"standard_user", "ivalid", "Epic sadface: Username and password do not match any user in this service"}
        };
    }
}
