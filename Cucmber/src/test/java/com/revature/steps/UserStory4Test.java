package com.revature.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import com.revature.TestRunner;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserStory4Test
{
    private String photoType = "";
    @Given("The user is on the Home page")
    public void the_user_is_on_the_Home_page()
    {
        TestRunner.planetariun.GoToLogin();
        TestRunner.planetariun.EnterUsername("Limbo");
        TestRunner.planetariun.EnterPassword("Cataclysm2012");
        TestRunner.planetariun.clickLoginButton();
        System.out.println("Time to add a finding");
    }

    @When("The user clicks the add finding link")
    public void the_user_clicks_the_add_finding_link() {
        TestRunner.insert.ChangeToPlanet();
        System.out.println("Pull up the form for a new finding");
    }

    @When("The user enters a {string}")
    public void the_user_enters_a(String string) {
        TestRunner.insert.EnterPlanetName(string);
        System.out.println("The planet name shall be " + string);
    }

    @And("The user submits a photo file of {string} type")
    public void the_user_submits_a_photo_file_of_type(String string) {
        TestRunner.insert.AddImage(string);
        photoType = string;
        System.out.println("Using a image of the following kind: " + string);
    }

    @When("The user submits the data")
    public void the_user_submits_the_data() {
        System.out.println("Pressing the submit button");
    }

    @Then("The user gets a {string} browser alert")
    public void the_user_gets_a_browser_alert(String string) throws InterruptedException {
        Thread.sleep(2000);
        TestRunner.insert.InsertPlanet();
        if(string.equals("Accepted data"))
        {
            boolean found = false;
            List<WebElement> rows = TestRunner.driver.findElements(By.tagName("tr"));
            for(int i = 0; i <= rows.size()-1; i++)
            {
                List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
                for (int j = 0; j <= cols.size()-1; j++)
                {
                    String cell = cols.get(j).getText();
                    if(cell.equals("Equinox") && photoType.equals(".jpg"))
                    {found = true; break;}
                    if(cell.equals("Chroma") && photoType.equals(".png"))
                    {found = true; break;}
                }
                if(found)
                {break;}
            }
            Assert.assertTrue(found);
        }
        else
        {
            Alert alert = TestRunner.driver.switchTo().alert();
            String text = alert.getText();
            Assert.assertEquals("Invalid image type", text);
        }
    }

    @Then("The user gets a {string} and returned to the home page")
    public void the_user_gets_a_and_returned_to_the_home_page(String string) {
        TestRunner.insert.InsertPlanet();
        if(string.equals("Data added"))
        {
            boolean found = false;
            List<WebElement> rows = TestRunner.driver.findElements(By.tagName("tr"));
            for(int i = 0; i <= rows.size()-1; i++)
            {
                List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
                for (int j = 0; j <= cols.size()-1; j++)
                {
                    String cell = cols.get(j).getText();
                    if(cell.equals("Lavos"))
                    {found = true; break;}
                }
                if(found)
                {break;}
            }
            Assert.assertTrue(found);
        }
        else if(string.equals("Browser Alert: Invalid Planet Name"))
        {
            Alert alert = TestRunner.driver.switchTo().alert();
            Assert.assertEquals("Invalid planet name", alert.getText()); alert.accept();
        }
    }

    @When("The user clicks the remove finding link")
    public void the_user_clicks_the_remove_finding_link() {
        System.out.println("Time to remove a false finding");
    }

    @Then("The user gives a {string}")
    public void the_user_gives_a(String string) {
        System.out.println("User is looking to remove the planet " + string);
    }

    @Then("The user gets the following {string}")
    public void the_user_gets_the_following(String string) {
        //System.out.println("Browser alert: " + string + "\n");
    }
}
