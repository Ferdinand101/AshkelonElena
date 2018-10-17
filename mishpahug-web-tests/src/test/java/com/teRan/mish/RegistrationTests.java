package com.teRan.mish;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends  TestBase {


  @BeforeMethod
  public void preConditions(){
  wd.manage().deleteAllCookies();
  }

  @Test
  public void registerFromHeaderTest(){
    String myEmail = "etr+"+ System.currentTimeMillis() + "@gmail.com";
    System.out.println(myEmail);

    clickOnCreateAccountButtonOnHeader();

    fillCreateAccountForm(myEmail, "a123456", "a123456" );
    clickOnRegistrationButton();

    Assert.assertTrue(wd.findElement(By.cssSelector(".img-responsive#borderRadius"))
            .isDisplayed());
  }

//  @Test
//  public void registrationFromLoginForm(){
//    clickOnLoginButtonOnHeader();
//    openCreateAccountForm();
//    fillCreateAccountForm();
//    clickOnRegistrationButton();
//
//    Assert.assertTrue(wd.findElement(By.cssSelector(".img-responsive#borderRadius"))
//            .isDisplayed());
//  }



//  @Test
//  public void registrationFromCreateEvent(){
//
//  }
@AfterMethod
public void postCondition(){
  logOut();
}

}
