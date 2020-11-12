package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase
{
    @Test
    public void testCheckingSearchResult()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Hello");
        SearchPageObject.waitForListElementItemTitle();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForStartEnterDataElement();
    }

}
