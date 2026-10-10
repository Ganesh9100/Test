Feature: Admin Login

  Scenario: Admin logs in successfully
    Given the admin is on the login page
    When the admin enters valid credentials
    And clicks the login button
    Then the admin should be redirected to the dashboard
