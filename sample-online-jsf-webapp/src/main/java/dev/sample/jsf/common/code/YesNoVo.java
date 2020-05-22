package dev.sample.jsf.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import dev.sample.common.code.CodeVo;

/**
 * 有無Vo.
 */
@AllArgsConstructor
@Getter
public enum YesNoVo implements CodeVo {

  /** あり. */
  YES("1", "あり"),
  /** なし. */
  NO("0", "なし"),
  ;

  /** コード. */
  private String code;

  /** デコード. */
  private String decode;

}
