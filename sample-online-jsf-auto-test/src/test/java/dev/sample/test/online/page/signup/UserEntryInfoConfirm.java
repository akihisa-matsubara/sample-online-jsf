package dev.sample.test.online.page.signup;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import dev.sample.test.online.page.Parts;

public class UserEntryInfoConfirm extends Parts {

  @FindBy(id = "editUserInfo")
  public SelenideElement editUserInfo;
  @FindBy(id = "editDetailInfo")
  public SelenideElement editDetailInfo;

}
