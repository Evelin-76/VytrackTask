@Navigation
Feature: Managers navigate to pages using top menu

  @FleetModule
    Scenario: Navigate to Fleet / Vehicles
      Given the user is on the login page
      And the user enter the manager information
      When user navigate Fleet,Vehicle
      Then the title should be Vehicle

    @db
    @MarketingModule
    Scenario: Navigate to Marketing / Campaigns
      Given the user is on the login page
      And the user enter the manager information
      When  user navigates to Marketing,Campaings
      Then the title should be Campaigns

      @ActivitiesModule
    Scenario: Navigate to Activities / Calendar Events
      Given  the user is on the login page
      And the user enter the manager information
      When user navigates to Activities,Calendar Events
      Then the title should be Calendars