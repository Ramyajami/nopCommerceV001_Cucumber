Feature: Customers
  Background: user login to page
    Given User lunch chrome browser
    When user opens url "https://admin-demo.nopcommerce.com/login"
    And user enters Email as "admin@yourstore.com" and password as "admin"
    And click on Login
    Then  user can view dashboard
    When user click on customers menu
    And click on customers menu item
    @Test1
  Scenario: Sussesful login with valid credentials
    And click on Add new button
    Then user can view Add new customer page
    When user enter customer info
    And click on save button
    Then user can view confirmation message "the new customer has been added successfully"
    And close browser
    @Test2
  Scenario: Search customer by EmailID
    When Enter customer Email
    And click on Search button
    Then user should found Email in the Search table
    And close browser
