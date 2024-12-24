package com.revature.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class PlanetariumHome
{
    private WebDriver driver;

    @FindBy(id="usernameInput")
    private WebElement UsernameInputField;

    @FindBy(id="passwordInput")
    private WebElement PasswordInputField;

    @FindBy(xpath = "/html/body/div/form/input[3]")
    private WebElement LoginButton;

    public PlanetariumHome(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void GoToLogin()
    {
        driver.get("localhost:8080");
    }

    public void EnterUsername(String user)
    {
        UsernameInputField.sendKeys(user);
        //new Actions(driver).sendKeys(UsernameInputField, user);
    }

    public void EnterPassword(String pass)
    {
        PasswordInputField.sendKeys(pass);
        //new Actions(driver).sendKeys(PasswordInputField, pass);
    }

    public void clickLoginButton()
    {
        LoginButton.click();
    }
}
