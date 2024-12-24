Feature: User Story 5
  Users should be able to remove their findings

  Scenario Outline:Testing the user's ability to only remove something they have control over
    When The user clicks the remove finding link
    Then The user gives a "<Planet>"
    And  The user submits the data
    Then The user gets the following "<Result>"

    Examples:
      |Planet |Result           |
      |Da-gath|Body Deleted     |
      |Lavos  |Invalid Body Name|