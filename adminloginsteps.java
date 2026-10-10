package com.stepdefinitions;

import com.pages.AdminLogin;
import com.utilities.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AdminLoginSteps {

    private AdminLogin adminLogin;

    @Given("the admin is on the login page")
    public void the_admin_is_on_the_login_page() {
        adminLogin = new AdminLogin(); // Initialize the AdminLogin page object
    }

    @When("the admin enters valid credentials")
    public void the_admin_enters_valid_credentials() {
        adminLogin.enterUsername(ConfigReader.getProperty("adminUsername"));
        adminLogin.enterPassword(ConfigReader.getProperty("adminPassword"));
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        adminLogin.clickLogin();
    }

    @Then("the admin should be redirected to the dashboard")
    public void the_admin_should_be_redirected_to_the_dashboard() {
        String expectedTitle = "Admin Dashboard";
        String actualTitle = adminLogin.getPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Login failed. Expected title: " + expectedTitle);
    }
}
