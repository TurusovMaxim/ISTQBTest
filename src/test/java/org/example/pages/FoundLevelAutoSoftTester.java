package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *Works with the foundLevelAutoSoftTester page.
 */
public class FoundLevelAutoSoftTester {
    public WebDriver driver;


    /**
     * It's a constructor to work with @FindBy annotation
     * from ISTQBTest
     * @param driver -  a webDriver object
     */
    public FoundLevelAutoSoftTester(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//h1[contains(.,'Foundation Level Automotive Software Tester')]")
    private WebElement articleTitle;

    /**
     * Finds the title and gets its text.
     * @return - the title text.
     */
    public String getArticle() {
        return articleTitle.getText();
    }


}
