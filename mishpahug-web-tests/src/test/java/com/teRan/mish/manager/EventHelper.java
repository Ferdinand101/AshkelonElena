package com.teRan.mish.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EventHelper extends HelperBase {
  public EventHelper(WebDriver wd) {
    super(wd);
  }

  public void clickOnAddEventButton() throws InterruptedException {
    waitAndClick(2000, By.cssSelector("[mattooltip='Add new Event']"));
  }

  public void fillEventForm(String eventName, String holiday, String address, String confession, String food, String text) throws InterruptedException {
    type(By.cssSelector("[placeholder=Title]"), eventName);
   chooseOption("Holiday", holiday);
   type(By.cssSelector("[placeholder='Address']"), address);
   //From (calendar + time
    //To (calendar + time
    chooseOption("Confession", confession);
    chooseOption("Type of kitchen", food);
    type(By.cssSelector("textarea"), text);
clickOnTheSaveButton();

  }


}
