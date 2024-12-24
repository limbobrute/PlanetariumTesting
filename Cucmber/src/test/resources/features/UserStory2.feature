Feature: User Story 2
  Users should be able to securely access their account

  Background:
    Given The user is on the login page
    When  The user clicks on the login link

  Scenario Outline: Testing for current Valid Credentials
    When The user provides the username of "<username>"
    And  The user provides the password of "<password>"
    And  The user submits the credentials
    Then The user should see "<result>"

  Examples:
    |username|password     |result                                  |
    |Limbo   |Cataclysm2012|The user is directed to the Home page   |
    |Limbo   |BigRocks     |Browser Alert: Invalid Credentials alert|
    |Atlas   |Cataclysm2012|Browser Alert: Invalid Credentials alert|
    |Atlas   |BigRocks     |Browser Alert: Invalid Credentials alert|