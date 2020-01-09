package it.jp.co.sample.jsf.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public abstract class Parts {

  /** header. */
  @FindBy(id = "headerLogo")
  public SelenideElement HeaderLogo;
  @FindBy(id = "logIn")
  public SelenideElement LogIn;
  @FindBy(id = "signUp")
  public SelenideElement SignUp;

  /** footer. */
  @FindBy(id = "footerLogo")
  public SelenideElement FooterLogo;

  /** button. */
  @FindBy(id = "back")
  public SelenideElement Back;
  @FindBy(id = "next")
  public SelenideElement Next;
  @FindBy(id = "confirmed")
  public SelenideElement Confirmed;
  @FindBy(id = "goToTopPage")
  public SelenideElement GoToTopPage;

}
