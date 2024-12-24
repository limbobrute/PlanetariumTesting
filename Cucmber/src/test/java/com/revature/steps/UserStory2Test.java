package com.revature.steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.revature.TestRunner;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class UserStory2Test
{ ;
    @When("The user clicks on the login link")
    public void the_user_clicks_on_the_login_link() {
        System.out.println("Time to log in");
        TestRunner.planetariun.GoToLogin();
    }

    @When("The user provides the username of {string}")
    public void the_user_provides_the_username_of(String string) {
        System.out.println("Attempted username is " + string);
        TestRunner.planetariun.EnterUsername(string);
    }

    @When("The user provides the password of {string}")
    public void the_user_provides_the_password_of(String string) {
        System.out.println("Coupled with the password of " + string);
        TestRunner.planetariun.EnterPassword(string);
    }

    @Then("The user should see {string}")
    public void the_user_should_see(String string)
    {
        TestRunner.planetariun.clickLoginButton();
        if(string.equals("Browser Alert: Invalid Credentials alert"))
        {
            Alert alert = TestRunner.driver.switchTo().alert();
            String text = alert.getText();
            Assert.assertEquals("Invalid credentials", text);
            alert.accept();
        }
        else
        {Assert.assertEquals("Home", TestRunner.driver.getTitle());}
    }
}
