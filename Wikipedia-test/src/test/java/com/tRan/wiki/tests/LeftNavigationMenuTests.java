package com.tRan.wiki.tests;

import org.testng.annotations.Test;

public class LeftNavigationMenuTests  extends  TestBase{
    @Test
    public void intractionMenuTestVar1(){
        if(app.onTheWelcomPage()){
            app.clickOnEnglishLink();
        }
        app.getLeftNavMenuHelper().getInteractionMenuItemsList();
    }

    @Test
    public void intractionMenuTestVar2(){
        if(app.onTheWelcomPage()){
            app.clickOnEnglishLink();
        }
       app.getLeftNavMenuHelper().getInteractionMenuListVar2();
    }
}
