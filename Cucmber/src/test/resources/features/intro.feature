#Overarching name/explanation for content being tested in the feature file
Feature: thing being tested
  Can provided extended descriptions after Feature is declared. This is not needed

  #this will set up a starting condition for all scenarios to go from. This executes before any
  #all scenarios are executed
  Background:
    Given Some starting condition
  #Scenarios are actual tests. These sections are were what aspect of the feature is tested
  #Can have scenarios associated with 1 feature, but only 1 feature section per feature file
  Scenario: positive test of feature being tested
    When  Some positive action is taken
    Then  Some positive outcome should be achieved

  Scenario: negative test of feature being tested
    When  Some negative action is taken
    Then  Some negative condition should be stopped