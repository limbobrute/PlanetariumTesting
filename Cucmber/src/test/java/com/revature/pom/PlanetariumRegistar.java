package com.revature.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class PlanetariumRegistar {
    private WebDriver driver;

    @FindBy(id = "usernameInput")
    private WebElement NewUsernameField;

    @FindBy(id = "passwordInput")
    private WebElement NewPasswordField;

    @FindBy(xpath = "/html/body/div/form/a")
    private WebElement RegistarButton;//This is the go to account creation button on the login page

    @FindBy(xpath = "/html/body/div/form/input[3]")
    private WebElement NewUserButton;//This is the register button on the create account page

    public PlanetariumRegistar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void GoToLogin() {
        driver.get("localhost:8080");
    }

    public void GoToRegistarPage() {
        RegistarButton.click();
    }

    public void EnterUsername(String user)
    {
        NewUsernameField.sendKeys(user);
    }

    public void EnterPassword(String pass)
    {
        NewPasswordField.sendKeys(pass);
    }

    public void CreateUser()
    {
        NewUserButton.click();
    }
}
