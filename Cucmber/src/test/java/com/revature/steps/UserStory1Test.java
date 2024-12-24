package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class UserStory1Test
{
    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page()
    {
        System.out.println("Login/new account page");
        TestRunner.registar.GoToLogin();
    }

    @Then("The user clicks the register link")
    public void the_user_clicks_the_register_link()
    {
        System.out.println("Time for new account");
        TestRunner.registar.GoToRegistarPage();
    }

    @When("the user provides a valid {string}")
    public void the_user_provides_a_valid(String string)
    {
        System.out.println("Attempt to use " + string + " as our username.");
        TestRunner.registar.EnterUsername(string);
    }

    @When("the user provides a {string}")
    public void the_user_provides_a(String string)
    {
        System.out.println("And " + string + " as our password. (Oh look, I can see it)");
        TestRunner.registar.EnterPassword(string);
    }

    @When("The user submits the credentials")
    public void the_user_submits_the_credentials()
    {
        System.out.println("Let's check those credentials");
    }

    @Then("The user should get a browser alert saying {string}")
    public void the_user_should_get_a_browser_alert_saying(String string)
    {
        //System.out.println(string + "\n");
        TestRunner.registar.CreateUser();
        if(string.equals("Invalid username alert"))
        {
           Alert alert = TestRunner.driver.switchTo().alert();
           String text = alert.getText();
           Assert.assertEquals("Invalid username", text);
           alert.accept();
        }
        else if(string.equals("Invalid password alert"))
        {
            Alert alert = TestRunner.driver.switchTo().alert();
            String text = alert.getText();
            Assert.assertEquals("Invalid password", text);
            alert.accept();
        }
        else
        {
            Alert alert = TestRunner.driver.switchTo().alert();
            String text = alert.getText();
            Assert.assertEquals("Account created successfully", text);
            alert.accept();
        }
    }
}
