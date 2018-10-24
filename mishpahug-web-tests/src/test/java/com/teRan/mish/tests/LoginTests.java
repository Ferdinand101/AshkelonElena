package com.teRan.mish.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
  @BeforeMethod
  public void preconditions(){
    if (app.getSessionHelper().isloggedIn()){
      app.getSessionHelper().logOut();
    }
  }


  @Test
  public void testLoginRegisteredUser() throws InterruptedException {
    app.getSessionHelper().clickOnLoginButtonOnHeader();
    app.getUserHelper().fillLogInForm("qa15@bii.com", "a123456");
    app.getSessionHelper().submitLogin();

    Thread.sleep(3000);

    Assert.assertTrue(app.getSessionHelper().isloggedIn());
}



}
