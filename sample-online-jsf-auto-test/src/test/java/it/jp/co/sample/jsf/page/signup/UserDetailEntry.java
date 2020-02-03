package it.jp.co.sample.jsf.page.signup;

import jp.co.sample.common.code.GenderVo;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import it.jp.co.sample.jsf.page.Parts;

public class UserDetailEntry extends Parts {

  public static Map<String, Integer> genderOrderMap;

  static {
    genderOrderMap = new ConcurrentHashMap<String, Integer>();
    for (int i = 0; i < GenderVo.values().length; i++) {
      genderOrderMap.put(GenderVo.values()[i].getCode(), i);
    }
  }

  @FindBy(id = "nameKanji")
  public SelenideElement nameKanji;
  @FindBy(id = "nameKana")
  public SelenideElement nameKana;
  @FindBy(name = "gender")
  public List<SelenideElement> gender;
  @FindBy(id = "birthday")
  public SelenideElement birthday;
  @FindBy(id = "addressZip")
  public SelenideElement addressZip;
  @FindBy(id = "address")
  public SelenideElement address;

}
