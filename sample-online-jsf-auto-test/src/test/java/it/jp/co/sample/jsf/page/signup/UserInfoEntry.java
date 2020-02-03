package it.jp.co.sample.jsf.page.signup;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import it.jp.co.sample.jsf.page.Parts;

public class UserInfoEntry extends Parts {

  @FindBy(id = "username")
  public SelenideElement username;
  @FindBy(id = "email")
  public SelenideElement email;
  @FindBy(id = "password")
  public SelenideElement password;
  @FindBy(id = "passwordConfirm")
  public SelenideElement passwordConfirm;

}
