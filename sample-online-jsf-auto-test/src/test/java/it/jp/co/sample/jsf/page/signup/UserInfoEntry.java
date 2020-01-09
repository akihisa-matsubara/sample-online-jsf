package it.jp.co.sample.jsf.page.signup;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import it.jp.co.sample.jsf.page.Parts;

public class UserInfoEntry extends Parts {

  @FindBy(id = "username")
  public SelenideElement Username;
  @FindBy(id = "password")
  public SelenideElement Password;

}