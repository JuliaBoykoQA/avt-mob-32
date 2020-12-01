package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase
{
    private static final String name_of_folder = "Learning programming";
    @Test
    public void testSaveFirstArticleToMyList() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubString("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid())
        {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        }
        else
        {
            ArticlePageObject.addArticleToMySaved();
        }
        ArticlePageObject.closeArticle();


        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

        if(Platform.getInstance().isAndroid())
        {
            MyListsPageObject.openFolderByName(name_of_folder);
        }
        else
        {
            MyListsPageObject.swipeByArticleToDelete(article_title);
        }
    }

    @Test
    public void testSaveTwoArticlesToMyList(){

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubString("Object-oriented programming language");
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        ArticlePageObject.addArticleToMySaved();
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);

        NavigationUI.tapSavedListOverlay();
        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();
        SearchPageObject.clickByArticleWithSubString("Programming language");
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.addArticleToMySaved();
        ArticlePageObject.closeArticle();

        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        MyListsPageObject.swipeByArticleToDelete(article_title);

        SearchPageObject.waitForSearchResult("JavaScript");
    }
}
