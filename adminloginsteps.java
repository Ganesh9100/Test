package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.AdminLoginPage;
import utils.DriverFactory;

public class AdminLoginStep {

    // Initialize the page object using the driver from DriverFactory
    AdminLoginPage adminLoginPage = new AdminLoginPage(DriverFactory.getDriver());

    @Given("the user is on the admin login page")
    public void the_user_is_on_the_admin_login_page() {
        DriverFactory.getDriver().get("https://your-corzaar-url.com/admin");
    }

    @When("the user enters valid credentials {string} and {string}")
    public void the_user_enters_valid_credentials(String username, String password) {
        // Standard method calls instead of routing through ElementUtils
        adminLoginPage.enterUsername(username);
        adminLoginPage.enterPassword(password);
    }

    @When("clicks on the login button")
    public void clicks_on_the_login_button() {
        adminLoginPage.clickLogin();
    }

    @Then("the user should be navigated to the admin dashboard")
    public void the_user_should_be_navigated_to_the_admin_dashboard() {
        // Add your assertions here
    }
}
