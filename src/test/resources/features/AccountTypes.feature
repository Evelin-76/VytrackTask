Feature: Account Types
Background:
  Given the user is on the login page


  Scenario Outline: Login with different users
    Given the user logged in as "<userType>"
    When  navigate to "Customers" "Calendar Events"
    Then the title contains "Activities"
    Examples:
      |userType     |
      |store manager|
    #  |adminis --> commented out since it is not valid and make test fails
      |sales manager|


    Scenario Outline: Login users, tabs, modules and titles different
    Given the user logged in as "<userType>"
    When  navigate to "<tab>" "<module>"
    And the title contains "<title>"

    Examples:
      |userType       |tab       |module          |title|
      |store manager   |Activities|Calendar Events|  Activities|
    #  |adminis        |Customers |Accounts        |Accounts - Customers         |
      |sales manager  |Customers |Contacts        |Customers       |



   Scenario Outline: : login as a given user
    Given the user is on the login page
    When the user logs in using following credentials
      | username | <user> |
      | password | UserUser123 |
      | firstname| <firstName> |
      | lastname | <lastName> |
    Then the user should me able to login
    Examples:
    | user           | firstName | lastName      |
    | user10         | Brenden   | Schneider     |
    | storemanager85 | Stephan   |Tremaine Haley |
@db
     Scenario:
       Given the user logged in as "sales manager"
       And user navigate to "Customers" "Contacts"
       When the user clicks the "mbrackstone9@example.com" from contacts
       Then the information should be same with database
