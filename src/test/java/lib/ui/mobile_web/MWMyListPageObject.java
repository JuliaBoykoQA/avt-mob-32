package lib.ui.mobile_web;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListPageObject extends MyListsPageObject {
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class,'watchList')]//h3[contains(text), '{TITLE}')]";
        REMOVE_FROM_SAVED_BUTTON = "xpath://ul[contains(@class,'watchList')]//h3[contains(text), '{TITLE}')]/../../div[contains(@class, 'watched')]";
        MY_LIST_ARTICLE_CONTAINER = "xpath://li.page-summury.with-watchstar";
    }

    public MWMyListPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
