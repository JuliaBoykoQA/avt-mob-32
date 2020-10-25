import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\Users\\njele\\Documents\\GitHub\\avt-mob-32\\apks\\org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkingSearchResultByWord(){

        String searchingText = "JAVA";

        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find Search Wikipedia input",
                10
        );

        waitForElementAndSentKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                searchingText,
                "Cannot find search input",
                10
        );

        WebElement first_element = waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container'][@index='0']//*[@resource-id='org.wikipedia:id/page_list_item_title']"),
                "Cannot find element with 'Java' article",
                10
        );

        Assert.assertTrue("Element with Java substrings not found",
                first_element.getAttribute("text")
                        .toLowerCase()
                        .contains(searchingText.toLowerCase()));

        WebElement second_element = waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container'][@index='1']//*[@resource-id='org.wikipedia:id/page_list_item_title']"),
                "Cannot find element with 'Java' article",
                10
        );

        Assert.assertTrue("Element with Java substrings not found",
                second_element.getAttribute("text")
                        .toLowerCase()
                        .contains(searchingText.toLowerCase()));

        WebElement third_element = waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container'][@index='2']//*[@resource-id='org.wikipedia:id/page_list_item_title']"),
                "Cannot find element with 'Java' article",
                10
        );

        Assert.assertTrue("Element with Java substrings not found",
                third_element.getAttribute("text")
                        .toLowerCase()
                        .contains(searchingText.toLowerCase()));
    }

    private WebElement waitForElementPresent(By by, String error_massage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_massage + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClick(By by, String error_message, int timeOutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeOutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSentKeys(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }
}


