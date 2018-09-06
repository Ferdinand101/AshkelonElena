package com.tRan.wiki.tests;

import com.tRan.wiki.manager.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() throws InterruptedException {
        app.start();
       }

    @AfterClass
    public void tearDown(){
        app.stop();
    }


}
