package com.revature.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class IntroSteps {
    @Given("Some starting condition")
    public void some_starting_condition() {
        System.out.println("This is the starting con");
    }

    @When("Some positive action is taken")
    public void some_positive_action_is_taken() {
        System.out.println("We take a positive action");
    }

    @Then("Some positive outcome should be achieved")
    public void some_positive_outcome_should_be_achieved() {
        System.out.println("Expected positive result");
    }
}
