package com.tRan.wiki.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WikiLoginTest extends TestBase {
    @Test
    public void  loginTest(){
        if(app.onTheWelcomPage()){
            app.clickOnEnglishLink();
        }
        if(app.getSessionHelper().isLoggedIn()){
            app.getSessionHelper().logout();
        }
        app.getSessionHelper().clickLoginButton();
        app.getSessionHelper().fillLoginForm("LenaTarnovsky", "Tarnovsky1");
        app.getSessionHelper().confirmLogin();

        Assert.assertTrue(app.getSessionHelper().isLoggedIn());
    }


}
