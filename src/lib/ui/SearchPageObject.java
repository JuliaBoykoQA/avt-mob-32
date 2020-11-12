package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {

    private static final String
            SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_INPUT = "//*[contains(@text,'Search…')]",
            SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='{SUBSTRING}']",
            SEARCH_LIST_ITEM_TITLE = "org.wikipedia:id/page_list_item_title",
            SEARCH_START_ENTER_DATA_ELEMENT = "org.wikipedia:id/search_empty_message";


    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /*TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /*TEMPLATES METHODS */

    public void initSearchInput()
    {
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 15);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search int element");
    }

    public void clickCancelSearch()
    {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON), "Cannot find click search cancel button!", 5);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSentKeys(By.xpath(SEARCH_INPUT), search_line,"Cannot find and type into search input", 5 );
    }

    public void clickByArticleWithSubString(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find and click search result with substring" + substring, 10);
    }

    public void waitForListElementItemTitle()
    {
        this.waitForElementPresent(By.id(SEARCH_LIST_ITEM_TITLE), "Cannot find any result titles", 15);
    }

    public void waitForStartEnterDataElement()
    {
        this.waitForElementPresent(By.id(SEARCH_START_ENTER_DATA_ELEMENT), "Elements contains on page", 15);
    }
}
