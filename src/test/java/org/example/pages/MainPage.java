package org.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Works with the main page.
 */
public class MainPage {
    public WebDriver driver;


    /**
     * It's a constructor to work with @FindBy annotation
     * from ISTQBTest
     * @param driver -  a webDriver object
     */
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[contains(@id, 'mod-search-searchword')]")
    private WebElement searchField;

    /**
     * Enters the string into the search bar.
     * @param searchStr - a string we enter
     */
    public void inputString(String searchStr) {
        searchField.sendKeys(searchStr);
    }


    /**
     * Presses enter in the search bar.
     */
    public void clickEnterBtn() {
        searchField.sendKeys(Keys.ENTER);
    }

}
