package com.teRan.mish.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EventHelper extends HelperBase {
  public EventHelper(WebDriver wd) {
    super(wd);
  }

  public void clickOnAddEventButton() throws InterruptedException {
    waitAndClick(2000, By.cssSelector("[mattooltip='Add new Event']"));
  }

  public void fillEventForm(String eventName, String holiday, String address, String eventFromMonthAndYear, String dayFrom, String confession, String food, String text) throws InterruptedException {
    type(By.cssSelector("[placeholder=Title]"), eventName);
   chooseOption("Holiday", holiday);
   type(By.cssSelector("[placeholder='Address']"), address);
   escape();

    //WebElement from = wd.findElement(By.xpath("//div[@class='paddingZero col-md-12 row'][1]//button[@type='button']"));


    click(By.xpath("//div[@class='paddingZero col-md-12 row'][1]//button[@type='button']"));

    //From (calendar + time)
    String textOnTheButtonMonthAndYear = wd.findElement(By.xpath("//button[@aria-label='Choose month and year']")).getText();
   //Temp func
    System.out.println(textOnTheButtonMonthAndYear);
    if (eventFromMonthAndYear.equals(textOnTheButtonMonthAndYear)){
     //Temp func
      System.out.println(dayFrom);
      selectDay(dayFrom);
    } else click(By.cssSelector("button[aria-label='Next month']"));

    //To (calendar + time)
    chooseOption("Confession", confession);
    chooseOption("Type of kitchen", food);
    type(By.cssSelector("textarea"), text);
clickOnTheSaveButton();

  }

  public void selectDay(String day) {
    click(By.xpath("//div[contains(text(), '" + day + "')]"));

  }


}
