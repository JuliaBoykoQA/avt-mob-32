package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ArticleTests  extends CoreTestCase {

    @Test
    public void testTitlePresent()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubString("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String title = ArticlePageObject.tryGetArticleTitle();

        String expected_title = "Java (Programming language)";

        assertEquals("Missing expected article title", title, expected_title);
    }
}

