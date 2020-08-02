package dev.sample.jsf.common.code;

import dev.sample.common.code.CodeVo;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ボタンタイプVo.
 */
@AllArgsConstructor
@Getter
public enum ButtonTypeVo implements CodeVo {

  /** OK. */
  OK("1", "OK"),
  /** OK and CANCEL. */
  OK_CANCEL("2", "OK and CANCEL"),
  ;

  /** コード. */
  private String code;

  /** デコード. */
  private String decode;

}
