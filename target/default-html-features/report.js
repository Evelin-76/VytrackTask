$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Contacts.feature");
formatter.feature({
  "name": "Contacts page",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify Create Calendar Event",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.vytrack.step_definitions.LoginStepDefs.the_user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user enter the drver information",
  "keyword": "And "
});
formatter.match({
  "location": "com.vytrack.step_definitions.LoginStepDefs.the_user_enter_the_drver_information()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "navigate to \"Activities\" \"Calendar Events\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.vytrack.step_definitions.NavigationStepDef.navigateTo(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the title contains \"Calendars\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.vytrack.step_definitions.LoginStepDefs.theTitleContains(java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:87)\r\n\tat org.junit.Assert.assertTrue(Assert.java:42)\r\n\tat org.junit.Assert.assertTrue(Assert.java:53)\r\n\tat com.vytrack.step_definitions.LoginStepDefs.theTitleContains(LoginStepDefs.java:64)\r\n\tat ✽.the title contains \"Calendars\"(file:///C:/Users/Evelin/IdeaProjects/EU5CucumberSelenium/src/test/resources/features/Contacts.feature:14)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png", "screenshot");
formatter.after({
  "status": "passed"
});
});