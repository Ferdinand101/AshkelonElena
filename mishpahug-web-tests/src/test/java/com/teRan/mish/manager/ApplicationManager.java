package com.teRan.mish.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private  UserHelper userHelper;
  private SessionHelper sessionHelper;
  private EventHelper eventHelper;
  WebDriver wd;

  public void start() {
    DesiredCapabilities cap = DesiredCapabilities.chrome();
    cap.setCapability("applicationCacheEnabled", false);
//   ChromeOptions options = new ChromeOptions();
    wd = new ChromeDriver();

    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    wd.navigate().to("https://mish.sheygam.com");
    sessionHelper = new SessionHelper(wd);
    userHelper =  new UserHelper(wd);
    eventHelper = new EventHelper(wd);
  }

   public void stop() {
    wd.quit();
  }



  public boolean isHamburgerDisplayed() {
    return wd.findElement(By.cssSelector(".img-responsive#borderRadius"))
            .isDisplayed();
  }





  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  public UserHelper getUserHelper() {
    return userHelper;
  }

  public EventHelper getEventHelper() {
    return eventHelper;
  }
}
