package com.Stepdefanition;

import org.testng.Assert;
import com.Pages.Adminlogin;
import com.driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminloginSteps {
    private static String title;
    private Adminlogin log;
	
    @Given("user lanuch the application")
    public void user_lanuch_the_application() {
        Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("login"));
        System.out.println("Current URL: " + DriverFactory.getDriver().getCurrentUrl());
        
        log = new Adminlogin(DriverFactory.getDriver());
        title = log.getAdminPageTitle();
        System.out.println("Page title is: " + title);
    }
    
    @When("user click the admin button")
    public void user_click_the_admin_button() {
        log.clicktheadminbutton();
        title = log.getAdminPageTitle();
        System.out.println("Page title after clicking admin is: " + title);
    }
	
    @When("user enter the {string}")
    public void user_enter_the(String email) {
        log.enterEmailid(email);
    }

    @When("user enter the password {string}")
    public void user_enter_the_password(String password) {
        log.enterPassword(password);
    }

    @When("click the aunthendicate button")
    public void click_the_aunthendicate_button() {
        log.clickauthendicatebutton();
    }
    
    @Then("user verify the {string} and {string}")
    public void user_verify_the_and(String status, String message) {
        System.out.println("Status: " + status);
        System.out.println("Expected Message: " + message);
        
        if (status.equalsIgnoreCase("failed")) {
            String actualMessage = log.getvalidationMessage();
            System.out.println("Actual Message: " + actualMessage);
            Assert.assertEquals(actualMessage, message);
        }
    }

    @And("Admin is on the 2FA verification page")
    public void admin_is_on_the_2fa_verification_page() {
        log = new Adminlogin(DriverFactory.getDriver());
        log.dipalyedfapage();
        System.out.println("2FA Page text displayed: " + log.FAPagetext.getText());
    }

    @When("admin enters valid {string}")
    public void admin_enters_valid(String otp) {
        log.enterpasscode(otp);
    }

    @When("admin click the verify button")
    public void admin_click_the_verify_button() {
        log.clicksubmitbutton();
    }

    @When("admin verify the {string} and {string} for otp")
    public void admin_verify_the_and_for_otp(String status, String message) {
        System.out.println("Status: " + status);
        System.out.println("Expected Message: " + message);

        if (status.equalsIgnoreCase("failed")) {
            String actualMessage = log.getvalidationMessageotp();
            System.out.println("Actual Message: " + actualMessage);
            Assert.assertEquals(actualMessage, message);
        }
    }

    @Then("admin should be logged in successfully")
    public void admin_should_be_logged_in_successfully() {
        String actualURL = log.getcurrentUrl();
        System.out.println("Actual URL after login: " + actualURL);
        Assert.assertTrue(actualURL.contains("admin"));
    }
}
