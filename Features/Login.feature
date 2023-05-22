Feature: Login
  Scenario: Sussesful login with valid credentials
    Given User lunch chrome browser
    When user opens url "https://admin-demo.nopcommerce.com/login"
    And user enters Email as "admin@yourstore.com" and password as "admin"
    And click on Login
    Then page title should be "Dashboard / nopCommerce administration"
    When user click on logout out link
    Then page title should be "Your store. Login"
    And close browser

