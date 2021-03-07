package org.example;

import org.example.conf.ConfProperties;
import org.example.pages.FoundLevelAutoSoftTester;
import org.example.pages.MainPage;
import org.example.pages.ResultPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * The Class for testing
 */
public class ISTQBTest {
    public static WebDriver driver;
    public static MainPage mainPage;
    public static ResultPage resultPage;
    public static FoundLevelAutoSoftTester foundLevelAutoSoftTester;


    /**
     * Configures the driver, checks the path to it.
     * Initializes instances of the driver and the basic classes.
     * Opens the window to full screen.
     * Sets a delay of 15 seconds for the page to load.
     * Gets the link to the page via the config file.
     */
    @BeforeClass
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();

        mainPage = new MainPage(driver);

        resultPage = new ResultPage(driver);

        foundLevelAutoSoftTester = new FoundLevelAutoSoftTester(driver);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get(ConfProperties.getProperty("pageAddress"));
    }


    /**
     * Enters data into the search bar.
     * Clicks on the inter button.
     * Checks a number of results.
     * Follows the link.
     * Checks the title of the article.
     *
     * @throws InterruptedException - uses JavascriptExecutor to scroll the resultPage.
     */
    @Test
    public void SearchTest() throws InterruptedException {
        mainPage.inputString(ConfProperties.getProperty("iFoundLevel2018"));

        mainPage.clickEnterBtn();

        String results = resultPage.getNumberOfResults();
        Assert.assertNotEquals(ConfProperties.getProperty("oNumberOfResults"), results);

        resultPage.clickSearchPage(); //JavascriptExecutor is inside

        String article = foundLevelAutoSoftTester.getArticle();
        Assert.assertEquals(ConfProperties.getProperty("oFoundLevelAutoSoftTester"), article);
    }


    /**
     * Closes all the browser windows and terminates the WebDriver session.
     * Quit() method uses to avoid memory leak errors.
     */
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
