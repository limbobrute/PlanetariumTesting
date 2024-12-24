package com.revature.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class DataInjection
{

    int One;
    int Two;
    @Given("We start with the number {int}")
    public void we_start_with_the_number(Integer numOne) {
        System.out.println(numOne);
        One = numOne;
    }

    @And("We have the number {int}")
    public void we_have_the_number(Integer numTwo) {
        System.out.println(numTwo);
        Two = numTwo;
    }

    @When("We add these numbers together")
    public void we_add_these_numbers_together() {
        System.out.println("Resulting sum: " + (One + Two));
    }

    @Then("We should get the number {int}")
    public void we_should_get_the_number(Integer sum) {
        System.out.println("Expected result: " + sum);
    }

}
