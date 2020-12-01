package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class SearchTests extends CoreTestCase
{

    @Test
    public void testSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Programming language");
    }

    @Test
    public void testCancelSearch()
    {
        SearchPageObject  SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();

    }

    @Test
    public void testAmountOfNotEmptySearch()
    {
        SearchPageObject  SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park Discography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "We found too few result",
                amount_of_search_results > 0
        );

    }

    @Test
    public void testAmountOfEmptySearch() {
        SearchPageObject  SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "qwrgfgdtugcddfucgduertyuiop";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNotResultOfSearch();
    }
}
