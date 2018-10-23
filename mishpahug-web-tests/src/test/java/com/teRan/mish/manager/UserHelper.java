package com.teRan.mish.manager;

import com.teRan.mish.model.NotRegisteredUserData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

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

  public void type(By locator, String text) {

    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
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
//open calendar
    click(By.xpath("//*[@aria-label='Open calendar']"));
//click on button "Choose Year and month
    click(By.xpath("//*[@aria-label='Choose month and year']"));
//select year
    while (!isYearPresent(year)) {
      click(By.xpath("//*[@aria-label='Previous 20 years']"));
    }
    click(By.xpath("//*[contains(text(), '" + year + "')]"));
    //select month //*[contains(text(), 'JAN')]
    waitAndClick(month);
    // select day of the month
    Thread.sleep(3000);
    click(By.xpath("//div[contains(text(), '" + day + "')]"));
  }

  public void waitAndClick(String month) throws InterruptedException {
    Thread.sleep(3000);
    click(By.xpath("//*[contains(text(), '" + month + "')]"));
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  private boolean isYearPresent(String year) {
    return isElementPresent(By.xpath("//*[contains(text(), '" + year + "')]"));
  }


  public void fillAboutMyselfForm(String status, String foodPref,
                                  String gender, String language, String text) throws InterruptedException {
    //status
    Thread.sleep(3000);
    click(By.cssSelector("[placeholder='Marital Status']"));
    Thread.sleep(3000);
    click(By.xpath("//*[contains(text(), '" + status + "')]"));
    //food (checkbox)
    Thread.sleep(3000);
    click(By.cssSelector("[placeholder='Food Preferences']"));
    Thread.sleep(3000);
    click(By.xpath("//*[contains(text(), '" + foodPref + "')]"));
    escape();
//gender
    click(By.cssSelector("[placeholder='Gender']"));
    Thread.sleep(3000);
    click(By.xpath("//*[contains(text(), '" + gender + "')]"));

    //lang
    Thread.sleep(3000);
    click(By.cssSelector("[placeholder='Languages']"));
    Thread.sleep(3000);
    click(By.xpath("//*[contains(text(), '" + language + "')]"));

    escape();
    //message
    type(By.cssSelector("textarea"), text);
  }

  public void escape() {

    Actions action = new Actions(wd);

    action.sendKeys(Keys.ESCAPE).build().perform();

  }
}
