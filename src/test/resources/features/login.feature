Feature: User Authentication
  As a user
  I want to be able to authenticate
  So that I can access my account

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter username "Neo" and password "redpill"
    Then I should be redirected to the dashboard

  Scenario: Failed login with invalid credentials
    Given I am on the login page
    When I enter username "invalid" and password "wrongpass"
