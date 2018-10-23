package com.teRan.mish.model;

public class NotRegisteredUserData {
  private  String myEmail;
  private  String password;
  private  String passwordRep;

  public NotRegisteredUserData setMyEmail(String myEmail) {
    this.myEmail = myEmail;
    return  this;
  }

  public NotRegisteredUserData setPassword(String password) {
    this.password = password;
    return  this;
  }

  public NotRegisteredUserData setPasswordRep(String passwordRep) {
    this.passwordRep = passwordRep;
    return this;
  }

  public String getMyEmail() {
    return myEmail;
  }

  public String getPassword() {
    return password;
  }

  public String getPasswordRep() {
    return passwordRep;
  }
}
