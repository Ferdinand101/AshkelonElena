package com.teRan.mish.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class HelperBase {
  WebDriver wd;
  WebDriverWait wait;

  public HelperBase(WebDriver wd ) {
    this.wd = wd;
   // wait = new WebDriverWait(wd, SECONDS);
  }

  public boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void waitAndClick(int millis, By locator) throws InterruptedException {
    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
   // Thread.sleep(millis);
    click(locator);
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void escape() {
    Actions action = new Actions(wd);
    action.sendKeys(Keys.ESCAPE).build().perform();
  }

  public void chooseOption(String field, String myChoice) throws InterruptedException {
    waitAndClick(3000, By.cssSelector("[placeholder='"+field+"']"));
    waitAndClick(3000, By.xpath("//*[contains(text(), '" + myChoice + "')]"));
  }

  public void clickOnTheSaveButton() throws InterruptedException {
    waitAndClick(2000, By.cssSelector("[type=submit]"));

  }
}
