package com.revature.steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;


public class IntroNegativeSteps {
    @When("Some negative action is taken")
    public void some_negative_action_is_taken() {
        System.out.println("Something negative has happened");
    }

    @Then("Some negative condition should be stopped")
    public void some_negative_condition_should_be_stopped() {
        System.out.println("Some negative condition has been prevented");
    }

}
