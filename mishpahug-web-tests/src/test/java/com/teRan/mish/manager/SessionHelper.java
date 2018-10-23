package com.teRan.mish.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {


  public SessionHelper(WebDriver wd) {
    super(wd);

  }

  public void deleteCookies() {
    wd.manage().deleteAllCookies();
  }
  public boolean isloggedIn() {
    return isElementPresent(By.cssSelector("button [mattooltip='Menu']"));
  }

  public void clickOnLoginButtonOnHeader() {
    wd.findElement(By.xpath("//span[contains(.,'Login')]")).click();
  }


  public void logOut() {
    clickOnHamburgerButton();
    clickOnLogoutButton();
  }

  public void clickOnLogoutButton() {
    wd.findElement(By.xpath("//span[contains(text(),'Log out')]")).click();
  }

  public void clickOnHamburgerButton() {
    wd.findElement(By.cssSelector("button [mattooltip='Menu']")).click();
  }

}
