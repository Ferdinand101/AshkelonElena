package com.teRan.mish.manager;

import com.teRan.mish.model.NotRegisteredUserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHelper extends HelperBase {


  public UserHelper(WebDriver wd) {
    super(wd);
  }

  public void clickOnRegistrationButton() {
    wd.findElement(By.xpath("//span[contains(.,'Registration')]")).click();
  }

  public void fillCreateAccountForm(NotRegisteredUserData notRegUser) {
    type(By.cssSelector("[formcontrolname=email]"), notRegUser.getMyEmail());
    type(By.cssSelector("[formcontrolname=password]"), notRegUser.getPassword());
    type(By.cssSelector("[formcontrolname=passwordRep]"), notRegUser.getPasswordRep());
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
    wd.findElement(By.xpath("//span[contains(text(), 'Registration')]")).click();

  }

  public void fillLogInForm(String email, String password) {
    type(By.cssSelector("input[formcontrolname=email]"), email);
    type(By.cssSelector("input[formcontrolname=password]"), password);
  }

  public boolean isOnRegistrationPage(){
    return isElementPresent(By.cssSelector(".avatar"));
  }

  public void fillAccountInformationForm(String fName, String lName,
                                         String phone, String religious, String year) {
   type(By.id("inputFirstName"), fName);
   type(By.id("inputLastName"), lName);
   type(By.id("inputPhoneNumber"), phone);

  wd.findElement(By.cssSelector("[placeholder = Confession]")).click();
  wd.findElement(By.xpath("//*[contains(text(), '" + religious +"')]")).click();//"Irreligious");
//open calendar
    wd.findElement(By.xpath("//*[@aria-label='Open calendar']")).click();
//click on button "Choose Year and month
    wd.findElement(By.xpath("//*[@aria-label='Choose month and year']")).click();
//select year
   while (!isYearPresent(year)){
     wd.findElement(By.xpath("//*[@aria-label='Previous 20 years']")).click();
    }
    wd.findElement(By.xpath("//*[contains(text(), '"+year+"')]")).click();
  }

  private boolean isYearPresent(String year) {
    return isElementPresent(By.xpath("//*[contains(text(), '"+year+"')]"));
  }
  
}
