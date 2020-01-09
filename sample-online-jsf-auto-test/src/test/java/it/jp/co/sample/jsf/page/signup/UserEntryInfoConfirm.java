package it.jp.co.sample.jsf.page.signup;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import it.jp.co.sample.jsf.page.Parts;

public class UserEntryInfoConfirm extends Parts {

  @FindBy(id = "editUserInfo")
  public SelenideElement EditUserInfo;
  @FindBy(id = "editDetailInfo")
  public SelenideElement EditDetailInfo;

}
