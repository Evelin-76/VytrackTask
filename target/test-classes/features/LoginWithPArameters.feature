@loginParameters
Feature: Login as different users

  Scenario: login as a user user
    Given the user is on the login page
    When the user logs in using "user10" and "UserUser123"
    Then the user should me able to login
    And the title contains "Dashboard"

    @homework
    Scenario: login as a UserType
      Given the user is on the login page
      When the user logged in as "StoreMAnager"
     Then the user should me able to login
      And the title contains "Dashboard"