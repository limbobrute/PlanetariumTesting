package com.revature.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiHome
{
    private WebDriver driver;

    @FindBy(id = "js-link-box-en")
    private WebElement EnglishLink;

    @FindBy(name = "search")
    private WebElement SearchBar;
    //private String title;

    public WikiHome(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToWikiHome()
    {
        driver.get("https://www.wikipedia.org/");
    }

    public void clickEnglishLink()
    {
        EnglishLink.click();
    }
}
