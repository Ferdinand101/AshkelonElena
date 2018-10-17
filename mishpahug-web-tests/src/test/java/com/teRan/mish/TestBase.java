package com.teRan.mish;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
  WebDriver wd;

  @BeforeClass
  public  void setUp(){
    DesiredCapabilities cap = DesiredCapabilities.chrome();
    cap.setCapability("applicationCacheEnabled", false);
   ChromeOptions options = new ChromeOptions();
    wd = new ChromeDriver(options.addArguments("--disable-notifications"));
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    wd.navigate().to("https://mish.sheygam.com");

  }

  @AfterClass
  public void tearDown(){
wd.quit();
  }

  public void clickOnRegistrationButton() {
    wd.findElement(By.xpath("//span[contains(.,'Registration')]")).click();
  }

  public void fillCreateAccountForm(String myEmail, String password, String passwordRep) {
    type(By.cssSelector("[formcontrolname=email]"), myEmail);
    type(By.cssSelector("[formcontrolname=password]"), password);
    type(By.cssSelector("[formcontrolname=passwordRep]"), passwordRep);
  }

  public void type(By locator, String text) {

    wd.findElement(locator).click();
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void clickOnCreateAccountButtonOnHeader() {
    wd.findElement(By.cssSelector("a.paddingLeft.hover.but.mat-button:last-child")).click();
  }

  public void openCreateAccountForm() {
    wd.findElement(By.xpath("//span[contains(., 'Registration')]")).click();

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
