package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class EnglishSteps
{

    @Given("The user is on the on the Wikipedia home page")
    public void the_user_is_on_the_on_the_Wikipedia_home_page() {
        TestRunner.wiki.goToWikiHome();
    }

    @When("The user clicks the English link")
    public void the_user_clicks_the_English_link() {
        TestRunner.wiki.clickEnglishLink();
    }

    @Then("The user should be sent to the English home page")
    public void the_user_should_be_sent_to_the_English_home_page() {
        Assert.assertEquals("Wikipedia, the free encyclopedia",TestRunner.driver.getTitle());
    }

}
