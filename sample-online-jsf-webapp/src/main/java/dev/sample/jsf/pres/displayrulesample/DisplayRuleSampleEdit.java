package dev.sample.jsf.pres.displayrulesample;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * 表示ルールサンプル 編集.
 */
@RequestScoped
@Named
public class DisplayRuleSampleEdit implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** 表示ルールサンプル 画面DTO. */
  @Inject
  private DisplayRuleSampleDto dto;

  /**
   * 読込処理.
   */
  public void read() {
    dto.setItem1("2");
    dto.setItem2("1");
    dto.setItem3("3");
    dto.setItem4("2");
  }

}
