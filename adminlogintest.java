package com.tests;

import com.pages.AdminLogin;
import com.utilities.ConfigReader;
import org.testng.annotations.Test;

public class AdminLoginTest {

    @Test
    public void testAdminLogin() {
        // Initialize ConfigReader
        ConfigReader configReader = new ConfigReader();
        configReader.init_prop();

        // Perform login actions
        AdminLogin adminLogin = new AdminLogin();
        adminLogin.enterUsername(ConfigReader.getProperty("adminUsername"));
        adminLogin.enterPassword(ConfigReader.getProperty("adminPassword"));
        adminLogin.clickLogin();

        // Validate login (example: check page title)
        String expectedTitle = "Admin Dashboard";
        String actualTitle = adminLogin.getPageTitle();
        assert actualTitle.equals(expectedTitle) : "Login failed. Expected title: " + expectedTitle;
    }
}
