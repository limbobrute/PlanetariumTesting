package com.revature.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

public class PlanetariumMain {
    private WebDriver driver;

    @FindBy(id = "planetNameInput")
    private WebElement BodyNameInputField;

    @FindBy(xpath = "/html/body/div[1]/div[2]/button")
    private WebElement InsertButton;

    @FindBy(id = "planetImageInput")
    private WebElement ImageLocation;

    public PlanetariumMain(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ChangeToPlanet() {
        WebElement dropdown = driver.findElement(By.tagName("select"));
        Select dropdownSel = new Select(dropdown);
        dropdownSel.selectByValue("planet");
    }

    public void EnterPlanetName(String string)
    {
        BodyNameInputField.sendKeys(string);
    }

    public void AddImage(String string)
    {
        String path = "";
        if(string.equals(".jpg"))
        {path = "C:\\Users\\William\\IdeaProjects\\Cucmber\\src\\test\\resources\\Celestial-Images\\moons-1.jpg";}
        else if(string.equals(".png"))
        {path = "C:\\Users\\William\\IdeaProjects\\Cucmber\\src\\test\\resources\\Celestial-Images\\moons-1.png";}
        else
        {path = "C:\\Users\\William\\IdeaProjects\\Cucmber\\src\\test\\resources\\Celestial-Images\\Testwebp.webp";}
        ImageLocation.sendKeys(path);
    }
    public void InsertPlanet()
    {
        InsertButton.click();
    }


}
