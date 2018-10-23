package com.teRan.mish.tests;

import com.teRan.mish.manager.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

  protected static ApplicationManager app = new ApplicationManager();

  @BeforeClass
  public  void setUp(){
    app.start();
  }

  @AfterClass
  public void tearDown(){
    app.stop();
  }

}
