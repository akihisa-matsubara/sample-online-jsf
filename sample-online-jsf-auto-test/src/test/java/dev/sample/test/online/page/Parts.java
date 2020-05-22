package dev.sample.test.online.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public abstract class Parts {

  // header
  @FindBy(id = "headerLogo")
  public SelenideElement headerLogo;
  @FindBy(id = "logIn")
  public SelenideElement logIn;
  @FindBy(id = "signUp")
  public SelenideElement signUp;

  // footer
  @FindBy(id = "footerLogo")
  public SelenideElement footerLogo;

  // button
  @FindBy(id = "back")
  public SelenideElement back;
  @FindBy(id = "next")
  public SelenideElement next;
  @FindBy(id = "confirmed")
  public SelenideElement confirmed;
  @FindBy(id = "goToTopPage")
  public SelenideElement goToTopPage;

}
