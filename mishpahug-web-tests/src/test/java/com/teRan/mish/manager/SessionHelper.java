package com.teRan.mish.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
  UserHelper userHelper = new UserHelper(wd);


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
  public void submitLogin() throws InterruptedException {
    Thread.sleep(3000);
    wd.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Log in')]")).click();
    Thread.sleep(3000);
  }

  public void login() throws InterruptedException {
    clickOnLoginButtonOnHeader();
    userHelper.fillLogInForm("qa15@bii.com", "a123456");
    submitLogin();
  }
}
