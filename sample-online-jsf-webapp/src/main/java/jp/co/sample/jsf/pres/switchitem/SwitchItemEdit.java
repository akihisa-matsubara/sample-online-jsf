package jp.co.sample.jsf.pres.switchitem;

import java.io.Serializable;
import java.time.LocalDate;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * 画面項目切替 編集.
 */
@RequestScoped
@Named
public class SwitchItemEdit implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** 画面項目切替 画面DTO. */
  @Inject
  private SwitchItemDto dto;

  /**
   * 読込処理.
   */
  public void read() {
    dto.setApplicationDate(LocalDate.now());
  }

}
