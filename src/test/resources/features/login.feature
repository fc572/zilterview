Feature: Login Functionality
  As a user
  I want to be able to authenticate
  So that I can access my account

  Scenario Outline: Successful login across <platform>
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    Then I should be redirected to the matrix page

    Examples:
      | platform | username | password |
      | Mobile   | Neo      | redpill  |
      | Desktop  | Neo      | redpill  |
