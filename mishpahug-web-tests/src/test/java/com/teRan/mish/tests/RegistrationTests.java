package com.teRan.mish.tests;

import com.teRan.mish.model.NotRegisteredUserData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends  TestBase {


  @BeforeMethod
  public void preConditions(){
    app.getSessionHelper().deleteCookies();
  }



  @Test
  public void registerFromHeaderTest() throws InterruptedException {
    String myEmail = "etr+"+ System.currentTimeMillis() + "@gmail.com";
    System.out.println(myEmail);

    app.getUserHelper().clickOnCreateAccountButtonOnHeader();

    app.getUserHelper().fillCreateAccountForm(new NotRegisteredUserData()
            .setMyEmail(myEmail)
            .setPassword("a123456")
            .setPasswordRep("a123456"));
    app.getUserHelper().clickOnRegistrationButton();

    Thread.sleep(3000);
    Assert.assertTrue(app.isHamburgerDisplayed());

    //Fill account form
    //religious = Irreligious
    app.getUserHelper().fillAccountInformationForm("Moshe", "LastName", "545667788", "Religious", "1974");
  }



  @Test
  public void registrationFromLoginForm() throws InterruptedException {
    String myEmail = "etr+"+ System.currentTimeMillis() + "@gmail.com";

    app.getSessionHelper().clickOnLoginButtonOnHeader();
    Thread.sleep(3000);
    app.getUserHelper().openCreateAccountForm();
    Thread.sleep(3000);
    app.getUserHelper().fillCreateAccountForm(new NotRegisteredUserData()
            .setMyEmail(myEmail)
            .setPassword("a123456")
            .setPasswordRep("a123456"));
    Thread.sleep(3000);
    app.getUserHelper().clickOnRegistrationButton();

    Assert.assertTrue(app.getUserHelper().isOnRegistrationPage());


  }



//  @Test
//  public void registrationFromCreateEvent(){
//
//  }
@AfterMethod
public void postCondition(){
  app.getSessionHelper().logOut();
}

}
