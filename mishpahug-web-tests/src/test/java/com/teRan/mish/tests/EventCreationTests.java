package com.teRan.mish.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EventCreationTests extends TestBase {
  @BeforeMethod
  public void preconditions() throws InterruptedException {
    if(!app.getSessionHelper().isloggedIn()){
      app.getSessionHelper().login();
    }
  }
  @Test
  public void testCreationEventFromEventsList() throws InterruptedException {
    app.getEventHelper().clickOnAddEventButton();
    app.getEventHelper().fillEventForm("txt", "Shabat","Exodus 5, Ashkelon, Israel", "DEC 2018", "28","Irreligious", "Any", "vvv");
    app.getEventHelper().clickOnTheSaveButton();

    app.getUserHelper().clickOnCreateAccountButtonOnHeader();


  }
}
