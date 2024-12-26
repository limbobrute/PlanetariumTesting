package com.revature.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import com.revature.TestRunner;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.List;

public class UserStory5
{
    @When("The user clicks the remove finding link")
    public void the_user_clicks_the_remove_finding_link() {
        System.out.println("Time to remove a finding");
    }

    @Then("The user gives a {string}")
    public void the_user_gives_a(String string)
    {
        TestRunner.insert.ChangeToPlanet();
        TestRunner.insert.EnterNameofBody("");
        TestRunner.insert.EnterNameofBody(string);
        System.out.println("User is looking to remove the planet " + string);
    }

    @Then("The user gives {string}")
    public void the_user_gives(String string)
    {
        TestRunner.insert.ChangeToMoon();
        TestRunner.insert.EnterNameofBody("");
        TestRunner.insert.EnterNameofBody(string);
        System.out.println("User is looking to remove " + string);
    }

    @Then("The user gets the following {string}")
    public void the_user_gets_the_following(String string) {
        TestRunner.insert.RemoveBody();
        if(string.equals("Body Deleted"))
        {
            boolean gone = false;
            List<WebElement> rows = TestRunner.driver.findElements(By.tagName("tr"));
            for(int i = 0; i <= rows.size()-1; i++)
            {
                List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
                for (int j = 0; j <= cols.size()-1; j++)
                {
                    String cell = cols.get(j).getText();
                    if(cell.equals("Da-gath"))
                    {gone = true; break;}
                }
                if(gone)
                {break;}
            }
            Assert.assertFalse(gone);
        }
        else
        {
            Alert alert = TestRunner.driver.switchTo().alert();
            String text = alert.getText();
            Assert.assertEquals("Invalid planet name", text);
            alert.accept();
        }

    }

    @Then("The user should receive {string}")
    public void the_user_should_see(String string) throws InterruptedException {
        //Thread.sleep(2000);
        TestRunner.insert.RemoveBody();
        if(string.equals("Moon Removed"))
        {
            boolean gone = false;
            List<WebElement> rows = TestRunner.driver.findElements(By.tagName("tr"));
            for(int i = 0; i <= rows.size()-1; i++)
            {
                List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
                for (int j = 0; j <= cols.size()-1; j++)
                {
                    String cell = cols.get(j).getText();
                    if(cell.equals("Titan"))
                    {gone = true; break;}
                }
                if(gone)
                {break;}
            }
            Assert.assertFalse(gone);
        }
        else
        {
            Alert alert = TestRunner.driver.switchTo().alert();
            String text = alert.getText();
            Assert.assertEquals("Invalid moon name", text);
            alert.accept();
        }
    }
}
