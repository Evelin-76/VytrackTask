@login
Feature: Users should be able to login

  Background:
    Given the user is on the login page

  @driver  @smoke @VYT-123
  Scenario: Login as a Driver
    When the user enter the drver information
    Then the user should me able to login

    @loginManager @VYT-123
  Scenario: Login as a Manager
    When the user enter the manager information (create a step definition for manager due it is not same in scenario)
    Then the user should me able to login

  @loginStoreManager  @smoke
  Scenario: Login as a Store Manager
    When the user enter the store manager information
    Then the user should me able to login
