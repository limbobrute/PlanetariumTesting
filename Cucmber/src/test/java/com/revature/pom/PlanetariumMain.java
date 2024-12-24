package com.revature.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

public class PlanetariumMain {
    private WebDriver driver;

    @FindBy(id = "planetNameInput")
    private WebElement BodyNameInputField;

    @FindBy(id = "moonNameInput")
    private WebElement MoonNameInputField;

    @FindBy(id = "orbitedPlanetInput")
    private WebElement MoonOrbitInputField;

    @FindBy(id = "deleteInput")
    private WebElement RemoveBodyInputField;

    @FindBy(xpath = "//*[@id=\"deleteButton\"]")
    private WebElement RemoveBodyButton;

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

    public void ChangeToMoon()
    {
        WebElement dropdown = driver.findElement(By.tagName("select"));
        Select dropdownSel = new Select(dropdown);
        dropdownSel.selectByValue("moon");
    }

    public void EnterMoonName(String string)
    {
        MoonNameInputField.sendKeys(string);
    }

    public void EnterMoonOrbit(String string)
    {
        MoonOrbitInputField.sendKeys(string);
    }

    public void EnterPlanetName(String string)
    {
        BodyNameInputField.sendKeys(string);
    }

    public void EnterNameofBody(String string)
    {
        RemoveBodyInputField.sendKeys(string);
    }

    public void AddImage(String string)
    {
        String path = "";
        if(string.equals(".jpg"))
        {path = "C:\\Users\\William\\Documents\\GitHub\\PlanetariumTesting\\Cucmber\\src\\test\\resources\\Celestial-Images\\moons-1.jpg";}
        else if(string.equals(".png"))
        {path = "C:\\Users\\William\\Documents\\GitHub\\PlanetariumTesting\\Cucmber\\src\\test\\resources\\Celestial-Images\\moons-1.png";}
        else
        {path = "C:\\Users\\William\\Documents\\GitHub\\PlanetariumTesting\\Cucmber\\src\\test\\resources\\Celestial-Images\\Testwebp.webp";}
        ImageLocation.sendKeys(path);
    }

    public void RemoveBody()
    {
        RemoveBodyButton.click();
    }

    public void InsertPlanet()
    {
        InsertButton.click();
    }


}
