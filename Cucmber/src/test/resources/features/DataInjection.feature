#When Cucumber needs run the same scenario several times with different data,
#we can use data injection to do so
Feature: Cucumber data injection

  #An outline is the same as a scenario, but it tells Cucumber that there is
  #test data that needs to be provided, and it's Cucumber job to provide said data
  Scenario Outline: Math that should work
    Given We start with the number <numOne>
    And We have the number <numTwo>
    When We add these numbers together
    Then We should get the number <sum>

  #Anytime you have data that needs to be injected, you use
  #an Example section
  Examples:
    |numOne|numTwo|sum|
    |8     |2     |10 |
    |-1    |2     |1  |