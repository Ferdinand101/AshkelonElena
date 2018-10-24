package com.teRan.mish.manager;

import com.teRan.mish.model.NotRegisteredUserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {

  public UserHelper(WebDriver wd) {
    super(wd);
  }
  public void clickOnRegistrationButton() {
    click(By.xpath("//span[contains(.,'Registration')]"));
  }

  public void fillCreateAccountForm(NotRegisteredUserData notRegUser) {
    type(By.cssSelector("[formcontrolname=email]"), notRegUser.getMyEmail());
    type(By.cssSelector("[formcontrolname=password]"), notRegUser.getPassword());
    type(By.cssSelector("[formcontrolname=passwordRep]"), notRegUser.getPasswordRep());
  }

  public void clickOnCreateAccountButtonOnHeader() {
    click(By.cssSelector("a.paddingLeft.hover.but.mat-button:last-child"));
  }

  public void openCreateAccountForm() {
    click(By.xpath("//span[contains(text(), 'Registration')]"));

  }

  public void fillLogInForm(String email, String password) {
    type(By.cssSelector("input[formcontrolname=email]"), email);
    type(By.cssSelector("input[formcontrolname=password]"), password);
  }

  public boolean isOnRegistrationPage() {
    return isElementPresent(By.cssSelector(".avatar"));
  }

  public void fillPersonalInformationForm(String fName, String lName,
                                          String phone, String religious, String year,
                                          String month, String day) throws InterruptedException {
    type(By.id("inputFirstName"), fName);
    type(By.id("inputLastName"), lName);
    type(By.id("inputPhoneNumber"), phone);

    click(By.cssSelector("[placeholder = Confession]"));
    click(By.xpath("//*[contains(text(), '" + religious + "')]"));

    enterDate(year, month, day);

  }

  public void enterDate(String year, String month, String day) throws InterruptedException {
    click(By.xpath("//*[@aria-label='Open calendar']"));
    click(By.xpath("//*[@aria-label='Choose month and year']"));
    while (!isYearPresent(year)) {
      click(By.xpath("//*[@aria-label='Previous 20 years']"));
    }
    click(By.xpath("//*[contains(text(), '" + year + "')]"));
    waitAndClick(3000, By.xpath("//*[contains(text(), '" + month + "')]"));
    waitAndClick(3000, By.xpath("//div[contains(text(), '" + day + "')]"));
  }

  private boolean isYearPresent(String year) {
    return isElementPresent(By.xpath("//*[contains(text(), '" + year + "')]"));
  }


  public void fillAboutMyselfForm(String status, String foodPref,
                                  String gender, String language, String text) throws InterruptedException {
    chooseOption("Marital Status", status);
    chooseOption("Food Preferences", foodPref);
    escape();
    chooseOption("Gender", gender);
    chooseOption("Languages", language);
    escape();
    type(By.cssSelector("textarea"), text);
  }

  public void chooseOption(String field, String myChoice) throws InterruptedException {
    waitAndClick(3000, By.cssSelector("[placeholder='"+field+"']"));
    waitAndClick(3000, By.xpath("//*[contains(text(), '" + myChoice + "')]"));
  }

  public void chooseTwoOptions(String field, String myChoice, String myChoice2) throws InterruptedException {
    waitAndClick(3000, By.cssSelector("[placeholder='" + field + "']"));
    waitAndClick(3000, By.xpath("//*[contains(text(), '" + myChoice + "')]"));
    waitAndClick(3000, By.xpath("//*[contains(text(), '" + myChoice2 + "')]"));
  }
  public void chooseThreeOptions(String field, String myChoice, String myChoice2, String myChoice3) throws InterruptedException {
    waitAndClick(3000, By.cssSelector("[placeholder='" + field + "']"));
    waitAndClick(3000, By.xpath("//*[contains(text(), '" + myChoice + "')]"));
    waitAndClick(3000, By.xpath("//*[contains(text(), '" + myChoice2 + "')]"));
    waitAndClick(3000, By.xpath("//*[contains(text(), '" + myChoice3 + "')]"));

  }


  public void savePersonalInformationForm() throws InterruptedException {
    waitAndClick(2000, By.cssSelector("[type=submit]"));

  }

  public boolean waitForElementPresent(int millis, By locator) throws InterruptedException {
    Thread.sleep(millis);
    return isElementPresent(locator);
  }
}
