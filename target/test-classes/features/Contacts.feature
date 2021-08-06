Feature: Contacts page


  Scenario: Default page number
    Given the user is on the login page
    And the user enter the drver information
    When navigate to "Customers" "Contacts"
    Then default page number should be 1
  @wip
    Scenario: Verify Create Calendar Eventdesencadenar
      Given the user is on the login page
      And the user enter the drver information
      When navigate to "Activities" "Calendar Events"
      Then the title contains "Calendar"

    Scenario: Menu Options
      Given the user logged in as a "driver"
      Then the user should see following options
      | Fleet |
      | Customers |
      | Activities |
      | System |

    Scenario: login as a given user
      Given the user is on the login page
      When the user logs in using following credentials
      | username | user10 |
      | password | UserUser123 |
      | firstname| Brenden |
      | lastname | Schneider |
      Then the user should me able to login