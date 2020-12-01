package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUI extends MainPageObject{

    protected static String
            MY_LIST_LINK,
            SAVE_LIST_OVERLAY_CLOSE_BUTTON;

    public NavigationUI (AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyLists()
    {
        this.waitForElementAndClick(
                MY_LIST_LINK,
                "Cannot find navigation button to my list",
                10
        );
    }

    public void tapSavedListOverlay()
    {
        this.waitForElementAndClick(
                SAVE_LIST_OVERLAY_CLOSE_BUTTON,
                "Cannot find button 'X' for close overlay",
                5
        );
    }
}
