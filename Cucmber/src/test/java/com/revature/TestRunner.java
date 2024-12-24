package com.revature;

import com.revature.pom.PlanetariumHome;
import com.revature.pom.PlanetariumMain;
import com.revature.pom.PlanetariumRegistar;
import com.revature.pom.WikiHome;
import com.revature.util.Setup;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "com.revature.steps",
        plugin = {"pretty", "html:src/test/resources/reports/html-report.html"}
)
public class TestRunner
{
    public static WebDriver driver = null;
    public static WikiHome wiki;
    public static PlanetariumHome planetariun;
    public static PlanetariumRegistar registar;
    public static PlanetariumMain insert;

    @BeforeClass
    public static void setup()
    {
        driver = new FirefoxDriver();
        wiki = new WikiHome(driver);
        planetariun = new PlanetariumHome(driver);
        registar = new PlanetariumRegistar(driver);
        insert = new PlanetariumMain(driver);
        Setup.resetTestDatabase();

    }

    @AfterClass
    public static void tearDown()
    {
        if(driver != null)
        {
            driver.quit();
        }
    }

}
