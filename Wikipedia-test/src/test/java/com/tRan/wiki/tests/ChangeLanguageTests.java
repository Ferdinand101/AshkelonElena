package com.tRan.wiki.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeLanguageTests extends TestBase {
    @Test
    public void openHomePageOnEnglish() {
        app.clickOnEnglishLink();
        String actualUrl = app.getCurrentUrl();
        String expectedURL=
                "https://en.wikipedia.org/wiki/Main_Page";

        Assert.assertEquals(actualUrl, expectedURL);

        app.returnToPreviousPage();
    }

    @Test
    public void openHomePageOnJapanese() {
        app.clickOnJapaneseLink();

        String actualUrl = app.getCurrentUrl();
        String expectedURL=
                "https://ja.wikipedia.org/wiki/%E3%83%A1%E3%82%A4%E3%83%B3%E3%83%9A%E3%83%BC%E3%82%B8";

        Assert.assertEquals(actualUrl, expectedURL);

        app.returnToPreviousPage();
    }



}
