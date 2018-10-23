package com.teRan.mish.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private  UserHelper userHelper;
  private SessionHelper sessionHelper;
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
  }



  public void stop() {
    wd.quit();
  }



  public boolean isHamburgerDisplayed() {
    return wd.findElement(By.cssSelector(".img-responsive#borderRadius"))
            .isDisplayed();
  }

  public void submitLogin() throws InterruptedException {
    Thread.sleep(3000);
    wd.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Log in')]")).click();
    Thread.sleep(3000);
  }



  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  public UserHelper getUserHelper() {
    return userHelper;
  }
}
