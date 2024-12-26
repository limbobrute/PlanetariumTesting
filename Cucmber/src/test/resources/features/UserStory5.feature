Feature: User Story 5
  Users should be able to remove their findings

  Background:
    Given The user is on the Home page
    When  The user clicks the remove finding link

  Scenario Outline:Testing the user's ability to only remove something they have control over
    Then The user gives a "<Planet>"
    And  The user submits the data
    Then The user gets the following "<Result>"

    Examples:
      |Planet |Result           |
      |Da-gath|Body Deleted     |
      |Lavos  |Invalid Body Name|

  Scenario Outline: Testing the user's ability to delete a moon
    Then The user gives "<Moon name>"
    And  The user submits the data
    Then The user should receive "<Result>"
    Examples:
    |Moon name|Result           |
    |Titan    |Moon Removed     |
    |Excalibur|Invalid moon name|