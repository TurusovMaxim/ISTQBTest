package org.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Works with the result page.
 */
public class ResultPage {
    public WebDriver driver;

    /**
     * It's a constructor to work with @FindBy annotation
     * from ISTQBTest
     * @param driver -  a webDriver object
     */
    public ResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//div[contains(@class, 'searchintro')]")
    private WebElement numberOfResults;

    @FindBy(xpath = "(//a[contains(text(),'Foundation Level Automotive Software Tester')])[3]")
    private WebElement searchPage;

    /**
     * Checks a number of results.
     * @return - a number of results.
     */
    public String getNumberOfResults() {
        return numberOfResults.getText();
    }


    /**
     * Scrolls the page to the link we want (foundLevelAutoSoftTester) and clicks it.
     * @throws InterruptedException - uses JavascriptExecutor to scroll the resultPage.
     */
    public void clickSearchPage() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchPage);
        Thread.sleep(500);

        searchPage.click();
    }
}
